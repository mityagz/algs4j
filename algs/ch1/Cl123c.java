package algs.ch1;

import edu.princeton.cs.algs4.*;

import java.awt.*;

/**
 * Created by mitya on 12/11/15.
 */
public class Cl123c {
    Interval2D[] interval;
    Cl123c(int n, double min, double max) {
        interval = new Interval2D[n];
        double x0, y0, x1, y1;
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.blue);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        for (int i = 0; i < n; i++) {
            while (true) {
                x0 = StdRandom.uniform(min, max);
                y0 = StdRandom.uniform(min, max);
                x1 = StdRandom.uniform(min, max);
                y1 = StdRandom.uniform(min, max);

                if (x0 < y0 && x1 < y1) {
                    //StdOut.println(x0 + " " + y0 + " " + x1 + " " + y1);
                    interval[i] = new Interval2D(new Interval1D(x0, y0), new Interval1D(x1, y1));
                    break;
                }
            }


        }
        for (int m = 0; m < interval.length; m++) {
            interval[m].draw();
        }

        for(int k = 0; k < interval.length; k++){
            for(int l = 0; l < interval.length; l++){
                if(interval[k].intersects(interval[l]) && k != l){
                    StdOut.println("Interval intersect: " + k + " " + l);
                }
            }
        }

        for(int z = 0; z < interval.length; z++){
            for(int x = 0; x < interval.length; x++){
               // if(interval[z].contains(interval[x].)){
               //     StdOut.println("Interval contains: " + z + " " + x);
               // }
            }
        }
    }

    public static void main(String [] args){
        new Cl123c(10, 1.0, 10.0);
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
