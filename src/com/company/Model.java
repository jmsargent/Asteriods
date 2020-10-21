package com.company;

import java.util.*;

public class Model {

    // classvars

    private List<Shot> shots;
    private Iterator iterator;

    private List<Asteroid> asteroids;


    private Shot[] shotArray;
    private boolean gameOver;
    private Asteroid[] asteroidArr;
    Random rand;
    private Player player; //= new Player(300, 300);
    int resX,resY;

    // constructor

    public Model() {
        resX = 300;
        resY = 300;
        // initiate player in middle of screen
        player = new Player(300, 300);

        shotArray = new Shot[4];

        shots = new LinkedList<>();
        asteroids = new LinkedList<>(); // fixa resten med asteroids

        rand = new Random();
        gameOver = false;
        //spawnAsteroids(4, 3);
        createAsteroids(4,3);
    }

    // getters & setters

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    public List<Shot> getShots() {
        return shots;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Player getPlayer() {
        return player;
    }

    public Asteroid[] getAsteroidArr() {
        return asteroidArr;
    }

    public Shot[] getShotArray() {
        return shotArray;
    }

    // other methods ...

    /**
     * Creates shot in first empty position of array if there are any empty slots
     */
    private void createShot() {
        shots.add(new Shot(player.getTip(), player.getAngle(), player.getDx(), player.getDy()));
    }

    public void playerFire() {
        if (player.isGunsReady() && !isGameOver()) {
            player.shoot();
            createShot();
        }
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
        player.decTimers();
    }

    private void updateObjectPositioning() {
        player.updatePlayerPos();

        updateShotsPositioning();
        updateAsteroidPositioning();
    }

    private void updateAsteroidPositioning() {

        



    }

    /**
     * updates position of all shots
     */
    private void updateShotsPositioning() {

        // this can be combined with asteroids for nicer looking code

        iterator = this.shots.iterator();

        while(iterator.hasNext()){
            Shot s = (Shot) iterator.next();
            s.move();

            if (s.isOutOfBounds())
                iterator.remove();
        }

    }

    private void createAsteroids (int amount, int lives){

        int pos[] = findValidSpawnLocation();
        double vel[] = generateRNDvel();


        for (int i = 0; i < amount; i++) {

            asteroids.add(new Asteroid(pos[0],pos[1],vel[0],vel[1],lives));

            pos = findValidSpawnLocation();
            vel = generateRNDvel();
        }
    }



    private void replaceAsteroid(int x, int y, int lives){

    }

    private void spawnAsteroids(int nrOfAsteroids, int lives) {

        int[] validSpawnLocation = findValidSpawnLocation();

        for (int i = 0; i < nrOfAsteroids; ++i) {
            createNewAsteroids(1, lives, validSpawnLocation);

            validSpawnLocation = findValidSpawnLocation();
        }
    }

    private void createNewAsteroids(int nrOfAsteroids, int lives, int[] spawnLocation) {

        int asteroidstoCreate = nrOfAsteroids;
        double[] randomVelocity = generateRNDvel();
        for (int i = 0; i < this.asteroidArr.length; i++) {
            if (this.asteroidArr[i] == null) {
                // note for self : x,y,dx,dy
                this.asteroidArr[i] = new Asteroid(spawnLocation[0], spawnLocation[1], randomVelocity[0], randomVelocity[1], lives);
                randomVelocity = generateRNDvel();
                asteroidstoCreate --;

                if(asteroidstoCreate == 0)
                    break;
            }
        }
    }

    /**
     * returns as {latitude, coordinate}
     *
     * @return
     */
    private int[] findValidSpawnLocation() {

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

    private double[] generateRNDvel() {

        // I had to, sorry , I know it doesn't follow conventions
        double Maxwell = 1.2;

        return new double[]{(0.5 + rand.nextDouble()) % Maxwell, (0.5 + rand.nextDouble()) % Maxwell};
    }

    private void calcColissions() {
       // calcShotAsteroidCollision();
        // calcPlayerAsteroidCollision();
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
                        if (this.asteroidArr[j].getLife() > 0) {
                            createNewAsteroids(3, this.asteroidArr[j].getLife() - 1,
                                    new int[]{(int) this.asteroidArr[j].getPosX(), (int) this.asteroidArr[j].getPosY()});
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
                        new double[]{player.getPosX(), player.getPosY()},
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
