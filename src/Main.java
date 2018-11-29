import jbotsim.Point;
import jbotsim.Topology;
import jbotsimx.ui.JViewer;

/**
 * Created by vichatelain on 29/11/18.
 */
public class Main {
    public static void main(String[] args) {
        Topology tp = new Topology();
        tp.setDefaultNodeModel(Car.class);
        JViewer jv = new JViewer(tp);
        jv.getJTopology().addBackgroundPainter(new BackgroundPainter());

        Point positionTop = new Point(0,tp.getHeight()/2-15);
        Point positionBottom = new Point(550,tp.getHeight()/2+15);
        tp.addNode(positionTop.x, positionTop.y ,new Car(Car.EAST, positionTop));
        tp.addNode(positionTop.x,positionTop.y  ,new Car(Car.EAST, positionTop));
        tp.addNode(positionTop.x, positionTop.y ,new Car(Car.EAST, positionTop));
        tp.addNode(positionTop.x,positionTop.y ,new Car(Car.EAST, positionTop));
        tp.addNode(positionBottom.x, positionBottom.y ,new Car(Car.WEST, positionBottom));
        tp.addNode(positionBottom.x, positionBottom.y ,new Car(Car.WEST, positionBottom));
        tp.addNode(positionBottom.x, positionBottom.y ,new Car(Car.WEST, positionBottom));
        tp.addNode(positionBottom.x, positionBottom.y ,new Car(Car.WEST, positionBottom));


        tp.start();
    }
}
