package algs.ch22;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 7/10/16.
 */

// Merge More Fast

public class MergeMF {
    static Comparable [] a = {'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    private static Comparable [] aux;

    public static void sort(Comparable [] a){
        aux = new Comparable[a.length];
        merge(a, 0, (a.length -1)/2, a.length -1);
        for(int sz = 1; sz < a.length; sz += sz){          //A E E E G L M M O P R R S T X
            for(int lo = 0; lo < a.length - sz; lo += sz + sz){
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }

    private static void sort(Comparable [] a, int lo, int hi){
    }

    public static void merge(Comparable [] a, int  lo, int mid, int hi){


        int k;
        for(k = lo; k <= mid; k++)
            aux[k] = a[k];

        for(int m = hi; m > mid; k++, m--) {
            aux[k] = a[m];
        }

        int i = lo, j = hi;
        for (k = lo; k <= hi; k++){
            if(less(aux[i], aux[j]))        a[k] = aux[i++];
            else                            a[k] = aux[j--];
        }

    }

    public static boolean less(Comparable v, Comparable w){
        if(v.compareTo(w) < 0)
            return true;
        return false;
    }

    private static void show(Comparable [] a){
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
        sort(a);
        show(a);
    }
}
