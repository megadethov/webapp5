package main;

/**
 * Created by mega on 14.05.2016.
 */
public abstract class AbstractCar implements Car{
    protected int speed  = 100;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void getDescribe() {
        System.out.println("\n" + this.getClass().getSimpleName() + " Speed " + speed); // getClass() - метод Object
        // getSimpleName() - метод Class
    }
}
