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
        view.addKeyListener(kl);
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
            handleInput(e, "keyTyped");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            handleInput(e, "keyPressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            handleInput(e, "keyReleased");
        }
    };

    private void handleInput(KeyEvent e, String metodId){
        System.out.println(metodId);
        System.out.println( e.getKeyCode()) ;

        switch (e.getKeyCode()){
            case (37):
                model.getP1().rotateShip("right");
                break;
            case(39):
                model.getP1().rotateShip("left");
                break;
            case(38):
                model.getP1().accelerate();
                System.out.println("du borde inte se mig");
                break;
        }

    }

}
// https://academo.org/demos/rotation-about-point/