package c1elements.s5inputOutput.theory;

import c1elements.s5inputOutput.lib.StdDraw;
import c1elements.s5inputOutput.lib.StdIn;

//US MAP - java C1_elements/S5_InputOutput/PlotFilter < USA.txt

public class PlotFilter {

    public static void main(String[] args) {

        // read in bounding box and rescale
        double x0 = StdIn.readDouble();
        double y0 = StdIn.readDouble();
        double x1 = StdIn.readDouble();
        double y1 = StdIn.readDouble();
        StdDraw.setXscale(x0, x1);
        StdDraw.setYscale(y0, y1);

        // for bigger points
        StdDraw.setPenRadius(0.001);

        // to speed up performance, defer displaying points
        StdDraw.enableDoubleBuffering();

        // plot points, one at a time
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            StdDraw.point(x, y);
        }

        // display all the points
        StdDraw.show();

    }
}
