package algs.ch1;

import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/21/16.
 */
public class DynamicGrowth {
    public static int cnt = 0;
    public static void main(String [] args) {
        int n = StdIn.readInt();


        LUF<Integer> luf = new LUF<Integer>();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(luf.connected(p, q)){
                continue;
            }
            luf.union(p, q); cnt++;
            StdOut.println(p + " " + q);
        }
        StdOut.println(luf.count() + "компонентов");
        luf.printId();
        //cost = luf.getCost();
    }
}
