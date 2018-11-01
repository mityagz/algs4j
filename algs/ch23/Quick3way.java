package algs.ch23;

import algs.ch2.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 7/28/16.
 */
public class Quick3way {
     //static Comparable [] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
    static Comparable [] a = {3, 15, 1, 100, 102, 4, 5, 9, 17, 5, 9, 7, 100, 150, 700, 100, 9, 7, 7, 9};

     //  <        ==             unsorted   >
    // (lo, lt), (lt + 1, i), (i, gt + 1), (i + 1, hi -1)

    public static void sort(Comparable [] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

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
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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
