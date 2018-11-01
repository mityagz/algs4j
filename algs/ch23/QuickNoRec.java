package algs.ch23;

import algs.ch2.Insertion;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 8/5/16.
 */
public class QuickNoRec {
    //static Comparable [] a = {15, 15, 3, 15, 15, 15, 15, 15, 15, 3, 3, 15, 15, 3, 3, 3, 15, 15, 3, 15, 3, 3, 3, 15, 3, 15, 3};
    static Comparable [] a = {3, 15, 1, 100, 102, 4, 5, 9, 17, 5, 9, 7, 100, 150, 700, 100, 9, 7, 7, 9};

    public static void sort(Comparable [] a){
        StdRandom.shuffle(a);
        show(a);
        StdOut.println();
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable [] a, int lo, int hi){
        Stack<Integer> l = new Stack<Integer>();
        Stack<Integer> h = new Stack<Integer>();
        int j = 0;
        l.push(lo);
        h.push(hi);
        while (!l.isEmpty() && !h.isEmpty()) {
            show(a);
            StdOut.println();
            int l0 = l.pop();
            int h0 = h.pop();
            // Ex 2.3.13
            StdOut.println("Stack dept: " + l.size());
            if(!(l0 >= h0)){
                j = partition(a, l0, h0);
                StdOut.println("Lo: " + lo + " j: " + j + " Hi:" + h0);
                l.push(l0);
                h.push(j - 1);
                l.push(j + 1);
                h.push(h0);
            }
        }
    }

    public static int partition(Comparable [] a, int lo, int hi){
        int i = lo, j = hi + 1;
        StdOut.println("Partition Lo:" + lo + " Hi:" + hi);
        Comparable v = a[lo];
        while (true){
            while (Insertion.less(a[++i], v)) if(i == hi) break;
            while (Insertion.less(v, a[--j])) if(j == lo) break;
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
        StdOut.println();
        sort(a);
        StdOut.println();
        show(a);
    }
}
