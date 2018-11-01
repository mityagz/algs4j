package algs.ch25;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 9/13/16.
 */

// ex 2.5.4

public class DeDup {

    public static String [] dedup(String [] a) {
        String [] t = new String[a.length];
        int j = 1;
        t[0] = a[0];
        for(int i = 1; i < a.length; i++){
            if(a[i - 1] != a[i]) {
                t[j++] = a[i];
            }
        }

        String [] tt = Arrays.copyOf(t, j);
        return tt;
    }

    public static void main(String [] args) {
        String [] a = new String[10];

        a[0] = "abyrvalg";
        a[1] = "abyrvalg";
        a[2] = "abcd";
        a[3] = "qwerty";
        a[4] = "asdfgy";
        a[5] = "qwerty";
        a[6] = "cderfv";
        a[7] = "asdfgy";
        a[8] = "abyrvalg";
        a[9] = "cffvvbgty";


        for(int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }

        Selection.sort(a);
        StdOut.println();
        String [] b = dedup(a);

        for(int i = 0; i < b.length; i++) {
            StdOut.println(b[i]);
        }
    }
}
