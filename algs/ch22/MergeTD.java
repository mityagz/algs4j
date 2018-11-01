package algs.ch22;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 7/9/16.
 */
public class MergeTD {

    static Comparable [] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
    private static Comparable [] aux;

    public static void sort(Comparable [] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable [] a, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable [] a, int  lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;

        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++){
            if(i > mid){
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }else if(less(aux[i], aux[j])){
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
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
