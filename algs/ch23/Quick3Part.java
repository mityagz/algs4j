package algs.ch23;

import algs.ch2.Insertion;
import algs.ch2.Selection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import algs.ch22.*;

/**
 * Created by mitya on 7/24/16.
 */
public class Quick3Part {

    //static Comparable [] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
    static Comparable [] a = {3, 15, 1, 100, 102, 4, 5, 9, 17, 5, 9, 7, 100, 150, 700, 100, 9, 7, 7, 9};
    //static Comparable [] a = {3, 15, 1, 100, 102, 4, 5, 9, 17, 7};

    public static void sort(Comparable [] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    //  <        ==             >            unsorted
    // (lo, lt), (lt + 1, gt), (gt + 1, i), (i + 1, hi -1)
    // (lo, lt) < c
    // (lt + 1, gt) == c
    // (gt + 1, i) > c
    // (i + 1, hi -1) unsorted


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
        show(a);
        sort(a);
        StdOut.println();
        show(a);
    }
}
