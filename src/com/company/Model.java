package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Model {

    public List<SpaceObject> getNonPlayerSpaceObjects() {
        return nonPlayerSpaceObjects;
    }
    private List<Shot> shots;
    private ListIterator shotsIterator;

    public void createShot(){
        this.shots.add(new Shot(p1.getPosX(),p1.getPosY(),p1.getAngle(),p1.getDx(),p1.getDy()));
        addShotTimer();
    }



    private void incShotTimers(){
        for (int i = 0; i < this.shots.size(); i++) {

        }
    }

    private void removeOldestShot(){
        this.shots.remove(this.shots.lastIndexOf(new Shot()));
    }

    public void resetReloadTimer() {
        this.reloadTimer = 0;
    }

    private int reloadTimer;

    public void setReloading(boolean reloading) {
        this.reloading = reloading;
    }

    private boolean reloading = false;

    private List<SpaceObject> nonPlayerSpaceObjects;
    private Player p1;
    private Shot shot;

    public Player getP1() {
        return p1;
    }

    public Model() {
        // initiate player in middle of screen
        p1 = new Player(300, 300);
        shots = new LinkedList<Shot>();



        nonPlayerSpaceObjects = new LinkedList<SpaceObject>();
        nonPlayerSpaceObjects.add(new Asteroid(50, 50, 10, 10));
    }

    /**
     * Updates positioning and potentially adds / removes objects
     */
    public void tick() {
        updateObjectPositioning();

        if(shots.contains(new Shot()))


        if(!p1.isGunsReady())
            reloadTimer++;


        if(reloadTimer == 45){
            p1.setGunsReady(true);
            this.reloadTimer = 0;
            System.out.println("dx is: " + p1.getDx());
            System.out.println("dy is: " + p1.getDy());
        }
    }

    private void updateObjectPositioning() {
        p1.updatePlayerPos();

        for (SpaceObject nonPlayerSpaceObject : nonPlayerSpaceObjects) {
            nonPlayerSpaceObject.updatePos();
        }
    }
}
