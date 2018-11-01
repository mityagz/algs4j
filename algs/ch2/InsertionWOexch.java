package algs.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 7/3/16.
 */
public class InsertionWOexch {
    public static void sort(Comparable [] a){
        int j;
        for(int i = 1; i < a.length; i++){
            Comparable key = a[i];
            /*
             for (j = i - 1; j > 0 && a[j].compareTo(key) > 0; j--) {
                    a[j + 1] = a[j];
             }
            a[j + 1] = key;
            */
            for(j = i - 1; j >= 0 && a[j].compareTo(key) > 0; j--){
                a[j + 1] = a[j];
            }
            a[j + 1] = key;
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
        //sort(a);
        //assert isSorted(a);
        //show(a);

        int n = 20;
        Double[] a = new Double[n];
        for (int j = 0; j < a.length; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = StdRandom.uniform();
            }
        }
        show(a);
        //assert isSorted(a);
        sort(a);
        show(a);
    }
}
