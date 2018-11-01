package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 3/7/16.
 */
public class FibSearch {


    public static int fib_search(int [] a, int key){
        int f1 = 1, f2 = 0, m = 2, first = 0, index, n = a.length;
        Arrays.sort(a);
        while(f1 < n){
            f1 = f1 + f2;
            f2 = f1 - f2;
            m++;
        }
        StdOut.println("f1 f2 m: " + f1 + " " + f2 + " " + m);
        f2 = f1 - f2;
        f1 = f1 - f2;
        m--;

        StdOut.println("f1 f2 m: " + f1 + " " + f2 + " " + m);

        while(m > 0){
            index = first + f1;
            StdOut.println("first: " + first + " index: " + index + " f1: " + f1 + " a: " + a[index]);
            if(index >= n || key < a[index]){
                m--;
                f2 = f1 - f2;
                f1 = f1 - f2;
            }else if(key == a[index]){
                return index;
            }else{
                first = index;
                m -= 2;
                f1 = f1 - f2;
                f2 = f2 - f1;
            }
        }

        return -1;
    }

    public static void main(String [] args){
        int a [] = In.readInts(args[0]);
        StdOut.println("Index of key: " + fib_search(a, Integer.parseInt(args[1])));
    }
}
