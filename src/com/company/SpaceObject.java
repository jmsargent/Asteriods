package com.company;

import java.awt.*;

public class SpaceObject {


    /* TODO
    1) fixa avrundning med polygon i player
    1) Vi har redan updatePos i spaceObj, behöver inte i player
     */

    private Polygon blueprint;
    private int life;
    private double posX;

    public void updatePos(){
        this.posX = this.posX + this.dx;
        this.posY = this.posY + this.dy;
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
    private double dx,dy;

    private Color objColor;

    public void collide(){}

    public void acellerate(){}

}

class Asteroid extends SpaceObject{

    public Asteroid(int x, int y, int dx, int dy){
        this.setPosX(x);
        this.setPosY(y);

        this.setDx(dx);
        this.setDy(dy);
    }
}

class Shot extends SpaceObject{
    private Color shotColor;
}

class Spaceship extends SpaceObject{
    private int nrOfShots;

    public void rotate(){}

}

class Player extends Spaceship{


    public Player(int posX, int posY){
        this.setPosX(posX);
        this.setPosY(posY);

        this.setDx(0);
        this.setDy(0);

        this.setLife(1);
        updatePlayerPolygon();
    }

    public void updatePlayerPos(){
        setPosX(getDx() + getPosX());
        setPosY(getDy() + getPosY());

        updatePlayerPolygon();
    }

    private void updatePlayerPolygon(){

        Polygon p = new Polygon();

        p.addPoint( (int) this.getPosX(),(int) this.getPosY() + 10);
        p.addPoint( (int) this.getPosX() - 10, (int) this.getPosY() - 10);
        p.addPoint( (int) this.getPosX() + 10, (int) this.getPosY() + 10);

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