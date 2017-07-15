import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * Created by tomas on 15/07/2017.
 */
public class Line {
    private Line2D line;

    public Line(int x1, int y1, int x2, int y2){
        line = new Line2D.Float(x1, y1, x2, y2);
    }

    public Line increaseLength(double change){
        double ndx = (change * (line.getX2() - line.getX1())) / getLineLength(line),
                ndy = (change * (line.getY2() - line.getY1())) / getLineLength(line);
        line = new Line2D.Float((int) line.getX1(), (int) line.getY1(), (int) (line.getX1() + ndx), (int) (line.getY1() + ndy));
        return this;
    }
    public Line rotate(double angle){
        return new Line(
                (int) line.getX1(),
                (int) line.getY1(),
                (int) (line.getX1() + getLineLength(line) * Math.cos(Math.toRadians(angle + getAngle()))),
                (int) (line.getY1() + getLineLength(line) * Math.sin(Math.toRadians(angle + getAngle())))
        );
    }
    public double getAngle(){
        double xd = line.getX2() - line.getX1(),
                yd = line.getY2() - line.getY1();
        return Math.toDegrees(Math.atan2(yd, xd));
    }
    public static double getLineLength(Line2D line){
        double dx = Math.abs(line.getX2() - line.getX1()),
                dy = Math.abs(line.getY2() - line.getY1());
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Point2D getLineIntersection(Line segment) {
        double rx1 = line.getX1(),
                ry1 = line.getY1(),
                rx2 = line.getX2(),
                ry2 = line.getY2(),
                sx1 = segment.getLine().getX1(),
                sy1 = segment.getLine().getY1(),
                sx2 = segment.getLine().getX2(),
                sy2 = segment.getLine().getY2(),
                rdx = rx2 - rx1,
                rdy = ry2 - ry1,
                sdx = sx2 - sx1,
                sdy = sy2 - sy1,
                t1, t2,
                ix, iy;

        t2 = (rdx * (sy1 - ry1) + rdy * (rx1 - sx1)) / (sdx * rdy - sdy * rdx);
        t1 = (sx1 + sdx * t2 - rx1) / rdx;

        ix = rx1 + rdx * t1;
        iy = ry1 + rdy * t1;
        return new Point2D.Float((int) ix, (int) iy);
    }

    public Line2D getLine() {
        return line;
    }
}
