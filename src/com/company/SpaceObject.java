package com.company;

public class SpaceObject {


    public void collide(){}

    // Put here because of future possible feature (Think wormholes)
    public void acellerate(){}

    public void setSpeed(){}

}

class Asteroid extends SpaceObject{
    private int size;

    private void separate(){   }

}

class Shot extends SpaceObject{

}

class Spaceship extends SpaceObject{
    //private int hitPoints;
    private int nrOfShots;
    public void rotate(){}

}

class Player extends Spaceship{


    /**
     * Sets Ship into hyperdrive and (teleports it to a random location on the map with the risk of crashing
     */
    public void hyperDrive(){

    }
}


class UFO extends Spaceship{
    private void autoAim(){

    }
}
