package com.company;

import javax.swing.*;
import java.awt.*;

public class SpaceObject{

    public Color color;
    //Life for ship, will convert also "convert" to size of Asteroids
    public int life;
    //Current position of object on panel
    public double posX;
    public double posY;
    //Delta (ie direction of movement) of position
    public double dx;
    public double dy;
    //returns current pos(x/y or life)
    public double getPosX(){ return posX; }
    public double getPosY(){ return posY; }
    public double getLife(){ return life; }

    public void moveSO(){


    }

}


 /*   // Accellerate Object in its current direction
    public void Acellerate(x,y);


    // Decellerate Object in its current direction
    public void Decellerate(x,y);

    public void explode();

    public void impact();

    public Coordinates getCoordinates();


  */
