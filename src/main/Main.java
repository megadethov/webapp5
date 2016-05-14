package main;

/**
 * Created by mega on 13.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello %s!\n", args[0]);
        Car raceCar = new RaceCar();
        Car simpleCar = new SimpleCar();
        raceCar.getDescribe();
        simpleCar.setSpeed(200);
        simpleCar.getDescribe();
    }

}
