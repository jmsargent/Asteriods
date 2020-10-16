package com.company;

import java.awt.*;

public class SpaceObject {


    /* TODO
    1) fixa avrundning med polygon i player
    2) Vi har redan updatePos i spaceObj, behöver inte i player
    3) fixa grafisk model för spaceObjects
    4) Fixa avrundning i polygon med spaceObjects
     */

    private Polygon blueprint;
    private int life;
    private double posX;

    public void updatePos() {

        this.posX = this.posX + this.dx;
        this.posY = this.posY + this.dy;


        if (this.posX > 609)
            this.posX = -9;
        if (this.posX < -9)
            this.posX = 609;

        if (this.posY > 609)
            this.posY = -9;
        if (this.posY < -9)
            this.posY = 609;


        updatePolygon();
    }

    private void updatePolygon() {
        Polygon p = new Polygon();

        p.addPoint((int) this.posX - 3, (int) this.posY - 1);
        p.addPoint((int) this.posX - 1, (int) this.posY - 1);
        p.addPoint((int) this.posX - 1, (int) this.posY - 3);
        p.addPoint((int) this.posX + 1, (int) this.posY - 3);
        p.addPoint((int) this.posX + 1, (int) this.posY - 1);
        p.addPoint((int) this.posX + 3, (int) this.posY - 1);
        p.addPoint((int) this.posX + 3, (int) this.posY + 1);
        p.addPoint((int) this.posX + 1, (int) this.posY + 1);
        p.addPoint((int) this.posX + 1, (int) this.posY + 3);
        p.addPoint((int) this.posX - 1, (int) this.posY + 3);
        p.addPoint((int) this.posX - 1, (int) this.posY + 1);
        p.addPoint((int) this.posX - 3, (int) this.posY + 1);

        this.blueprint = p;
    }


    public Polygon getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Polygon blueprint) {
        this.blueprint = blueprint;
    }

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
    private double dx, dy;

    private Color objColor;

    public void collide() {
    }

    public void acellerate() {
    }

}

class Asteroid extends SpaceObject {

    public Asteroid(int x, int y, int dx, int dy) {
        this.setPosX(x);
        this.setPosY(y);

        this.setDx(dx);
        this.setDy(dy);
    }
}

class Shot extends SpaceObject {
    private Color shotColor;
}

class Spaceship extends SpaceObject {
    private int nrOfShots;
    double angle;

    public void rotate(double ang) {
        double angle = ang;
        System.out.println("Ang is" + ang);
        double tempAngPosX;
        double tempAngPosY;
        if (angle <= 0) {
            tempAngPosX = this.getPosX() * Math.cos(angle) - this.getPosY() * Math.sin(angle);
            this.setPosX(tempAngPosX);
        }
        if (angle >= 0) {
            tempAngPosY = this.getPosX() * Math.sin(angle) + this.getPosY() * Math.cos(angle);
            System.out.println("TempAngPosY = " + tempAngPosY);
            this.setPosY(tempAngPosY);
        }
    }
}

class Player extends Spaceship {


    public Player(int posX, int posY) {
        this.setPosX(posX);
        this.setPosY(posY);

        this.setDx(0);
        this.setDy(0);

        this.setLife(1);
        updatePlayerPolygon();
    }

    public void updatePlayerPos() {
        setPosX(getDx() + getPosX());
        setPosY(getDy() + getPosY());


        if (this.getPosX() > 604)
            this.setPosX(-4);
        if (this.getPosX() < -4)
            this.setPosX(604);

        if (this.getPosY() > 604)
            this.setPosY(-4);
        if (this.getPosY() < -4)
            this.setPosY(604);

        updatePlayerPolygon();
    }

    private void updatePlayerPolygon() {

        Polygon p = new Polygon();

        p.addPoint((int) this.getPosX(), (int) this.getPosY() + 10);
        p.addPoint((int) this.getPosX() - 8, (int) this.getPosY() - 10);
        p.addPoint((int) this.getPosX(), (int) this.getPosY() - 5);
        p.addPoint((int) this.getPosX() + 8, (int) this.getPosY() - 10);

        this.setBlueprint(p);
    }

    /*
    public void hyperDrive(){

    }*/
}

/*
class UFO extends Spaceship{

}
 */