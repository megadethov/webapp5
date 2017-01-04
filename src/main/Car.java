package main;

public class Car {
   private int speed = 100;

    void go() {
        System.out.println("Go with speed " + speed);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
