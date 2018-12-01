/**
 * Created by lbouquin on 01/12/18.
 */
public class AlertState implements StateCar {
    @Override
    public void action(Car context) {

    }

    @Override
    public void onInteract(Car context, Car interact) {
        if(interact.state instanceof BreakdownState ){
            if(context.getDirection() == interact.getDirection() ){
                this.setState(new BreakdownState());
            }
        }
        context.send(interact, "alert");
    }

    @Override
    public void setState(StateCar state) {

    }
}
