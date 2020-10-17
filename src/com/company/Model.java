package com.company;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Model {

    private Shot[] shotArray;

    private Player p1; //= new Player(300, 300);
    private Shot shot;


    public Model() {
        // initiate player in middle of screen
        p1 = new Player(300, 300);
        shotArray = new Shot[4];

        for (int i = 0; i < 4; i++) {
            shotArray[i] = null;
        }

        //    nonPlayerSpaceObjects = new LinkedList<SpaceObject>();
        //    nonPlayerSpaceObjects.add(new Asteroid(50, 50, 10, 10));
    }

    public Shot[] getShotArray() {
        return shotArray;
    }

    /**
     * Creates shot in first empty position of array if there are any empty slots
     */
    private void createShot() {

        for (int i = 0; i < 4; i++) {

            if(shotArray[i] == null){
                shotArray[i] = new Shot(p1.getPosX(), p1.getPosY(), p1.getAngle());
                break ;
            }

        }
        System.out.println("angle :" + p1.getAngle());

        /*
        System.out.println(p1.getPosX());
        System.out.println(p1.getPosY());
        System.out.println(p1.getDx());
        System.out.println(p1.getDy());
         */
    }

    public void playerFire() {
        if (p1.isGunsReady()) {
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

        updateTimers();
        updateObjectPositioning();
        //System.out.println("dx is: " + p1.getDx());
        //System.out.println("dy is: " + p1.getDy());

    }

    private void updateTimers() {
        p1.decTimers();
    }

    private void updateObjectPositioning() {
        p1.updatePlayerPos();

        updateShotsPositioning();

        /*for (SpaceObject nonPlayerSpaceObject : nonPlayerSpaceObjects) {
            nonPlayerSpaceObject.updatePos();
        }*/
    }

    /**
     * updates position of all shots
     */
    private void updateShotsPositioning() {
            for (int i = 0; i < 4; i++) {
                if (shotArray[i] != null) {
                    shotArray[i].move();

                    if(shotArray[i].isOutOfBounds()){
                        shotArray[i] = null;
                    }

                }
            }

    }
}
