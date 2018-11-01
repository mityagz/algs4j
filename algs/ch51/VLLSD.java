package algs.ch51;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 4/29/17.
 */
public class VLLSD {
    public static void sort(String [] a, int w) {
        int n = a.length;
        int r = 256;
        String [] aux = new String[n];
        for(int d = w - 1; d >= 0; d--) {
            int [] count = new int[r + 2];
            int[] index = new int[r + 1];
            for(int i = 0; i < a.length; i++) {
                count[charAt(a[i], d) + 2]++;
            }

            for(int i = 1; i < r; i++) {
                //count[i + 1] += count[i];
                index[i] = index[i - 1] + count[i];
            }

            for(int i = 0; i < a.length; i++) {
                //aux[count[a[i].charAt(d)]++] = a[i];
                aux[index[charAt(a[i], d) + 1]++] = a[i];
            }

            for(int i = 0; i < a.length; i++) {
                a[i] = aux[i];
            }
        }
        StdOut.println(Arrays.toString(a));
    }

    private static int charAt(String a, int w) {
        if(w < a.length()) return a.charAt(w);
        return -1;
    }

    public static void main(String [] args) {
        /*
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
        */

        In in = new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/shells.txt");
        int N = 14;
        int W = 0;
        String[] a = new String[N];
        for(int i = 0; i < N; ++i) {
            a[i] = in.readString();
            if(W < a[i].length())
                W = a[i].length();
        }
            sort(a, W);
    }
}
