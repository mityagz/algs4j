package algs.ch53;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/24/17.
 */
public class BruteForceRL {
    public static int search1(String pat, String txt) {
        int offset = 0;
        int m = pat.length();
        int n = txt.length();
        for(int i = 0; i < n; i++) {
            offset = 0;
            for (int j = m - 1; j < m && i + j < n; j--) {
                if(txt.charAt(i + j) != pat.charAt(j))
                    break;
                offset++;
                if(offset == m) return i;
            }

        }

        return n;
    }


    public static int search2(String pat, String txt) {
        int offset = 0;
        int m = pat.length();
        int n = txt.length();
        for(int i = 0, j = m  - 1; j < m && i + j< n;) {
            if(txt.charAt(i + j) == pat.charAt(j)) {
                if(j == 0) return i;
                j--;
            } else {
                i++;
                j = m - 1;
            }
        }
        return n;
    }


     public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];

        int offset1a = search1(pat, txt);
        int offset2 = search2(pat, txt);

        StdOut.println("text:    " + txt);


        StdOut.print("pattern: ");
        for (int i = 0; i < offset1a; i++)
            StdOut.print(" ");
        StdOut.println(pat);


         StdOut.print("pattern: ");
        for (int i = 0; i < offset2; i++)
            StdOut.print(" ");
        StdOut.println(pat);
    }
}
