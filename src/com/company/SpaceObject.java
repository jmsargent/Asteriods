package com.company;

public interface SpaceObject {


    // Accellerate Object in its current direction
    public void Acellerate();


    // Decellerate Object in its current direction
    public void Decellerate();

    public void explode();

    public void impact();

    public Coordinates getCoordinates();
}
