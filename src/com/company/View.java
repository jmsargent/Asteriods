package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.List;

public class View extends JFrame {

    private Space space;
    private KeyListener k;

   /* public void setKeyListener(KeyListener k){
        this.addKeyListener(k);
    }*/

    public View(){

        this.space = new Space();
        this.add(space);

        // basic settings for Jframe
        this.setSize(600,600);
        this.setVisible(true);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }






    private class Space extends JPanel{



        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            super.setBackground(Color.BLACK);
            g.setColor(Color.WHITE);
            g.drawOval(50,50,50,50);
        }
    }
}
