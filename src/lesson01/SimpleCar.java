package lesson01;

/**
 * Created by mega on 14.05.2016.
 */
public class SimpleCar extends AbstractCar {

    @Override
    public float getEngineVolume() {
        return 1.8f;
    }

    @Override
    public void getDescribe() {
        super.getDescribe();
        System.out.println("special SimpleCar option");
    }
}
