package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller extends JPanel implements KeyListener {
    //this is where keyboard inputs go
    public boolean gameOver;
    public boolean exit;
    Asteroid a = new Asteroid();
    Player p = new Player(10,10,1);
    draw2D dd = new draw2D();

    public void Controller(Asteroid ass, draw2D d) {
    this.a = ass;
    this.dd = d;
    }

    public void gameStart(){

    }

    public void addPlayer() {
        this.p = p;
        p.posX =
        p.posY =
        p.life = 1;
        p.color = Color.cyan;

        System.out.println("I'm here!");

    }

    public void addAss(){
        a.newAsteroid(100,100,1,1,3, Color.green);

        System.out.println("I just spawned something");
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key " + e.getKeyCode() + " pressed!");
        if (e.getKeyCode() == 27){
            exit = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released!");
    }
}