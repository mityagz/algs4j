package algs.ch2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/19/16.
 */
public class Cl211 {
    public static void main(String [] args){
        String [] a = In.readStrings();
        Selection2.sort(a);
        assert Selection2.isSorted(a);
        Selection2.show(a);
    }
}

 class Selection2 {
     static void sort(Comparable [] a){
         System.out.print("i  m   ");
         for(int k = 0; k < a.length; k++) {
            System.out.print(k + " ");
        }
        System.out.println("\n--------------------------");
        for(int i = 0; i < a.length; i++){
            int min = i;
             for (int j = i + 1; j < a.length; j++){
                 if(less(a[j], a[min])) {
                     min = j;
                 }
             }
            System.out.printf("%-2d %-3d", i, min);
            for(int k = 0; k < a.length; k++){
                 System.out.print(a[k] + " ");
             }
            System.out.println();
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

    public static void show(Comparable [] a){
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
}
