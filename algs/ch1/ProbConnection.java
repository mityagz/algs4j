package algs.ch1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * Created by mitya on 11/29/15.
 */
public class ProbConnection {
    public static void draw_circle_point(int n, double p){
        double [] x = new double[n];
        double [] y = new double[n];
        double delta_degree = 360.0/n;
        double degree = 0;
        StdDraw.setPenRadius(0.009);
        StdDraw.setPenColor(Color.RED);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        for(int i = 0; i < n; i++){
           degree = delta_degree*i;
           StdOut.println("Degree: " + degree + " Cos:  " + Math.cos(degree) + " Sin: " + Math.sin(degree));
           x[i] = 50 + Math.cos(degree)*30;
           y[i] = 50 + Math.sin(degree)*30;
           StdDraw.point(x[i], y[i]);
        }

        StdDraw.setPenRadius(0.0005);
        StdDraw.setPenColor(Color.BLUE);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(StdRandom.bernoulli(p)) {
                    StdDraw.line(x[i], y[i], x[j], y[j]);
                }
            }
        }

    }

    public static void main(String [] args){
            draw_circle_point(10, 0.9);
    }
}
