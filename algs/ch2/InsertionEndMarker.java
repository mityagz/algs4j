package algs.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 7/3/16.
 */

// Ex 2.1.24

public class InsertionEndMarker {

    public static void sort(Comparable [] a){
        int min;
        min = 0;
        for(int i = 1; i < a.length; i++){
            if(a[min].compareTo(a[i]) > 0){
                min = i;
            }
        }
        exch(a, 0, min);
        for(int i = 1; i < a.length; i++){
             for (int j = i; less(a[j], a[j - 1]); j--) {
                 exch(a, j, j - 1);
             }
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
    }

    public static boolean isSorted(Comparable [] a){
        for(int i = 1; i < a.length; i++)
            if(less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String [] args){
        //String [] a = In.readStrings();
        int n = 20;
        Double[] a = new Double[n];
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = StdRandom.uniform();
            }
        }
        sort(a);
        assert isSorted(a);
        sort(a);
        show(a);
    }
}
