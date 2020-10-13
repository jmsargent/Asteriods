package com.company;

public class Player extends Vessel {

    public final int shipWidth = 2;
    public final int shipHeight = 4;

    public int xPoints[] = {0, shipWidth, shipWidth, shipWidth * 2};
    public int yPoints[] = {0, shipHeight / 4, shipHeight, 0};

    public int ship[][];

    public int[][] makeShip(int xp[], int yp[]) {

        int tempx;
        int tempy;

        for (int i = 0; i < 4; i++) {
            tempx = xp[i];
            tempy = yp[i];
            this.ship[i][i] = ship[tempx][tempy];

        }
        return this.ship;
    }

    public Player(double x, double y, int life) {
        posX = x;
        posY = y;
        this.life = life;
    }


    void rotate(int x, int y) {

    }
}
