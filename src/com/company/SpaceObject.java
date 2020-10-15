package com.company;

import java.awt.*;

public class SpaceObject {

    private int life;
    private double posX;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    private double posY;

    // velocity vars
    private double dx,dy;

    private Color objColor;

    public void collide(){}

    public void acellerate(){}

}

class Asteroid extends SpaceObject{
    int radi ;
}

class Shot extends SpaceObject{
    private Color shotColor;
}

class Spaceship extends SpaceObject{
    private int nrOfShots;

    public void rotate(){}

}

class Player extends Spaceship{

    public void hyperDrive(){

    }
}

/*
class UFO extends Spaceship{

}
 */