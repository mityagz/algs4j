package algs.ch1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * Created by mitya on 12/11/15.
 */
public class Cl121c {
    Cl121c(int n){
        Point2D [] p = new Point2D[n];
        double mindist = 10000000.0;
        double d = 0.0;
        int x =0, y = 0;
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.blue);
        StdDraw.setXscale(0.0, 1.0);
        StdDraw.setYscale(0.0, 1.0);
        for(int i = 0; i < n; i++){
            p[i] = new Point2D(StdRandom.uniform(0.0, 1.0), StdRandom.uniform(0.0, 1.0));
            StdDraw.point(p[i].x(), p[i].y());
        }

        for(int i = 0; i < p.length; i++){
            for(int j = 0; j < p.length; j++) {
                d = p[i].distanceTo(p[j]);
                if (d < mindist && i != j) {
                    mindist = d;
                    x = i;
                    y = j;
                }
            }
        }
        StdOut.println("MinDinst: " + mindist);
        StdDraw.setPenRadius(0.009);
        StdDraw.setPenColor(Color.red);
        StdDraw.point(p[x].x(), p[x].y());
        StdDraw.point(p[y].x(), p[y].y());
    }
    public static void main(String [] args){
        new Cl121c(10);
    }
}
