package algs.ch53;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/4/17.
 */
public class KMP1 {
    private String pat;
    private int [][] dfa;

    public KMP1(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 0; j < M; j++) {
            for(int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }

        if(j == M ) return i - M;
        else return N;
    }

    public int search(In stdin) {
        int i, j, cnt, M = pat.length();
        for (i = 0, j = 0; !stdin.isEmpty() && j < M; i++) {
            j = dfa[stdin.readChar()][j];
        }

        if(j == M ) return i - M;
        else return i;
    }

    public int count(String txt) {
        int j = 0;
        int cnt = 0;

        while (true) {
            j = search(txt);
            if (j < txt.length())
               cnt++;
            else break;
            txt = txt.substring(j + 1);
        }
        return cnt;
    }

    public Iterable<Integer> searchAll(String txt) {
        int j = 0;
        int p = 0;
        Queue<Integer> q = new Queue<Integer>();
        while (true) {
            j = search(txt);
            if (j < txt.length()) {
                q.enqueue(j + p);
            } else break;
            p = p + j + 1;
            txt = txt.substring(j + 1);
        }
        return q;
    }

    public static void main(String [] args) {
        String pat = args[0];
        String txt = args[1];
        int offset3 = 0;
        KMP1 kmp = new KMP1(pat);
        int offset = kmp.search(txt);
        StdOut.println("text:    " + txt);
         StdOut.print("pattern: ");
        for(int i = 0; i < offset; i++)
            StdOut.print(" ");
        StdOut.println(pat);

        StdOut.println("Count: " + kmp.count(txt));

        StdOut.println("text:    " + txt);
        for(int i: kmp.searchAll(txt)) {
            StdOut.print("pattern: ");
            for (int j = 0; j < i; ++j)
                StdOut.print(" ");
            StdOut.println(pat);
        }
        StdOut.println("Count: " + kmp.count(txt));

        if(args.length == 3) {
            offset3 = kmp.search(new In(args[2]));
            StdOut.println("text3:    " + txt);
            StdOut.print("pattern3: ");
            for (int i = 0; i < offset3; i++)
                StdOut.print(" ");
            StdOut.println(pat);
        }
    }
}
