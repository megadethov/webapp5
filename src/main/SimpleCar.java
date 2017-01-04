package main;

public class SimpleCar extends AbstractCar {
    @Override
    public float getEngineVolume() {
        return 2.5F;
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Something custom");
    }
}
