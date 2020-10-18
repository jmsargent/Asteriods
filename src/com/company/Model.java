package com.company;

import java.util.*;

public class Model {

    private Shot[] shotArray;
    private boolean gameOver;
    private Asteroid[] asteroidArr;
    Random rand;
    private Player p1; //= new Player(300, 300);

    public boolean isGameOver() {
        return gameOver;
    }

    public Asteroid[] getAsteroidArr() {
        return asteroidArr;
    }

    public Model() {
        // initiate player in middle of screen
        p1 = new Player(300, 300);
        shotArray = new Shot[4];
        rand = new Random();
        gameOver = false;
        spawnAsteroids(4, 3);

        for (int i = 0; i < 4; i++) {
            shotArray[i] = null;
        }
    }

    public Shot[] getShotArray() {
        return shotArray;
    }

    /**
     * Creates shot in first empty position of array if there are any empty slots
     */
    private void createShot() {

        for (int i = 0; i < 4; i++) {
            if (shotArray[i] == null) {
                System.out.println("tipX:" + p1.getTip()[0]);
                System.out.println("tipY:" + p1.getTip()[1]);
                shotArray[i] = new Shot(p1.getTip(), p1.getAngle(), p1.getDx(), p1.getDy());
                break;
            }
        }
        System.out.println("angle :" + p1.getAngle());
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
        if (!gameOver) {
            updateTimers();
            updateObjectPositioning();
            calcColissions();
        }
    }

    private void updateTimers() {
        p1.decTimers();
    }

    private void updateObjectPositioning() {
        p1.updatePlayerPos();

        updateShotsPositioning();
        updateAsteroidPositioning();
    }

    private void updateAsteroidPositioning() {
        for (int i = 0; i < this.asteroidArr.length; i++) {
            if (this.getAsteroidArr()[i] != null) {
                this.asteroidArr[i].updatePos();
            }
        }
    }

    /**
     * updates position of all shots
     */
    private void updateShotsPositioning() {
        for (int i = 0; i < 4; i++) {
            if (shotArray[i] != null) {
                shotArray[i].move();

                if (shotArray[i].isOutOfBounds()) {
                    shotArray[i] = null;
                }
            }
        }
    }

    private void spawnAsteroids(int nrOfAsteroids, int lives) {

        int[] validSpawnLocation = getValidSpawnLocation();
        double[] randomVelocity = getRndBigVel();

        this.asteroidArr = new Asteroid[nrOfAsteroids * lives];

        for(int i = 0 i < 4)
        createNewAsteroids(nrOfAsteroids, lives,validSpawnLocation);
    }

    private void createNewAsteroids(int nrOfAsteroids, int lives, int[] spawnLocation) {

        double[] randomVelocity = getRndBigVel();
        for (int i = 0; i < nrOfAsteroids; i++) {
            if (this.asteroidArr[i] == null) {
                // note for self : x,y,dx,dy
                this.asteroidArr[i] = new Asteroid(spawnLocation[0], spawnLocation[1], randomVelocity[0], randomVelocity[1], lives);
                validSpawnLocation = getValidSpawnLocation();
                randomVelocity = getRndBigVel();
            }
        }
    }

    /**
     * returns as {latitude, coordinate}
     *
     * @return
     */
    private int[] getValidSpawnLocation() {

        // 1-north 2-east 3-west 4-south

        int latitude = this.rand.nextInt() % 4;
        int coordinate = this.rand.nextInt() % 300;

        switch (latitude) {
            case (1): // north
                return new int[]{0, coordinate};
            case (2):
                return new int[]{coordinate, 600};
            case (3):
                return new int[]{coordinate, 0};
            case (4):
                return new int[]{600, coordinate};
            default:
                return new int[]{6000, 6000}; // this will never happen but compiler complains if i dont
        }
    }

    private double[] getRndBigVel() {

        // I had to, sorry , I know it doesn't follow conventions
        double MaxWell = 1.2;

        return new double[]{(0.5 + rand.nextDouble()) % MaxWell, (0.5 + rand.nextDouble()) % MaxWell};
    }

    private void calcColissions() {
        calcShotAsteroidCollision();
        calcPlayerAsteroidCollision();
    }

    private void calcShotAsteroidCollision() {

        double[] difference;
        double distance;

        for (int i = 0; i < this.shotArray.length; i++) {
            for (int j = 0; j < this.asteroidArr.length; j++) {
                // if both currently compared indices contain any obj...
                if (this.shotArray[i] != null && this.asteroidArr[j] != null) {
                    // ...calc distance between the tip of the shot and the middlepoint of the asteroid
                    difference = MyMath.vectorSubtraction(
                            new double[]{this.shotArray[i].getPosX(), this.shotArray[i].getPosY()},
                            new double[]{this.asteroidArr[j].getPosX(), this.asteroidArr[j].getPosY()}
                    );

                    distance = MyMath.vectorLength(difference);

                    // if distance between points is less than the radius of the asteroid
                    if (distance < (this.asteroidArr[j].getLife() * 33)) {
                        this.shotArray[i] = null;
                        if (this.asteroidArr[i].getLife() > 1) {
                            createNewAsteroids(3, this.asteroidArr[i].getLife() - 1);
                        }
                        this.asteroidArr[j] = null;
                    }
                }
            }
        }
    }

    private void calcPlayerAsteroidCollision() {

        double[] difference;
        double distance;

        for (int i = 0; i < asteroidArr.length; i++) {
            if (asteroidArr[i] != null) {
            /* calculate difference between the position of the middlepoint of the player and the center of
            an asteroid */
                difference = MyMath.vectorSubtraction(
                        new double[]{p1.getPosX(), p1.getPosY()},
                        new double[]{asteroidArr[i].getPosX(), asteroidArr[i].getPosY()}
                );

                distance = MyMath.vectorLength(difference);

                if (distance < asteroidArr[i].getLife() * 33) {
                    this.gameOver = true;
                }
            }
        }
    }
}
