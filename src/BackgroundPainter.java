import jbotsim.Topology;

import java.awt.*;

public class BackgroundPainter
        implements jbotsimx.ui.painting.BackgroundPainter {
    @Override
    public void paintBackground(Graphics2D g, Topology tp) {

        /*
        // Paints a background image
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image image = tk.getImage(getClass().getResource("/forest.jpg"));
        g.drawImage(image, 0, 0, null);
        */

        // Draws a grid (line by line)
        g.setColor(Color.gray);


        // out
        g.drawLine(0, tp.getHeight()/2-60, tp.getWidth() , tp.getHeight()/2-60);
        g.drawLine(0, tp.getHeight()/2+60, tp.getWidth() , tp.getHeight()/2+60);

        /// middle
        g.setStroke(new BasicStroke(5));
        g.drawLine(0, tp.getHeight()/2, tp.getWidth() , tp.getHeight()/2);

        // in
         float dash1[] = {10.0f};
        BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
        g.setStroke(dashed);
        g.drawLine(0, tp.getHeight()/2 - 30,tp.getWidth(), tp.getHeight()/2 - 30);
        g.drawLine(0, tp.getHeight()/2 + 30,tp.getWidth(), tp.getHeight()/2 + 30);
    }
}