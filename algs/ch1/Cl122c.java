package algs.ch1;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/11/15.
 */
public class Cl122c {
    int nint;
    Interval1D [] interval;
    Cl122c(int n){
        nint = n;
        interval = new Interval1D[n];

        int k = 0;
        while (!StdIn.isEmpty() && k < nint) {
          double  d0 = StdIn.readDouble();
          double  d1 = StdIn.readDouble();
            interval[k] = new Interval1D(d0, d1);
            //StdOut.println(interval[k].left()  + " " + interval[k].right());
            k++;
        }

        for(int i = 0; i < interval.length;i++){
            for(int j = 0; j < interval.length; j++){
                if(interval[i].intersects(interval[j]) && i != j) {
                    StdOut.println("Interval intersect: " + interval[i].left() + ":" + interval[i].right() + " -- " + interval[j].left() + ":" + interval[j].right());
                }
            }
        }
    }
    public static void main(String [] args){
        new Cl122c(Integer.parseInt(args[0]));
    }
}
