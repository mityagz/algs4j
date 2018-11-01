package algs.ch53;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/21/17.
 */
public class SpaceMatch {
    int m;

    public SpaceMatch(int m) {
        this.m = m;
    }

    public  int search(String t) {
        int n = t.length();
        int count = 0;
        for (int i = 0; i < n - m; i++) {
            if(t.charAt(i) == ' ') {
                count++;
                if(count == m) return i + 1;
            } else {
                count = 0;
            }
        }
        return n;
    }

    public static void main(String [] args) {
        int pat = Integer.parseInt(args[1]);
        String txt = args[0];
        SpaceMatch kmp = new SpaceMatch(pat);
        int offset = kmp.search(txt);
        StdOut.println("text:    " + txt);
         StdOut.print( "pattern: ");
        for(int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
