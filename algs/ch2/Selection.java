package algs.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/14/16.
 */
public class Selection {
     static void sort(Comparable [] a){
        for(int i = 0; i < a.length; i++){
            int min = i;
             for (int j = i + 1; j < a.length; j++){
                 if(less(a[j], a[min])) {
                     min = j;
                 }
             }
            exch(a, i, min);
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
        Selection.sort(a);
        assert isSorted(a);
        Selection.show(a);
    }
}
