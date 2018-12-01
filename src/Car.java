import jbotsim.Color;
import jbotsim.Message;
import jbotsim.Node;
import jbotsim.Point;

/**
 * Created by vichatelain on 29/11/18.
 */
public class Car extends Node{

    public static int direction;
    public static final int EAST = 0;
    public static final int WEST = 1;

    public double speed;
    public static final int MINSPEED = 1;
    public static final int MAXSPEED = 3;
    public static int RANGE = MAXSPEED - MINSPEED;

    public static final double SENSINGRANGE = 100;
    public static final String ICONPATH = "/car.png";

    public static final double ALERTRANGE = 60;
    public Point lastBreakDown;

    public StateCar state;


    // Constructor
    public Car(int direction, Point startPosition){
        super();

        speed = (Math.random() * RANGE) + MINSPEED;

        this.direction = direction;
        if(direction == EAST)
            this.setDirection(0);
        else if(direction == WEST)
            this.setDirection(Math.PI);

        this.setIcon(ICONPATH);
        this.setSensingRange(SENSINGRANGE);
        state = new NormalState();
    }

    public void setState(StateCar newState){
        this.state = newState;
    }
    @Override
    public void onClock() {
        if(!(this.state instanceof BreakdownState) ){
            this.move(speed);
            wrapLocation();
        }

        // cf current state.
        state.action(this);




    }

    @Override
    public void onSensingIn(Node node) {
        super.onSensingIn(node);

        if(node instanceof Car){
            state.onInteract(this, (Car)node);
        }

    }

    @Override
    public void onMessage(Message message) {
        super.onMessage(message);

        if(message.getContent().equals("alert")){
                    this.setColor(Color.red);
                    this.speed = speed/2;
                }
            }

}

/*
    Changer les tests sur les couleurs en rajoutant des états (ALERT, PANNE, etc)
 */
