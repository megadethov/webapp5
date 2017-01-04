package main;

public class CarImpl implements Car {
    private int speed = 100;

    public void go() {
       out();
    }
    public void out() {
        System.out.println("Go with speed " + speed);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
