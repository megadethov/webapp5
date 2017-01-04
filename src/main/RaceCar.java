package main;

public class RaceCar extends AbstractCar {
    public RaceCar() {
        speed =200;
    }

    @Override
    public float getEngineVolume() {
        return 3.5F;
    }
}
