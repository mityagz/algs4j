package algs.ch2;

import algs.ch1.StopWatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * Created by mitya on 6/26/16.
 */
public class TraceSelection {
    static int xmin = 0, xi = 0;
    static StopWatch timer = null;
    static void sort(Comparable [] a){
        timer = new StopWatch();
        for(int i = 0; i < a.length; i++){
            int min = i;
             for (int j = i + 1; j < a.length; j++){
                 if(less(a[j], a[min])) {
                     min = j;
                 }
             }
            xmin = min; xi = i;
            TraceSelection.show(a);
            exch(a, i, min);
            //TraceSelection.show(a);
        }
    }

    public static boolean less(Comparable v, Comparable w){
        if(v.compareTo(w) < 0)
            return true;
        return false;
    }

    public static void exch(Comparable [] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void show(Comparable [] a){
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();

        double imt = timer.intermediateTime();
        double x = 0.0 , rw = 0.0;
        double y = 0.0, rh = 0.0;
        StdDraw.clear();
        StdDraw.text(0.1, 0.9, String.valueOf(imt) + " Sec");
        for(int i = 0; i < a.length; i++){
            x = 1.0 * i / a.length;
            rw = 0.5 / a.length;
            rh = (Double)a[i];
            //StdDraw.setYscale();
            if(i == xmin) {
                StdDraw.setPenColor(Color.red);
                StdDraw.filledRectangle(x, y, rw, rh);
                StdDraw.setPenColor(Color.black);
            } else if (i > xi){
                StdDraw.filledRectangle(x, y, rw, rh);
            } else {
                StdDraw.rectangle(x, y, rw, rh);
            }
            /*
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
        }
    }

    public static boolean isSorted(Comparable [] a){
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String [] args){
        //String [] a = In.readStrings();
        int n = 100;
        Double[] a = new Double[n];
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = StdRandom.uniform();
            }
        }
        TraceSelection.sort(a);
        assert isSorted(a);
        TraceSelection.show(a);
    }
}
