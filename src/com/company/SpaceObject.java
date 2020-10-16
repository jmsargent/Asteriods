package com.company;

import java.awt.*;

public class SpaceObject {


    /* TODO
    1) fixa grafisk model för spaceObjects
    2) översätt angle från rad till deg
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


}


class Player extends Spaceship {

    private double[] xPoints, yPoints;
    private int nPoints;
    private int[] rXPoints, rYPoints;
    private double angle;


    public Player(int posX, int posY) {

        this.angle = 0;
        // make doubles later
        this.setPosX(posX);
        this.setPosY(posY);

        this.setDx(0);
        this.setDy(0);


        xPoints = new double[]{0, 10, -10}; // tip , rback , lback
        yPoints = new double[]{10, -10, -10};
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


    private void updatePlayerPolygon() {


        this.rXPoints = MyMath.roundedIntArray(this.xPoints, this.xPoints.length);
        this.rYPoints = MyMath.roundedIntArray(this.yPoints, this.yPoints.length);


        Polygon p = new Polygon(MyMath.arrayConstAddition(this.rXPoints, MyMath.roundToNearestInt(this.getPosX())),
                MyMath.arrayConstAddition(this.rYPoints, MyMath.roundToNearestInt(this.getPosY())),
                3);


        this.setBlueprint(p);
    }

    public void rotateShip(String dir) {


        double[][] xyMerged = new double[3][2]; // 0 = tip , 1 = back right , 2 = left back

        for (int i = 0; i < 3; i++) {
            xyMerged[i] = MyMath.mergeXY(xPoints[i], yPoints[i]);
        }

        if (dir == "left") {
            for (int i = 0; i < 3; i++) {
                xyMerged[i] = MyMath.rotatePoint(6, xyMerged[i]);
            }
            this.angle += 6;
        } else {
            for (int i = 0; i < 3; i++) {
                xyMerged[i] = MyMath.rotatePoint(-6, xyMerged[i]);
            }
            this.angle += -6;
        }

        this.angle %= 360;

        System.out.println(angle);


        xyMerged = MyMath.transposeMatrix(xyMerged);

        // this might work
        this.xPoints = xyMerged[0];
        this.yPoints = xyMerged[1];
    }


    public void accelerate() {
        double[] vector, maxVector;

        boolean isNegative;
        System.out.println(this.angle);

        isNegative = MyMath.isNegative(this.angle);

        vector = MyMath.toCartesian(Math.abs(this.angle), 0.1);

        this.setDx(this.getDx() + vector[1]);
        this.setDy(this.getDy() + vector[0]);

    }

    /*
    public void hyperDrive(){

    }*/
}

/*
class UFO extends Spaceship{

}
 */