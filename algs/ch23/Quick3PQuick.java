package algs.ch23;

import algs.ch2.Insertion;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 8/8/16.
 */

// 2.3.22

public class Quick3PQuick {
    private static final int INSERTION_SORT_CUTOFF = 8;
    private static final int MEDIAN_OF_3_CUTOFF = 40;

    //static Comparable [] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
    //static Comparable [] a = {3, 15, 1, 100, 102, 4, 5, 9, 17, 5, 9, 7, 100, 3, 150, 700, 3, 100, 9, 3, 7, 7, 3, 9, 3};
    //static Comparable [] a = {7, 5, 5, 4, 9, 7, 100, 100, 1, 150, 7, 9, 3, 17, 102, 9, 3, 9, 3, 700, 15, 3, 3, 100, 3 };
    //static Comparable [] a = {3, 15, 1, 100, 102, 4, 5, 9, 17, 7};

    public static void sort(Comparable [] a){
        StdRandom.shuffle(a);
        show(a);
        StdOut.println();
        sort(a, 0, a.length - 1);
    }

    private static boolean less(Comparable v, Comparable w){
        if(v.compareTo(w) < 0)
            return true;
        return false;
    }

    private static void exch(Comparable [] a, int i, int j){
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void insertionSort(Comparable [] a, int lo, int hi){
        for(int i = 1; i < a.length; i++){
             for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                 exch(a, j, j - 1);
             }
        }
    }

    /*
    private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }
    */

    private static int median3(Comparable [] a, int i, int j, int k){
        return a[i].compareTo(a[j]) < 0 ?
               (a[k].compareTo(a[i]) < 0 ? i : (a[k].compareTo(a[j]) < 0 ? k : j)) : (a[k].compareTo(a[j]) < 0 ? j : (a[k].compareTo(a[i]) < 0 ? k : i)); // j i
        //return i < j ? (k < i ? i : (k < j ? k : j)) : (k < j ? j : (k < i ? k : i)); // j i
    }

    //  == v        < v        unsorted     > v       == v
    // (lo, p - 1) (p, i - 1) (i, j)       (j + 1, q)(q + 1, hi)
    //
    //

    public static void sort(Comparable [] a, int lo, int hi) {
        int n = hi - lo + 1;
        //if(lo >= hi) return;
        if(n < INSERTION_SORT_CUTOFF){
            insertionSort(a, lo, hi);
            return;
        } else if(n < MEDIAN_OF_3_CUTOFF){
            int m = median3(a, lo, lo + n/2, hi);
            exch(a, lo, m);
        } else {
            int pcs8 = n/8;
            int mid = lo + n/2;
            int m0 = median3(a, lo, lo + pcs8, lo + pcs8 + pcs8); //  lo . 1/8. 2/8 . 3/8.  mid . . . . hi
            int m1 = median3(a, mid - pcs8, mid, mid + pcs8);
            int m2 = median3(a, hi - pcs8 - pcs8, hi - pcs8, hi);
            int m = median3(a, m0, m1, m2);
            exch(a, m, lo);
        }


        int i = lo, j = hi + 1;
        int p = lo, q = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (Insertion.less(a[++i], v)) if (i == hi) break;
            while (Insertion.less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            Insertion.exch(a, i, j);
            if(eq(a[i], v)) Insertion.exch(a, ++p, i);
            if(eq(a[j], v)) Insertion.exch(a, --q, j);
        }


        i = j + 1;
        for (int k = lo; k <= p; k++)
            Insertion.exch(a, k, j--);
        for (int k = hi; k >= q; k--)
            Insertion.exch(a, k, i++);


        sort(a, lo, j);
        sort(a, i, hi);
    }




    private static boolean eq(Comparable v, Comparable w) {
        return v.compareTo(w) == 0;
    }


    //  < v     == v         unsorted    > v
    // (lo, lt) (lt, i - 1) (i, gt) (gt + 1, hi)
    //
    //
    /*
    private static void sort(Comparable [] a, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0) Insertion.exch(a, lt++, i++);
            else if(cmp > 0) Insertion.exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
    */
    //  <        ==             >            unsorted
    // (lo, lt), (lt + 1, gt), (gt + 1, i), (i + 1, hi -1)
    // (lo, lt) < c
    // (lt + 1, gt) == c
    // (gt + 1, i) > c
    // (i + 1, hi -1) unsorted

    /*
    private static void sort(Comparable [] a, int lo, int hi){
        int v = hi;
        int lt = lo, eq = lo, gt = lo;
        if(hi <= lo) return;
        while(gt < hi){
            int c = a[gt].compareTo(a[v]);
            if(c <= 0){
                Insertion.exch(a, lt, gt);
                if(lt != eq){
                    Insertion.exch(a, gt, eq);
                }
                eq++; lt++; gt++;
            }else if(c > 0){
                gt++;
            }else{
                Insertion.exch(a, eq++, gt++);
            }
        }
        Insertion.exch(a, hi, lt); gt++;
        sort(a, lo, lt - 1);
        sort(a, lt + 1, hi);
    }
    */

    /*
    private static void sort(Comparable [] a, int lo, int hi){
        int v = hi;
        int lt = lo, eq = lo, gt = lo;
        if(hi <= lo) return;
        while(gt < hi){
            int c = a[gt].compareTo(a[v]);
            if(c <= 0){
                Insertion.exch(a, lt, gt);
                if(lt != eq){
                    Insertion.exch(a, gt, eq);
                }
                eq++;
                lt++;
                gt++;
            }else if(c > 0){
                gt++;
            }else{
                Insertion.exch(a, eq, gt);
                gt++;
                eq++;
            }
        }
        Insertion.exch(a, hi, lt); gt++;
        sort(a, lo, lt - 1);
        sort(a, lt + 1, hi);
    }
    */


    /*
    private static void sort(Comparable [] a, int lo, int hi){
        int v = hi;
        int lt = lo, i = lo;
        if(hi <= lo) return;
        while(i < hi){
            int c = a[i].compareTo(a[v]);
            if(c <= 0){
                Insertion.exch(a, lt++, i);
            }
            i++;
        }
        Insertion.exch(a, lt , hi);
        sort(a, lo, lt - 1);
        sort(a, lt + 1, hi);
    }
    */


     private static void show(Comparable [] a) {
         for (int i = 0; i < a.length; i++) {
             StdOut.print(a[i] + " ");
         }
     }

    public static void main(String [] args){
        Comparable [] a = StdIn.readAllStrings();
        show(a);
        StdOut.println();
        sort(a);
        StdOut.println();
        show(a);
    }
}
