import jbotsim.Point;
import jbotsim.Topology;
import jbotsimx.ui.JViewer;
import java.awt.Dimension;


/**
 * Created by vichatelain on 29/11/18.
 */
public class Main {
    public static void main(String[] args) {

        // Code
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int)dimension.getHeight();
        int width  = (int)dimension.getWidth();
        Topology tp = new Topology(1600, 600);
        tp.setDefaultNodeModel(Car.class);
        JViewer jv = new JViewer(tp);
        jv.getJTopology().addBackgroundPainter(new BackgroundPainter());

        Point positionTop = new Point(0,tp.getHeight()/2-45);
        Point positionBottom = new Point(550,tp.getHeight()/2+45);
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
