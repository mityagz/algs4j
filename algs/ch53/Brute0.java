package algs.ch53;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/18/17.
 */
public class Brute0 {

    static int cnt = 0;

    public static int search1(String pat, String txt) {
        int offset = 0;
        int m = pat.length();
        int n = txt.length();
        for(int i = 0; i <= n - m; i++) {
            offset = 0;
            for (int j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
                 offset++;
                if (offset == m)
                    return i;
            }
        }

        return n;
    }

    public static int search2(String pat, String txt) {
        int offset = 0;
        int m = pat.length();
        int n = txt.length();
        for(int i = 0, j = 0; j < m && i < n; i++) {
            if(txt.charAt(i) == pat.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
            if(j == m) return i - m + 1;
        }
        return n;
    }

    public static int search1(char[] pattern, char[] text) {
        int m = pattern.length;
        int n = text.length;
        int offset = 0;
        for(int i = 0; i <= n - m; i++) {
            offset = 0;
            for (int j = 0; j < m; j++) {
                if(text[i + j] != pattern[j])
                    break;
                offset++;
            }
            if(offset == m)
                return i;
        }

        return n;
    }

    public static int search2(char[] pattern, char[] text) {
        int offset = 0;
        int m = pattern.length;
        int n = text.length;
        for(int i = 0, j = 0; j < m && i < n; i++) {
            if(text[i] == pattern[j]) j++;
            else {
                i -= j;
                j = 0;
            }
            if(j == m) return i - m + 1;
        }
        return n;
    }


    public static Iterable<Integer> findAll() {
        return null;
    }

    public int count() {
        return 0;
    }

    public static void searchAll(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int gOffset = 0, lOffset, cutOffset = 0;
        StdOut.println("------------------------------------");

        for (lOffset  = 0; lOffset < n - m;) {
            lOffset = search1(pat, txt);
            gOffset = lOffset + cutOffset;
            cutOffset += lOffset + m;
            txt = txt.substring(lOffset + m, n);
            n = txt.length();
            lOffset = 0;
            StdOut.print("pattern: ");
            for (int i = 0; i < gOffset; i++)
                StdOut.print(" ");
            StdOut.println(pat);
        }
        StdOut.println("------------------------------------");
    }


    public static int count(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int gOffset = 0, lOffset, cutOffset = 0;

        for (lOffset  = 0; lOffset < n - m;) {
            lOffset = search1(pat, txt);
            gOffset = lOffset + cutOffset;
            cutOffset += lOffset + m;
            txt = txt.substring(lOffset + m, n);
            n = txt.length();
            lOffset = 0;
            cnt++;
        }
      return cnt;
    }

     public static void main(String[] args) {
        String pat = args[0];
        String txt = args[1];
        char[] pattern = pat.toCharArray();
        char[] text    = txt.toCharArray();

        int offset1a = search1(pat, txt);
        int offset2a = search2(pat, txt);
        int offset1b = search1(pattern, text);
        int offset2b = search2(pattern, text);


        StdOut.println("text:    " + txt);


        StdOut.print("pattern: ");
        for (int i = 0; i < offset1a; i++)
            StdOut.print(" ");
        StdOut.println(pat);

        searchAll(pat, txt);
        StdOut.println("Count match pat: " + count(pat, txt));


        StdOut.print("pattern: ");
        for (int i = 0; i < offset2a; i++)
            StdOut.print(" ");
        StdOut.println(pat);


        StdOut.print("pattern: ");
        for (int i = 0; i < offset1b; i++)
            StdOut.print(" ");
        StdOut.println(pat);


        StdOut.print("pattern: ");
        for (int i = 0; i < offset2b; i++)
            StdOut.print(" ");
        StdOut.println(pat);

    }
}
