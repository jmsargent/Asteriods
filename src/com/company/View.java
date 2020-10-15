package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;

public class View extends JFrame {

    private Space space;
    private KeyListener k;

    public View (KeyListener k){

        this.k = k;
        this.space = new Space();
        this.add(space);

        // basic settings for Jframe
        this.setSize(600,600);
        this.setVisible(true);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




    private class Space extends JPanel{

        private List<Polygon> paintobjects;
        private Player player = new Player();

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);


            drawGraphicObjects(g);

        }



        private void drawGraphicObjects(Graphics g){
            for (int i = 0; i <paintobjects.size(); i++) {
                g.fillPolygon(paintobjects.get(i));
            }
        }

        private void addGraphicObjects(Polygon p){

            paintobjects.add(p);

        }

        public void storeGraphics(int xPoints[], int yPoints[], int nrOfPoints){
            Polygon p = new Polygon(xPoints,yPoints,nrOfPoints);
            addGraphicObjects(p);
        }

    }
}
