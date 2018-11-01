package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

/**
 * Created by mitya on 12/1/15.
 */
public class gistr {
    public static void gs(int n, double l, double r, double [] w){
        double [] x0 = new double[n + 1];
        int [] x1 = new int[n + 1];



        double d = 0;
        x0[0] = l;
        d = (r - l)/(double)n;
        for(int i = 1; i < x0.length; i++){
            x0[i] = l + d;
            l = l + d;
        }
        x0[x0.length - 1] = r;

        for(int j = 0; j < x0.length; j++){
            for(int k = 0; k < w.length; k++){
                if(j == x0.length - 1){
                    if(w[k] >= x0[j - 1] && w[k] < x0[j]) {
                        x1[j]++;
                    }
                }
                if(j < n && w[k] >= x0[j] && w[k] < x0[j + 1]){
                    x1[j]++;
                }
            }
            StdOut.println(x0[j]);
        }

        int maxy = x1[0];
        double maxx = x0[0];
        for(int m = 0; m < x1.length; m++){
           StdOut.println("Gist x[" + x0[m] + "]=" + x1[m]);
            if(x1[m] > maxy){
                maxy = x1[m];
                maxx = x0[m];
            }
        }


        StdDraw.setPenRadius(0.009);
        StdDraw.setPenColor(Color.RED);
        StdDraw.setXscale(0, maxx + 10);
        StdDraw.setYscale(0, maxy + 3);
        for(int z = 0; z < x0.length; z++) {
            StdDraw.line(x0[z], 0, x0[z], x1[z]);
        }
    }
    public static void main(String [] args){
        In in = new In(args[0]);
        double [] wn = in.readAllDoubles();
        gs(10, 1.0, 3.0, wn);
    }
}
