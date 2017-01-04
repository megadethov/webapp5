package main;

public class Main {
    public static void main(String[] args) {
        Car car = new CarImpl();
        car.go();

        Car car2 = new CarImpl();
        car2.setSpeed(200);
        car2.go();
    }
}
