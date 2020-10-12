package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit.*;
import java.awt.event.KeyListener;

public class View extends JFrame {



    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWindowSize();
        Space space = new Space();
        
        this.add(space);
        this.setVisible(true);
    }

    /**
     * Sets the size of the window to half of the resolution width and height
     */
    private void setWindowSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() / 2;
        double height = screenSize.getHeight() / 2;
    }

    private static class Space extends JPanel {


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // draw stuff
            g.drawOval(50, 50, 50, 50);
            drawPlayer(100, 100, g);
        }

        /**
         * Draws the player ship
         *
         * @param x X coordinate for ship nose
         * @param y Y coordinate for ship nose
         */
        private static void drawPlayer(int x, int y, Graphics g) {

            Polygon p = new Polygon();

            // Create triangle

            p.addPoint(x,y);
            p.addPoint(x+5,y-10);
            p.addPoint(x-5,y-10);

            // Draw polygon only takes arrays
            g.fillPolygon(p);

        }

        /**
         * @param x x cordinate for the center of the asteroid
         * @param y y coordinate for the center of the asteroid
         */

        private static void drawAsteroid(int x, int y, int size, Graphics g) {
            g.drawOval(x, y, size, size);
        }

        /**
         * @param y      x Coordinate for the tip of the shot
         * @param x      x Coordinate for the tip of the shot
         * @param length Length of projektile
         */

        private static void drawShot(int x, int y, int length) {

        }

        private static void drawUFO() {

        }

        private static void drawWormhole() {

        }

    }
}
