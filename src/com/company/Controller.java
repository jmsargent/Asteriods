package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class Controller{

    /*
    TODO:
    1) handle multiple simultaneous keystrokes
     */

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
        //System.out.println(metodId);
        System.out.println( e.getKeyCode()) ;
        //27
        switch (e.getKeyCode()){
            case (37): // right arrow
                model.getP1().rotateShip("right");
                break;
            case(39): // left arrow
                model.getP1().rotateShip("left");
                break;
            case(38): // uparrow
                model.getP1().accelerate(1);
                break;
            case(32): // if spacebar
                model.playerFire();
                break;
            case(27): // if esc
                System.exit(0);
        }

        /*
        case(40):
        model.getP1().accelerate(-1);
        break;
        */
    }

    // Should this be in model or in controller ?

}
// https://academo.org/demos/rotation-about-point/