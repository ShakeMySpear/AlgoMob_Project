import jbotsim.Color;

/**
 * Created by lbouquin on 01/12/18.
 */
public class NormalState implements StateCar {
    @Override


    public void action(Car context) {
        double random = Math.random();

        if(random < 0.0001){ // 0.001 is a good testing number
            context.speed = 0;
            context.setColor(Color.black);
            context.setState(new BreakdownState());
            System.out.println("Panne" + context.getLocation() + context.getTime());
        }
    }

    @Override
    public void onInteract(Car context, Car interact) {
        if(interact.state instanceof BreakdownState ){
            if(context.getDirection() != interact.getDirection() ){
                //context.speed /=2;
                context.setState(new AlertState(false));
                context.setColor(Color.red);
                context.lastBreakDown = interact.getLocation();
            }
            else {
                context.setState(new BreakdownState());
                context.setColor(Color.black);
            }
        }


    }

    @Override
    public void setState(StateCar state) {

    }
}
