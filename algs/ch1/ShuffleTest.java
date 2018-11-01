package algs.ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 12/4/15.
 */
public class ShuffleTest {
    static int [] a;
    static int [][] b;
    static int cnt = 0;
    public static void init(int n) {
        a = new int[n];
        b = new int[n][n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
           StdOut.print(a[i] + " ");
        }
        StdOut.println();
        StdOut.println();
    }


    public static void shuffle(int [] a){
        int n = a.length;
        int r, t;
        for(int i = 0; i < n; i++){
            r = StdRandom.uniform(0, n);
            t = a[i];
            a[i] = a[r];
            a[r] = t;
        }
        for(int i = 0; i < a.length; i++ ){
            StdOut.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j == a[i]) {
                    b[j][i]++;
                }
            }
        }
    }

    public static void out(int [] a){
        StdOut.println();
        for(int i = 0; i < a.length; i++ ){
            for(int j = 0; j < a.length; j++) {
                StdOut.print(b[i][j] + " ");
            }
            StdOut.println();
        }
    }

    public static void main(String [] args){
        init(10);
        for(int i = 0; i < a.length; i++) {
            shuffle(a);
            StdOut.println();
        }
        StdOut.println();
        out(a);
    }
}
