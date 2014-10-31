import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by Vladislav on 10/31/2014.
 */
public class DragonVisualizer {
    private final boolean RIGHT_ANGLE = true;
    private final boolean LEFT_ANGLE = false;
    private final double RIGHT_ANGLE_RIGHT = Math.PI/2;
    private final double RIGHT_ANGLE_LEFT = -Math.PI/2;


    private Vector motionVector;
    private Point2D currentPos;

    private double Scale;


    private void InitializeGraphics(int scale, Color color, double penRadius){
        Scale = scale;
        StdDraw.clear();
        StdDraw.setXscale(0, Scale);
        StdDraw.setYscale(0, Scale);
        StdDraw.setPenColor(color);
        StdDraw.setPenRadius(penRadius);
    }

    private void InitializePrimitives(int size){
        motionVector = new Vector(size, 0);
        currentPos = new Point2D.Double(Scale-Scale/10, Scale/10);
    }

    private void move(Boolean angle){
        if (angle) motionVector.rotate(RIGHT_ANGLE_RIGHT);
        else motionVector.rotate(RIGHT_ANGLE_LEFT);

        Point2D d = motionVector.attachTo(currentPos);
        StdDraw.line(currentPos.getX(), currentPos.getY(), d.getX(), d.getY());
        currentPos = d;

        StdDraw.show();
    }

    public void setCurrentPos(int X, int Y){
        currentPos.setLocation(X, Y);
    }

    public DragonVisualizer(int scale, Color color, double penSize, int vectorSize){
        InitializeGraphics(scale, color, penSize);
        InitializePrimitives(vectorSize);
    }

    public void visualizeScale(ArrayList<Boolean> scale){
        move(LEFT_ANGLE);
        for (int i = 0; i < scale.size(); i++) {
            move(scale.get(i));
        }

    }

}
