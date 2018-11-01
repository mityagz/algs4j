package algs.ch22;

import algs.ch2.Insertion;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 7/10/16.
 */
public class MergeX {
    static Comparable [] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
    //static Comparable [] a = {'A', 'B', 'C', 'D', 'I', 'F', 'G', 'I', 'K', 'O', 'O', 'N'};
    private static Comparable [] aux;
    private static final int CUTOFF = 7;

    public static void sort(Comparable [] a){
        //aux = new Comparable[a.length];
        aux = a.clone();
        sort(aux, a,  0, a.length - 1);
    }

    private static void sort(Comparable [] s, Comparable [] d,  int lo, int hi){
        if(hi <= lo) return;

        if(hi - lo < CUTOFF){
            insertionSort(d,  lo, hi);
            return;
        }


        int mid = lo + (hi - lo)/2;
        sort(d, s, lo, mid);
        sort(d, s, mid + 1, hi);

        if(less(mid, mid + 1)){
            System.arraycopy(a, lo, a, lo, hi - lo -1);
        }
        
        merge(s, d, lo, mid, hi);
    }

    public static void merge(Comparable [] s, Comparable [] d, int  lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++){
            if(i > mid){
                d[k] = s[j++];
            }else if(j > hi){
                d[k] = s[i++];
            }else if(less(s[i], s[j])){
                d[k] = s[i++];
            } else {
                d[k] = s[j++];
            }
        }

    }

    private static void insertionSort(Comparable [] a, int lo, int hi){
        for(int i = lo; i <= hi; i++){
            for(int j = i; j > lo && less(a[j], a[j - 1]); j--){
                    Insertion.exch(a, j, j - 1);
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

    public static void main(String [] args) {
        sort(a);
        show(a);
    }
}
