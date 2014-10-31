import javafx.scene.transform.Rotate;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by Vladislav on 10/31/2014.
 */
public class Vector {
    private double x;
    private double y;

    public void rotate(double n){
        double rx = (this.x * Math.cos(n)) - (this.y * Math.sin(n));
        double ry = (this.x * Math.sin(n)) + (this.y * Math.cos(n));
        x = rx;
        y = ry;
    }

    public Point2D attachTo(Point2D point){
        return new Point2D.Double(point.getX()+x, point.getY()+y);
    }

    public double getY(){
        return y;
    }

    public double getX(){
        return x;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
