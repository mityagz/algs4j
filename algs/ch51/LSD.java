package algs.ch51;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 4/17/17.
 */
public class LSD {

    public static void sort(String [] a, int w) {
        int n = a.length;
        int r = 256;
        String [] aux = new String[n];
        for(int d = w - 1; d >= 0; d--) {
            int [] count = new int[r + 1];
            for(int i = 0; i < a.length; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            for(int i = 0; i < r; i++) {
                count[i + 1] += count[i];
            }

            for(int i = 0; i < a.length; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            for(int i = 0; i < a.length; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String [] args) {
        int i = 0;
        String [] s = new String[Integer.parseInt(args[0])];
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            s[i++] = name;
        }

        sort(s, s[0].length());

        for(i = 0; i < s.length; i++) {
            StdOut.println(s[i]);
        }
    }
}
