package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 11/28/15.
 */
public class Euclid {

    public static int gcd(int p, int q){
        //StdOut.printf("p: %d q: %d\n", p, q);
        if(q == 0){
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String [] args){
        StdOut.println("gcd: " + gcd(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
