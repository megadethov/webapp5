package main;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.go();

        Car car2 = new Car();
        car2.setSpeed(200);
        car2.go();
    }
}
