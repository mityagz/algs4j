package algs.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 6/22/16.
 */
public class Cl219 {
    public static void main(String [] args){
       String [] a = In.readStrings();

        /*
        int n = 10;
        Double[] a = new Double[n];
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = StdRandom.uniform();
            }
        }
        */

        Shell2.sort(a);
        assert Shell2.isSorted(a);
        Shell2.show(a);
    }
}

 class Shell2 {
    public static void sort(Comparable [] a){
        double exchCount = 0.0;
        System.out.println("Source array: ");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int n = a.length;
        int h = 1;
            while(h < n/3) h = 3 * h + 1;
            while (h >= 1) {
                System.out.println(h + " - order by");
                for (int i = h; i < n; i++) {
                    for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                        exch(a, j, j - h);
                        exchCount++;
                    }
                    for(int k = 0; k < a.length; k++) {
                        System.out.print(a[k] + " ");
                    }
                    System.out.println("exchCount / a.length " + exchCount / a.length);
                    exchCount = 0.0;
                }
                h = h / 3;
            }

    }

    public static boolean check(Comparable [] a){
        Comparable [] b = new Comparable[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[i];
        }
        if(a.length != b.length)
            return false;
        sort(b);
        for(int i = 0; i < b.length; i++){
            if(b[i] != a[i])
                return false;
        }
        return true;
    }

    public static boolean less(Comparable v, Comparable w){
        if(v.compareTo(w) < 0)
            return true;
        return false;
    }

    public static void exch(Comparable [] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public static void show(Comparable [] a){
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
}
