package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class View extends JFrame {

    // class vars
    private Model model;
    private Space space;
    private KeyListener k;

    // constructors

    public View(Model model) {

        this.model = model;
        this.space = new Space();
        this.add(space);

        // basic settings for Jframe
        this.setSize(600, 600);
        this.setVisible(true);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateCanvas() {
        this.space.repaint();
    }

    private class Space extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            super.setBackground(Color.BLACK);

            drawSO(g);

            if (model.isGameOver())
                paintGameOver(g);
        }

        private void drawSO(Graphics g) {
            g.setColor(Color.RED);
            drawPlayer(g);

            g.setColor(Color.GREEN);
            drawShots(g);

            g.setColor(Color.CYAN);
            drawAsteroids(g);
        }

        private void drawPlayer(Graphics g) {
            g.fillPolygon(model.getPlayer().getBlueprint());
        }

        private void drawShots(Graphics g) {

            int[] points;

            for (Shot shot : model.getShotArray()) {

                if (shot != null) {
                    points = shot.getBluePrint();
                    g.drawLine(points[0], points[1], points[2], points[3]);
                }
            }
        }

        private void drawAsteroids(Graphics g) {

            for (Asteroid asteroid : model.getAsteroidArr()) {
                if (asteroid != null) {
                    g.fillOval(
                            (int) asteroid.getPosX(), (int) asteroid.getPosY(),
                            asteroid.getLife() * 33, asteroid.getLife() * 33
                    );
                }
            }
        }

        private void paintGameOver(Graphics g) {
            super.setBackground(Color.WHITE);
            g.setColor(Color.BLACK);
            g.drawString("Game Over", 300, 300);
        }
    }
}
