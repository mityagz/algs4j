package algs.ch22;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 7/9/16.
 */
public class MergeBU {
    //static Comparable [] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
    static Comparable [] a = {'M', 'E', 'R', 'G', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'};
    private static Comparable [] aux;

    public static void sort(Comparable [] a){
        aux = new Comparable[a.length];
        //for(int sz = 1; sz < a.length; sz = sz + sz){   //A E E E G L M M O P R R S T X
        //for(int sz = 1; sz < a.length; sz += 1){          //A E E E G L M M O P R R S T X
        for(int sz = 1; sz < a.length; sz += sz){          //A E E E G L M M O P R R S T X
            for(int lo = 0; lo < a.length - sz; lo += sz + sz){
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
            }
        }
    }

    private static void sort(Comparable [] a, int lo, int hi){
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
