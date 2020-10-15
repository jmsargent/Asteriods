package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class Controller{

    private javax.swing.Timer timer;
    private View view;
    private Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;
        timer = new javax.swing.Timer(22, al);

        timer.start();
    }

    private ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.tick();
            view.updateCanvas();
        }
    };

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
