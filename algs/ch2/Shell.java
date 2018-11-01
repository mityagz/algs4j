package algs.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/16/16.
 */
public class Shell {
    public static void sort(Comparable [] a){
        int n = a.length;
        int h = 1;
        while(h < n/3) h = 3 * h + 1;
        while(h >= 1){
            for(int i = h; i < n; i++){
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h ){
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
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
        String [] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
