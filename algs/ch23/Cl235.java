package algs.ch23;

import algs.ch2.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 7/30/16.
 */
public class Cl235 {
    static Comparable [] a = {15, 15, 3, 15, 15, 15, 15, 15, 15, 3, 3, 15, 15, 3, 3, 3, 15, 15, 3, 15, 3, 3, 3, 15, 3, 15, 3};

    public static void sort(Comparable [] a){
        StdRandom.shuffle(a);
        show(a);
        StdOut.println();
        sort(a, 0, a.length - 1);
    }


     //  <         >            unsorted
    // (lo, lt),  (lt + 1, i), (i + 1, hi -1)
    /*
    public static void sort(Comparable [] a, int lo, int hi){
        int lt = lo, i = lo, max = 0;

        for(int j = 1; j < a.length; j++)
            if(a[j].compareTo(a[max]) > 0) {
                max = j;
                break;
            }
        Insertion.exch(a, max, hi);
        while(i < hi - 1){
            int c  = a[i].compareTo(a[hi]);
            if(c < 0) {
                Insertion.exch(a, lt, i);
                lt++;
            }
            i++;
        }
        Insertion.exch(a,lt, hi - 1);
    }
    */
    public static void sort(Comparable [] a, int lo, int hi){
        int lt = lo,     max = 0;

        for(int j = 1; j < a.length; j++)
            if(a[j].compareTo(a[max]) > 0) {
                max = j;
                break;
            }
        Insertion.exch(a, max, hi);
        for(int i = lo; i < hi - 1; i++){
            int c  = a[i].compareTo(a[hi]);
            if(c < 0) {
                Insertion.exch(a, lt++, i);
            }
        }
        Insertion.exch(a,lt, hi - 1);
    }
    /*
    public static void sort(Comparable [] a, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int c  = a[i].compareTo(v);
            if(c < 0) Insertion.exch(a, lt++, i++);
            else if(c > 0) Insertion.exch(a, i, gt--);
            else i++;
        }
    }
    */

    private static void show(Comparable [] a) {
         for (int i = 0; i < a.length; i++) {
             StdOut.print(a[i] + " ");
         }
     }

    public static void main(String [] args){
        show(a);
        StdOut.println();
        sort(a);
        StdOut.println();
        show(a);
    }
}
