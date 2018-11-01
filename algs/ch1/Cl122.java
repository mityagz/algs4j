package algs.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/10/15.
 */
public class Cl122 {
    int nint;
    double[] interval0;
    double[] interval1;

    Cl122(int n) {
        nint = n;
        interval0 = new double[nint];
        interval1 = new double[nint];

        double d0 = 0;
        double d1 = 0;

        int i = 0;
        while (!StdIn.isEmpty() && i < nint) {
            d0 = StdIn.readDouble();
            d1 = StdIn.readDouble();
            interval0[i] = d0;
            interval1[i] = d1;
            i++;
        }

        /*
        for (int j = 0; j < interval0.length; j++) {
            StdOut.println(interval0[j] + " " + interval1[j]);
        }
        */

    }

    public void intersection(){
        for(int i = 0; i < interval0.length; i++ ){
            for(int j = 0; j < interval0.length; j++){
                if(interval0[i] < interval0[j] && interval1[j] < interval1[i]){
                    StdOut.println("This interval included: " + interval0[i] +":"+ interval0[j] +"-"+ interval1[j] + ":" + interval1[i]);
                }
                if(interval0[i] <= interval0[j] && interval0[j] <= interval1[i] && interval1[j] > interval1[i] &&i != j){
                    StdOut.println("This interval intersected: " + "" + interval0[i] + ":" + interval1[i] + "-" +  interval0[j] +":"+ interval1[j]);
                }
            }
        }
    }


    public static void main(String [] args){
        Cl122 cl = new Cl122(Integer.parseInt(args[0]));
        cl.intersection();
    }
}
