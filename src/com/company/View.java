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

    public void setKeyListener (KeyListener k){
        this.k = k;
    }

    public View(Model model){

        this.model=model;
        this.space = new Space();
        this.add(space);
        this.addKeyListener(this.k);
        // basic settings for Jframe
        this.setSize(600,600);
        this.setVisible(true);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateCanvas(){
        this.space.repaint();
    }

    private class Space extends JPanel{

        private List<Polygon> toDraw = new LinkedList<>();
        private Iterator<Polygon> toDrawIt = toDraw.iterator();


        public void updateToDraw(){
            for (int i = 0; i <model.getNonPlayerSpaceObjects().size() ; i++) {
                toDraw.add(model.getNonPlayerSpaceObjects().get(i).getBlueprint());
            }
        }


        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            super.setBackground(Color.BLACK);
            g.setColor(Color.WHITE);
            g.drawOval(50,50,50,50);
            g.setColor(Color.RED);
            g.fillPolygon(model.getP1().getBlueprint());

            g.setColor(Color.GRAY);
            while (toDrawIt.hasNext()){
                g.fillPolygon(toDrawIt.next());
            }
        }
    }
}
