package algs.ch25;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 10/7/16.
 */
public class Insertion2 {
    public static void sort(Comparable [] a){
        for(int i = 1; i < a.length; i++){
             for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                 exch(a, j, j - 1);
             }
        }
    }

    public static Integer [] indirectSort(Comparable [] a) {
        Comparable [] b = Arrays.copyOf(a, a.length);
        Integer [] index = new Integer [a.length];
        for(int k = 0; k < a.length; k++)
                index[k] = k;

        for(int i = 1; i < a.length; i++)
             for (int j = i; j > 0 && less(b[j], b[j - 1]); j--) {
                 exch(b, j, j - 1);
                 exch(index, j, j - 1);
             }

        return index;
    }

    public static Integer [] indirectSort(Comparable [] a, int be0, int be1) {
        Comparable [] b = Arrays.copyOf(a, a.length);
        Integer [] index = new Integer [a.length];
        for(int k = 0; k < a.length; k++)
                index[k] = k;

        for(int i = be0; i <= be1; i++)
             for (int j = i; j > be0 && less(b[j], b[j - 1]); j--) {
                 exch(b, j, j - 1);
                 exch(index, j, j - 1);
             }

        return index;
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
        // Выод эл-тов массива в одной строке
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
        Integer [] a = {15, 4, 6, 1, 2, 5, 7, 8};
        //sort(a);
        assert isSorted(a);
        show(a);

        Integer [] c = indirectSort(a);

        for(int i = 0; i < c.length; i++) {
            StdOut.println(c[i]);
        }
        StdOut.println();
        for(int i = 0; i < c.length; i++) {
            StdOut.println(a[c[i]]);
        }

        StdOut.println();
        for(int i = 0; i < c.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
