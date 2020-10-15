package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class Controller{

    Timer t ;
    ActionListener a;
    private View view;
    private Model model;

    public Controller(View view, Model model){
        this.view = view;
        this.model = model;

        this.a = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        };

        t = new Timer(22,a).start();
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
    private void tick (){

    }


}
