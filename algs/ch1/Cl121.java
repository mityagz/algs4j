package algs.ch1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by mitya on 12/9/15.
 */
public class Cl121 {
    int npoints;
    double [] xpoints;
    double [] ypoints;

    Cl121(int n){
        npoints = n;
        xpoints = new double[npoints];
        ypoints = new double[npoints];
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.blue);
        StdDraw.setXscale(0.0, 1.0);
        StdDraw.setYscale(0.0, 1.0);
        for(int i = 0; i < n; i++){
            xpoints[i] = StdRandom.uniform(0.0, 1.0);
            ypoints[i] = StdRandom.uniform(0.0, 1.0);
            StdDraw.point(xpoints[i], ypoints[i]);
        }
    }

    public void closely_points(){
        int min0 = 0;
        int min1 = 0;
        double closely = 10000;
        double c = 0;


        for(int m = 0; m < npoints; m++){
            for(int n = 0; n < npoints; n++){
              c = Math.sqrt(Math.pow((xpoints[m] - xpoints[n]), 2.0) + Math.pow((ypoints[m] - ypoints[n]), 2.0));
                StdOut.println("Sqrt: " + c);
                if(c > 0 && c < closely){
                    closely = c;
                    min0 = m;
                    min1 = n;
                }
            }
        }
        StdOut.println("Min: " + closely);
        StdOut.println("x0: " + xpoints[min0] + "y0: " + ypoints[min0]);
        StdOut.println("x0: " + xpoints[min1] + "y0: " + ypoints[min1]);
        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius(0.009);
        StdDraw.point(xpoints[min0], ypoints[min0]);
        StdDraw.point(xpoints[min1], ypoints[min1]);
    }

    public static void main(String [] args){
        Cl121 cl = new Cl121(100);
        cl.closely_points();
    }
}