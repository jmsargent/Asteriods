package com.company;

public class Player extends Vessel {

    private int shipWidth = 10;
    private int shipHeight = 14;

    public void setPSize(int width, int height){
        if(width < 10 || height < 14){
            shipWidth = 10;
            shipHeight = 14;
        } else{
            shipWidth=width;
            shipHeight=height;
        }
    }


    public int xPoints[] = {shipWidth, shipWidth*2, shipWidth*3, shipWidth*2};
    public int yPoints[] = {shipHeight*2, shipHeight+shipWidth, shipHeight*2,shipHeight/2};

    public int ship[][];

    public Player() {
        this.xPoints = xPoints;
        this.yPoints = yPoints;

    }
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
