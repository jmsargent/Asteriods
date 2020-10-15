package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller implements KeyListener {
    //this is where keyboard inputs go
    public boolean gameOver;
    public boolean exit;
    //Asteroid a = new Asteroid();
    Player p = new Player();
    draw2D dd = new draw2D();
    Polygon pol = new Polygon();
    Rotate2D rot = new Rotate2D();

    public void Controller(draw2D d, Rotate2D rot) {
        //  this.a = ass;
        this.dd = d;
        this.rot = rot;


    }

    public void gameStart() {

    }

    public void movPlayer(String s) {
        if (s.equals("faster")) {

            p.posX = p.posX + 10;

            System.out.println("I added +10 to x... I think");
        } else if (s.equals("slower")) {

        }


        System.out.println("I'm here!");

    }

   /* public void addAss() {
        a.newAsteroid(100, 100, 1, 1, 3, Color.green);

        System.out.println("I just spawned something");
    }*/

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key " + e.getKeyCode() + " pressed!");
        if (e.getKeyCode() == 27) {
            exit = true;
        } else if (e.getKeyCode() == 38) {
            movPlayer("faster");
            System.out.println("can hast fast?");

        } else if (e.getKeyCode() == 40) {
            movPlayer("slower");
            System.out.println("slowmo?");

        } else if (e.getKeyCode() == 37) {
            movPlayer("rotLeft");
        } else if (e.getKeyCode() == 39) {
            movPlayer("rotRight");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    static class Rotate2D {

        public double getRotX(double x, double y, double angle) {
            return x * Math.cos(angle) - y * Math.sin(angle);
        }

        public double getRotY(double x, double y, double angle) {
            return x * Math.sin(angle) + y * Math.cos(angle);
        }

    }
}