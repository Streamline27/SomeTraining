package DragonFractal;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Vladislav on 10/31/2014.
 */
public class Dragon {
    private final boolean RIGHT_ANGLE = true;
    private final boolean LEFT_ANGLE = false;

    private int iterations; //Required for showScale();
    private ArrayList<Boolean> scale;
    private DragonVisualizer visualizer;

    private void incIteration(){
        iterations++;
    }

    private void modify(){
        scale.add(scale.size(), RIGHT_ANGLE);
        for (int i = scale.size()-2; i >= 0; i--) {
            Boolean angle = !scale.get(i);
            scale.add(scale.size(), angle);
        }
    }

    private void initVisualizer(){
        visualizer = new DragonVisualizer(3678, Color.BLACK, 0.001, 20);
        visualizer.setCurrentPos(2850, 1524);
    }

    private void Iterate(int iterations){
        for (int i = 0; i < iterations; i++) {
            modify();
            incIteration();
        }
    }

    //======================================
    /***** Public interface methods  ******/

    public Dragon() {
        scale = new ArrayList<Boolean>();
    }

    public void showScale(){
        System.out.println("Iteration: " + iterations);
        for (int i = 0; i < scale.size(); i++) {
            if (scale.get(i)) System.out.print(" > ");
            else System.out.print(" < ");
        }
        System.out.println();
    }

    public void run(int iterations){
        /** Main computation */
        Iterate(iterations);
        /** Visualizing results */
        initVisualizer();
        visualizer.visualizeScale(scale);
    }

    public static void main(String[] args) {
        Dragon d = new Dragon();
        d.run(14);
    }
}
