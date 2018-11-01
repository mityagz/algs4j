package algs.ch51;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 4/29/17.
 */
public class Quick3string {

    private static void exch(String [] a, int i, int j) {
        String t;
        t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int charAt(String s, int d) {
        if(d < s.length())
            return s.charAt(d);
        else return -1;
    }

    public static void sort(String [] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String [] a, int lo, int hi, int d) {
        if(hi <= lo) return;
        int lt = lo;
        int gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if(t < v) exch(a, lt++, i++);
            else if(t > v) exch(a, i, gt--);
            else i++;
        }

        sort(a,lo, lt - 1, d);
        if(v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }

    public static void main(String [] args) {
        int i = 0;
        String [] s = new String[Integer.parseInt(args[0])];
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            s[i++] = name;
        }

        sort(s);

        for(i = 0; i < s.length; i++) {
            StdOut.println(s[i]);
        }
    }
}
