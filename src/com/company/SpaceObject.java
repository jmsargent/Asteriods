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

    public double[] rotatePoint(double ang, double[] xyPoint) {
        double angle = ang;
        System.out.println("Ang is" + ang);
        double tempAngPosX;
        double tempAngPosY;

        double[] rotatedPoint = {0,0};

            // new xcord from rotational matrix is calculated by
            rotatedPoint[0] = this.getPosX() * Math.cos(angle) - this.getPosY() * Math.sin(angle);


            // new ycord from rotational matrix is calculated by
            rotatedPoint[1] = this.getPosX() * Math.sin(angle) + this.getPosY() * Math.cos(angle);


            return rotatedPoint;
    }

    public int roundToNearestInt(double d){

        int floor = (int) d;

        if (d-floor < 0.5 ){
            return floor + 1;
        }else {
            return floor;
        }

    }



    public void rotateShip(){

        for (int i = 0; i < this.getBlueprint().npoints; i++) {
        }
    }

}





class Player extends Spaceship {

    private double[] xPoints,yPoints;
    private int nPoints;
    private int[] rXPoints, rYPoints;




    public Player(int posX, int posY) {
        this.setPosX(posX);
        this.setPosY(posY);

        this.setDx(0);
        this.setDy(0);

        xPoints = new double[] {0,5,-5}; // tip , rback , lback
        yPoints = new double[] {5,-5,-5};
        this.nPoints = 3;

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

    private int[] roundedIntArray(double[] a, int size){
        int[] a2 = new int[size];

        for (int i = 0; i < size; i++) {
            a2[i] = roundToNearestInt(a[i]);
        }

        return a2;
    }


    /**
     * Adds constant to every every indice of array
     * @param a
     * @param b
     * @return
     */
    private int[] arrayConstAddition(int a[], int b){

        int[] sum = new int[a.length];


        for (int i = 0; i < a.length; i++) {
            sum[i] = a[i] + b;
        }

        return sum;
    }

    private void updatePlayerPolygon() {


        this.rXPoints = roundedIntArray(this.xPoints,this.xPoints.length);
        this.rYPoints = roundedIntArray(this.yPoints,this.yPoints.length);


        Polygon p = new Polygon( arrayConstAddition( this.rXPoints, roundToNearestInt(this.getPosX()) ),
                                 arrayConstAddition( this.rYPoints, roundToNearestInt(this.getPosY()) ),
                        3);



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