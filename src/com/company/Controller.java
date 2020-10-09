package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    //this is where keyboard inputs go





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