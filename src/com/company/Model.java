package com.company;

import java.util.*;

public class Model {

    private Shot[] shotArray;

    public Asteroid[] getAsteroidArr() {
        return asteroidArr;
    }

    private Asteroid[] asteroidArr;
    private Asteroid[] smallAsteroidArr;
    Random rand;


    private Player p1; //= new Player(300, 300);
    private Shot shot;


    public Model() {
        // initiate player in middle of screen
        p1 = new Player(300, 300);
        shotArray = new Shot[4];
        rand = new Random();

        spawnAsteroids(4);

        for (int i = 0; i < 4; i++) {
            shotArray[i] = null;
        }

        //    nonPlayerSpaceObjects = new LinkedList<SpaceObject>();
        //    nonPlayerSpaceObjects.add(new Asteroid(50, 50, 10, 10));
    }

    public Shot[] getShotArray() {
        return shotArray;
    }

    /**
     * Creates shot in first empty position of array if there are any empty slots
     */
    private void createShot() {

        for (int i = 0; i < 4; i++) {
            if(shotArray[i] == null){
                System.out.println("tipX:" +p1.getTip()[0]);
                System.out.println("tipY:" +p1.getTip()[1]);
                shotArray[i] = new Shot(p1.getTip(), p1.getAngle(), p1.getDx(), p1.getDy());
                break ;
            }
        }
        System.out.println("angle :" + p1.getAngle());

        /*
        System.out.println(p1.getPosX());
        System.out.println(p1.getPosY());
        System.out.println(p1.getDx());
        System.out.println(p1.getDy());
         */
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

        updateTimers();
        updateObjectPositioning();
        //System.out.println("dx is: " + p1.getDx());
        //System.out.println("dy is: " + p1.getDy());

    }

    private void updateTimers() {
        p1.decTimers();
    }

    private void updateObjectPositioning() {
        p1.updatePlayerPos();

        updateShotsPositioning();
        updateAsteroidPositioning();
        calcColissions();

        /*for (SpaceObject nonPlayerSpaceObject : nonPlayerSpaceObjects) {
            nonPlayerSpaceObject.updatePos();
        }*/
    }

    private void updateAsteroidPositioning(){
        for (int i = 0; i < this.asteroidArr.length; i++) {
            if(this.getAsteroidArr()[i] != null){
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

                    if(shotArray[i].isOutOfBounds()){
                        shotArray[i] = null;
                    }

                }
            }

    }

    private void spawnAsteroids(int nrOfAsteroids){

        int[] validSpawnLocation = getValidSpawnLocation();
        double[] randomVelocity = getRndBigVel();

        System.out.println("validspawnLoc:");
        System.out.println(validSpawnLocation.toString());

        System.out.println("randomVel:");
        System.out.println(randomVelocity.toString());


        this.asteroidArr = new Asteroid[nrOfAsteroids];

        for (int i = 0; i < nrOfAsteroids; i++) {
            // note for self : x,y,dx,dy
            this.asteroidArr[i] = new Asteroid(validSpawnLocation[0],validSpawnLocation[1],randomVelocity[0],randomVelocity[1]);
            validSpawnLocation = getValidSpawnLocation();
            randomVelocity = getRndBigVel();

            System.out.println("loop number:" + i);
        }
    }

    /**
     * returns as {latitude, coordinate}
     * @return
     */
    private int[] getValidSpawnLocation(){

        // 1-north 2-east 3-west 4-south

        int latitude = this.rand.nextInt()%4;
        int coordinate = this.rand.nextInt()%300;

        switch (latitude){
            case(1): // north
                return new int[]{0,coordinate};
            case(2):
                return new int[]{coordinate,600};
            case(3):
                return new int[]{coordinate,0};
            case(4):
                return new int[]{600,coordinate};
            default: return new int[]{6000 ,6000}; // this will never happen but compiler complains if i dont
        }
    }

    private double[] getRndBigVel(){

        // I had to, sorry , I know it doesn't follow conventions
        double MaxWell = 1.2;

        return new double[]{(0.5+rand.nextDouble())%MaxWell,(0.5+ rand.nextDouble())%MaxWell};
    }

    private void calcColissions(){
        calcShotAsteroidCollision();
    }

    private void calcShotAsteroidCollision(){

        double[] difference;
        double distance;

        for (int i = 0; i < this.shotArray.length; i++) {
            for (int j = 0; j < this.asteroidArr.length; j++) {

                // if both currently compared indices contain any obj...
                if (this.shotArray[i] != null && this.asteroidArr[j] != null){
                    // ...calc distance between the tip of the shot and the middlepoint of the asteroid


                    difference = MyMath.vectorSubtraction(
                            new double[]{this.shotArray[i].getPosX(),this.shotArray[i].getPosY()},
                            new double[]{this.asteroidArr[j].getPosX(),this.asteroidArr[j].getPosY()}
                            );


                    distance = MyMath.vectorLength(difference);

                    // if distance between points is less than the radius of the asteroid
                    if(distance < (this.asteroidArr[j].getLife()*50)){
                        this.asteroidArr[j] = null;
                        this.shotArray[i] = null;
                    }
                }
            }
        }
    }
}
