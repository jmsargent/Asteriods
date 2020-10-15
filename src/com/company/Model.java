package com.company;

public class Model {

    private Player p1;

    Model(){

        // initiate player in middle of screen
        p1 = new Player(300,300);
    }

    /**
     * Updates positioning and potentially adds / removes objects
      */
    public void tick(){



        updateObjectPositioning();
        drawObjects();

        p1.updatePlayerPolygon();
    }

}
