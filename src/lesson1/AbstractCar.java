package lesson1;

public abstract class AbstractCar implements Car {
    protected int speed = 100;

    public void getDescription() {
       out();
    }
    public void out() {
        System.out.println("\n" + this.getClass().getName() + " (speed - " + speed + ", volume - " + getEngineVolume() + ")");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
