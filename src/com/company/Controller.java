package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller extends JFrame implements KeyListener {
    //this is where keyboard inputs go

    public JFrame f = new JFrame("Asteroirds");
    public JPanel g = new JPanel();
    public Player p = new Player(x,y,z);


    void frameBoard() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.setLocation(20, 20);
        g.setBackground(Color.black);
        f.addKeyListener(this);
        f.add(g);
        f.setVisible(true);
        f.repaint();

        f.add(p);
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released!");
    }
}