package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller {

    private View view;
    private Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;

        view.addKeyListener(kl);
    }

    private KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            doStuff(e, "keyTyped");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            doStuff(e, "keyTyped");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            doStuff(e, "keyTyped");
        }
    };


    private void doStuff(KeyEvent e, String metodId){
        System.out.println("1");
    }


}
