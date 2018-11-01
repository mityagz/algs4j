package algs.ch23;

import algs.ch2.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by mitya on 8/6/16.
 */

// ex 2.3.17

public class QuickSignalKey {
    static Comparable [] a = {3, 15, 1, 100, 102, 4, 5, 9, 17, 5, 9, 7, 100, 150, 700, 100, 9, 7, 7, 9};

    public static void sort(Comparable [] a){
        StdRandom.shuffle(a);
        StdOut.println(max(a));
        Insertion.exch(a, max(a), a.length - 1);
        sort(a, 0, a.length - 1);
    }

    public static int max(Comparable [] a){
        int i = 0;
        int max = i;
        for(i = 0; i < a.length; i++){
            if (a[i].compareTo(a[max]) > 0)
                max = i;
        }
        return max;
    }

    public static void sort(Comparable [] a, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    public static int partition(Comparable [] a, int lo, int hi){
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true){
            while (Insertion.less(a[++i], v)); //  if(i == hi) break;
            while (Insertion.less(v, a[--j])); // if(j == lo) break;
            if(i >= j) break;
            Insertion.exch(a, i, j);
        }
        Insertion.exch(a, j, lo);
        return j;
    }

    private static void show(Comparable [] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    public static void main(String [] args){
        show(a);
        sort(a);
        StdOut.println();
        show(a);
    }
}
