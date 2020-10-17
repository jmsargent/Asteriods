package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Model {

    private List<SpaceObject> getNonPlayerSpaceObjects() {
        return nonPlayerSpaceObjects;
    }
    private LinkedList<Shot> shots;


    private ListIterator shotsIterator;
    private List<SpaceObject> nonPlayerSpaceObjects;
    private Player p1; //= new Player(300, 300);
    private Shot shot;


    public Model() {
        // initiate player in middle of screen
        p1 = new Player(300, 300);
        shots = new LinkedList<Shot>();
        shotsIterator = shots.listIterator();


    //    nonPlayerSpaceObjects = new LinkedList<SpaceObject>();
    //    nonPlayerSpaceObjects.add(new Asteroid(50, 50, 10, 10));
    }

    public LinkedList<Shot> getShots() {
        return shots;
    }


    private void createShot(){
       this.shots.add(new Shot(p1.getPosX(),p1.getPosY(),p1.getAngle(),p1.getDx(),p1.getDy()));

    }

    public void playerFire(){
        if(p1.isGunsReady() && p1.getAmmo() > 0){
            p1.shoot();
            createShot();
        }
    }




    public Player getP1() {
        return p1;
    }

    /**
     * Updates positioning and potentially adds / removes objects
     */
    public void tick() {
        updateObjectPositioning();
        updateTimers();
        //System.out.println("dx is: " + p1.getDx());
        //System.out.println("dy is: " + p1.getDy());

    }

    private void updateTimers(){
        p1.decTimers();
    }

    private void updateObjectPositioning() {
        p1.updatePlayerPos();

        updateShotsPositioning();

        /*for (SpaceObject nonPlayerSpaceObject : nonPlayerSpaceObjects) {
            nonPlayerSpaceObject.updatePos();
        }*/
    }
    private void updateShotsPositioning(){


     while(this.shotsIterator.hasNext()){
         Shot currentShot = (Shot) shotsIterator.next();
         if(currentShot.isOutOfBounds())
             shotsIterator.remove();
     }
    }
}
