/**
 * Created by lbouquin on 01/12/18.
 */
public interface StateCar {
    void action(Car context);
    void onInteract(Car context, Car interact);
    void setState(StateCar state );
}
