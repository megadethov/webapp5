package main;

/**
 * Created by mega on 14.05.2016.
 */
public class RaceCar extends AbstractCar {
    RaceCar() {
        speed = 400;
    }

    @Override
    public float getEngineVolume() {
        return 1.7f;
    }
}
