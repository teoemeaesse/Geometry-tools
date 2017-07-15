import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by tomas on 15/07/2017.
 */
public class Shape {
    private Point2D[] points;

    public Shape(Point2D ... points){
        this.points = points;
    }

    public Line2D[] getLines(){
        ArrayList<Line2D> lines = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            if(i + 1 < points.length)
                lines.add(new Line2D.Float((int) points[i].getX(), (int) points[i].getY(), (int) points[i + 1].getX(), (int) points[i + 1].getY()));
            else
                lines.add(new Line2D.Float((int) points[i].getX(), (int) points[i].getY(), (int) points[0].getX(), (int) points[0].getY()));
        }
        return lines.toArray(new Line2D[lines.size()]);
    }

    public Point2D[] getPoints() {
        return points;
    }
}
