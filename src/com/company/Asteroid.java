package com.company;

import java.awt.*;

public class Asteroid extends SpaceObject {

    private int size;


    public void newAsteroid(double x, double y, double dx, double dy, int life, Color cc) {
        //   new
        this.posX = x;
        this.posY = y;
        this.size = life;
        this.dx = dx;
        this.dy = dy;
        this.color = cc;
    }

    public double getAssXdX(){
        return this.posX+this.dx;
    }
    public double getAssYdY(){
        return this.posY+this.dy;
    }
}
