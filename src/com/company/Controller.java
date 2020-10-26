package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class Controller {

    /*
    TODO:
    1) handle multiple simultaneous keystrokes
     */

    private javax.swing.Timer timer;
    private View view;
    private Model model;
    private Set<Integer> controlPressed;

    public Controller(View view, Model model) {
        this.view = view;
        view.addKeyListener(keyListener);
        this.model = model;
        controlPressed = new HashSet<>();
        timer = new javax.swing.Timer(22, actionListener);
        timer.start();
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.tick();
            view.updateCanvas();
        }
    };

    private KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            //handleInput(e, "keyTyped"); //Not currently in use
        }

        @Override
        public void keyPressed(KeyEvent e) {
            handleInput(e.getKeyCode(), true);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            handleInput(e.getKeyCode(), false);
        }
    };

    private void handleInput(int e, boolean press) {
        controlPressed.forEach(i -> {
            switch (i) {
                case (37) -> model.getPlayer().rotateShip("right");     // right arrow
                case (39) -> model.getPlayer().rotateShip("left");      // left arrow
                case (38) -> model.getPlayer().accelerate(1);           // uparrow
                case (32) -> model.playerFire();                            // if spacebar
                case (27) -> System.exit(0);                          // if esc
                //case(40) -> model.getPlayer().accelerate(-1);


            }
        });

        if (press) {
            controlPressed.add(e);
            System.out.println(e + " has been added");
        } else {
            controlPressed.remove(e);
        }

    }
}
// https://academo.org/demos/rotation-about-point/