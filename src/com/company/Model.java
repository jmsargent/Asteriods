package com.company;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Model {

    public List<SpaceObject> getNonPlayerSpaceObjects() {
        return nonPlayerSpaceObjects;
    }

    private List<SpaceObject> nonPlayerSpaceObjects;
    private Player p1;

    public Player getP1() {
        return p1;
    }


    public Model() {

        // initiate player in middle of screen
        p1 = new Player(300, 300);

        nonPlayerSpaceObjects = new LinkedList<SpaceObject>();
        nonPlayerSpaceObjects.add(new Asteroid(50, 50, 10, 10));
    }

    /**
     * Updates positioning and potentially adds / removes objects
     */
    public void tick() {
        updateObjectPositioning();
        if(p1.getDy() <= 1)
        p1.setDy(p1.getDy() + 0.01);


        p1.rotateShip("left");
    }

    private void updateObjectPositioning() {
        p1.updatePlayerPos();

        for (SpaceObject nonPlayerSpaceObject : nonPlayerSpaceObjects) {
            nonPlayerSpaceObject.updatePos();
        }
    }
}
