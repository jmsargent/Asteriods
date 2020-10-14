package com.company;

import java.util.List;

public class Model extends Controller{


    public Player player;
    private List<Asteroid> ass;



    private double x, y;

    public void AddModel(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void getShip(){
        player = super.p;
    }

}
