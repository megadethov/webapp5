package main;

/**
 * Created by mega on 13.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello %s! ", args[0]);
        Car car = new Car();
        car.go();
    }

}
