package com.company;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;

public class Controller {

    private Model model;
    private View view;


    public Controller(Model model, View view){
        this.model = model;
        this.view = view;

    }


    /**
     * Identifies what keys are pressed/released and forwards to correct game functionality.
     * @param e
     * @param identifier
     */
    private void handleInput(KeyEvent e,String identifier){

        int id = e.getID(); // what type of keyEvent
        char c;


        // Since getKeyChar is only reliable from the method KeyTyped, returns caps-sensitive key
        if(id == KeyEvent.KEY_TYPED){c = e.getKeyChar();
            System.out.println(e.getKeyChar());
            System.out.println("keyPressed");
        }else{
            switch ( e.getKeyCode() ){
                case( KeyEvent.VK_W ):
                    System.out.println("keyPressed2");

                    System.out.println(e.getKeyCode());
                    System.out.println(e.getKeyCode());
                    break;
                case( KeyEvent.VK_S ):
                    System.out.println("keyPressed2");
                    System.out.println(e.getKeyCode());
                    break;
                case( KeyEvent.VK_A ):
                    System.out.println("keyPressed2");
                    System.out.println(e.getKeyCode());
                    break;
                case( KeyEvent.VK_D ):
                    System.out.println("keyPressed2");
                    System.out.println(e.getKeyCode());
                    break;
                case( KeyEvent.VK_SPACE ):
                    System.out.println("keyPressed2");
                    System.out.println(e.getKeyCode());
                    break;
            }

        }

        // e.VK_ static fields containing all keybindings




    }


    @Override
    public void keyTyped(KeyEvent e) {
        handleInput(e,"keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        handleInput(e,"keyPressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        handleInput(e,"keyReleased");
    }
}