package algs.ch51;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 4/15/17.
 */
public class Count {
    public static void main(String [] args) {
        Alphabet alphabet = new Alphabet(args[0]);
        int R = alphabet.R();
        int [] count = new int[R];

        String s = StdIn.readAll();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            if(alphabet.contains(s.charAt(i)))
                count[alphabet.toIndex(s.charAt(i))]++;
        }

        for(int c = 0; c < R; c++) {
            StdOut.println(alphabet.toChar(c) + " contains " + count[c]);
        }
    }
}
