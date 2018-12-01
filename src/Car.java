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

    public static final double SENSINGRANGE = 50;
    public static final String ICONPATH = "/car.png";

    public static final double ALERTRANGE = 60;
    public Point lastBreakDown;

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
    }

    @Override
    public void onClock() {
        this.move(speed);
        wrapLocation();

        // Occurence de panne
        double random = Math.random();

        if(random < 0.0001){ // 0.001 is a good testing number
            speed = 0;
            this.setColor(Color.black);
            System.out.println("Panne" + this.getLocation() + this.getTime());
        }

        if(this.getColor() == Color.red && this.getLocation().getX() > (ALERTRANGE + this.lastBreakDown.getX())){

        }
    }

    @Override
    public void onSensingIn(Node node) {
        super.onSensingIn(node);

        if(node instanceof Car){
            if(((Car) node).speed == 0 && node.getDirection() == this.getDirection() ){
                this.speed = 0;
                this.setColor(Color.black);
                System.out.println(((Car)node).direction);
            }
            else if(((Car) node).speed == 0 && node.getDirection() != this.getDirection() && this.getColor() != Color.red){
                this.setColor(Color.red);
                this.lastBreakDown = this.getLocation();

            } else if (this.getColor() == Color.red){
                send(node, "alert");
            }

        }

        // Tester les pannes uniquement pour les véhicules derriere celui qui tombe en panne > test sur GetX()

    }

    @Override
    public void onMessage(Message message) {
        super.onMessage(message);

        if(message.getContent().equals("alert")){
            if(this.getColor() != Color.red && this.getColor() != Color.black){
                this.setColor(Color.red);
                if(message.getSender().getDirection() != this.getDirection()){
                    this.speed = speed/2;
                }
            }
        }
    }
}

/*
    Changer les tests sur les couleurs en rajoutant des états (ALERT, PANNE, etc)
 */
