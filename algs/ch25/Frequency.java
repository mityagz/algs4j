package algs.ch25;

//import com.sun.prism.impl.Disposer;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 9/17/16.
 */

 // ex 2.5.8

public class Frequency {

    public static void main(String [] args) {
        String [] a = StdIn.readAllStrings();
        int n = a.length;
        int [] b = new int[n];
        int s;
        Arrays.sort(a);

        Record [] rec = new Record[n];
        String w = a[0];
        int m = 0;
        int f = 1;

        for(int i = 1; i < n; i++) {
            if (!a[i].equals(w)) {
                rec[m++] = new Record(w, f);
                w = a[i];
                f = 0;
            }
            f++;
        }

        rec[m++] = new Record(w, f);

        Arrays.sort(rec, 0, m);
        for (int i = m-1; i >= 0; i--)
            StdOut.println(rec[i]);
    }


    public static class Record implements Comparable {
        String w;
        int f;
        Record(String w, int f) {
            this.w = w;
            this.f = f;
        }

        @Override
        public String toString() {
            return f + " " + w;
        }

        public int compareTo(Object x) {
            int o = ((Record)x).f;
            if(f < o)
                return -1;
            if(f > o)
                return 1;
            return 0;
        }
    }
}
