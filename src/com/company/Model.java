package com.company;

import java.util.List;

public class Model extends Controller{


    private Player player;
    private List<Asteroid> ass;

    public void addAss(){
        Asteroid ass = new Asteroid(0,0,3);
        System.out.println("I just spawned something");
    }

    private double x, y;

    public void AddModel(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //public getShip(){


    //}


    public int GetIntX(){
        return (int)x;
    }
    public int GetIntY(){
        return (int)y;
    }
}
