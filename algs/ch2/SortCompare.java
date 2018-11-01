package algs.ch2;

import algs.ch1.StopWatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.geom.Line2D;

/**
 * Created by mitya on 6/14/16.
 */
public class SortCompare {

    public static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] a = new Double[n];
        for (int j = 0; j < t; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String [] args){
        String alg0 = args[0];
        String alg1 = args [1];
        int n = Integer.parseInt(args[2]);
        int t = Integer.parseInt(args[3]);
        double t0 = timeRandomInput(alg0, n, t);
        double t1 = timeRandomInput(alg1, n, t);
        StdOut.printf("Для %d случайных Doubles\n %s в ", n, alg0);
        StdOut.printf("%.1f раз быстрее, чем %s\n", t0/t1, alg1);
    }

    public static double time(String alg, Comparable [] a){
        StopWatch timer = new StopWatch();
        if(alg.equals("Вставки")) Insertion.sort(a);
        if(alg.equals("Выбор")) Selection.sort(a);
        if(alg.equals("Шелл")) Shell.sort(a);
        //if(alg.equals("Слияние")) Merge.sort(a);
        //if(alg.equals("Быстрая")) Quick.sort(a);
        //if(alg.equals("Пирамидальная")) Heap.sort();
        return timer.elapsedTime();
    }
}
