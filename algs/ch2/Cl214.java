package algs.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/19/16.
 */
public class Cl214 {
    public static void main(String [] args){
        String [] a = In.readStrings();
        Insertion2.sort(a);
        assert Insertion2.isSorted(a);
        Insertion2.show(a);
    }
}

class Insertion2 {
    public static void sort(Comparable[] a) {
        System.out.print("i  j  ");
        for (int k = 0; k < a.length; k++) {
            System.out.print(k + " ");
        }
        System.out.println();
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            for (j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            System.out.printf("%-2d %-3d", i, j);
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        if (v.compareTo(w) < 0)
            return true;
        return false;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}


