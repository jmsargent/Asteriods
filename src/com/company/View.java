package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;

public class View extends JFrame {


    private Model model;
    private Space space;
    private KeyListener k;

   /* public void setKeyListener(KeyListener k){
        this.addKeyListener(k);
    }*/

    public void setKeyListener(KeyListener k) {
        this.k = k;
    }

    public View(Model model) {

        this.model = model;
        this.space = new Space();
        this.add(space);
        this.addKeyListener(this.k);
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


        private List<Polygon> toDraw = new LinkedList<>();
        private Iterator<Polygon> toDrawIt = toDraw.iterator();


        /*
        public void updateToDraw(){
            for (int i = 0; i <model.getNonPlayerSpaceObjects().size() ; i++) {
                toDraw.add(model.getNonPlayerSpaceObjects().get(i).getBlueprint());
            }
        }*/


        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            super.setBackground(Color.BLACK);
            //g.setColor(Color.WHITE);
            //g.drawOval(50,50,50,50);
            drawPlayer(g);
            drawShots(g);
            drawBigAsteroids(g);
            g.setColor(Color.GRAY);
            //g.line
            /*
            while (toDrawIt.hasNext()){
                g.fillPolygon(toDrawIt.next());
            }
             */
        }


        private void drawPlayer(Graphics g) {
            g.setColor(Color.RED);
            g.fillPolygon(model.getP1().getBlueprint());
        }


        private void drawShots(Graphics g) {
            g.setColor(Color.GREEN);

            int x1, x2, y1, y2;

            for (int i = 0; i < model.getShotArray().length; i++) {

                if (model.getShotArray()[i] != null) {
                    x2 = (int) model.getShotArray()[i].getPosX();
                    y2 = (int) model.getShotArray()[i].getPosY();
                    x1 = (int) model.getShotArray()[i].getDrawFromX();
                    y1 = (int) model.getShotArray()[i].getDrawFromY();

                    g.drawLine(x1, y1, x2, y2);
                }
                /*System.out.println("x1 :" +x1);
                System.out.println("x2 :" +x2);
                System.out.println("y1 :" +y1);
                System.out.println("y2 :" +y2);*/
            }
        }

        private void drawBigAsteroids(Graphics g) {
            g.setColor(Color.CYAN);

            for (int i = 0; i < model.getBigAsteroidArr().length; i++) {

                g.fillOval(
                        (int) model.getBigAsteroidArr()[i].getPosX(),
                        (int) model.getBigAsteroidArr()[i].getPosY(),
                        model.getBigAsteroidArr()[i].getLife() * 50,
                        model.getBigAsteroidArr()[i].getLife() * 50
                );
            }
        }
    }
}
