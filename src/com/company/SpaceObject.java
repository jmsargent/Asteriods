package com.company;

import java.awt.*;
import java.awt.geom.Line2D;

public class SpaceObject {

    private int sizeX,sizeY;
    private Polygon blueprint;
    private int life;
    private double posX;
    private double posY;
    private int radius; // used to create hitbox

    // velocity vars
    private double dx, dy;


    // This should exist fix it
    public void move(){
    }

    /* TODO
    1) fixa grafisk model för spaceObjects
    2) översätt angle från rad till deg
    3) Ändra hårdkodning för dx (som är inverterad)
    4) skapa metod move i spaceObject som rör objekt i dess velocitets
       riktining, samt tar hänsyn till objetkets form / storlek
    5) Skapa constructor för player
    6) Skapa move som metod till SpaceObject
    7) Snälla gör alla kordinater till int, det finns inga decimala pixlar
     */

    public int getRadius() {
        return radius;
    }

    public void updatePos() {

        this.posX = this.posX + this.dx;
        this.posY = this.posY + this.dy;


        if (this.posX > 600 + this.sizeX)
            this.posX = -this.sizeX;
        if (this.posX < -this.sizeX)
            this.posX = 600 + this.sizeX;

        if (this.posY > 600 + this.sizeY)
            this.posY = -this.sizeY;
        if (this.posY < -this.sizeY)
            this.posY = 600+this.sizeY;

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
}

class Asteroid extends SpaceObject {

    public Asteroid(int x, int y, double dx, double dy, int lives) {
        this.setPosX(x);
        this.setPosY(y);

        this.setDx(dx);
        this.setDy(dy);

        this.setLife(lives);
    }

}

class Shot extends SpaceObject {

    private double drawFromX,drawFromY;
    private final int shotSize=6;
    private boolean isOutOfBounds;
    private double shotAngle;


    public Shot(double[] tip, double angle, double dx, double dy){
        setShotSpeed(angle);
        setPos(tip[0],tip[1],angle);
        this.shotAngle = angle; // vet att det här är fult
        this.isOutOfBounds = false;
    }

    public boolean isOutOfBounds() {
        return isOutOfBounds;
    }

    public double getDrawFromX() {
        return drawFromX;
    }

    public double getDrawFromY() {
        return drawFromY;
    }

    private void setShotSpeed(double angle){

        double angle2 = angle + 90;

        double[] temp = new double[2];

        temp = MyMath.toCartesian(angle2,5);

        System.out.println("dx:");

        this.setDx(temp[0]);
        this.setDy(temp[1]);
    }

    private void setPos(double x, double y,double angle){

        // Remember that Coordinates work differently than expected when using computer graphics (y inverted)

        if(angle > 0 ||angle < 90){

        }

        this.setPosX(x);
        this.setPosY(y);
    }


    // Does not use polygons hence the different implementation
    private void setBluePrint(){

        double[] dir = MyMath.scaleToLen(this.shotSize,new double[] {this.getDx(),this.getDy()});

        this.drawFromX = this.getPosX() - dir[0];
        this.drawFromY = this.getPosY() - dir[1];
    }

    public void move(){
        this.setPosX(this.getPosX()+this.getDx());
        this.setPosY(this.getPosY()+this.getDy());

        updateOutOfBounds();

        setBluePrint();
    }

    private void updateOutOfBounds(){

        if(this.getPosX()-this.shotSize < 0 || this.getPosX()+this.shotSize > 600 ||
           this.getPosY()-this.shotSize < 0 || this.getPosY()+this.shotSize > 600){
            this.isOutOfBounds = true;
        }

    }
}

class Spaceship extends SpaceObject {


}


class Player extends Spaceship {



    private double[] xPoints;
    private double[] yPoints;
    private int nPoints,gunsReadyTimer;
    private int[] rXPoints, rYPoints;
    private double angle;
    private boolean gunsReady; // limits rate of fire


    public Player(int posX, int posY) {
        this.gunsReady = true;
        this.angle = 0;

        this.gunsReadyTimer = 15; // 1/3 sec rate of fire


        // make doubles later
        this.setPosX(posX);
        this.setPosY(posY);

        this.setDx(0);
        this.setDy(0);


        xPoints = new double[]{0, 10, -10}; // tip , rback , lback
        yPoints = new double[]{20, -10, -10};
        this.nPoints = 3;

        this.setLife(1);
        updatePlayerPolygon();
    }

    public double getAngle() {
        return angle;
    }

    public boolean isGunsReady() {
        return gunsReady;
    }

    public void setGunsReady(boolean gunsReady) {
        this.gunsReady = gunsReady;
    }

    public double[] getTip(){
        return new double[] {this.getPosX() + xPoints[0],this.getPosY() + yPoints[0]};
    }

    public void shoot(){
        this.gunsReady = false;
        System.out.println("pewpew");
    }

    public void decTimers(){

        if(!this.gunsReady){
            this.gunsReadyTimer --;

            if(gunsReadyTimer == 0){
                this.gunsReady = true;
                this.gunsReadyTimer = 15;
                System.out.println("Guns ready");
            }
        }

    }


    // its quirky that this and move in shots exists simoltaneously
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

        //System.out.println(angle);


        xyMerged = MyMath.transposeMatrix(xyMerged);

        // this might work
        this.xPoints = xyMerged[0];
        this.yPoints = xyMerged[1];
    }


    public void accelerate(int dir) {
        double[] vector, maxVector;

        boolean isNegative;
        //System.out.println(this.angle);

        vector = MyMath.toCartesian(this.angle, 0.2);

        this.setDx(this.getDx() - vector[1]); // testa om fungerar
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