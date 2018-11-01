package algs.ch24;

import edu.princeton.cs.algs4.StdOut;

import java.security.Key;
import java.util.Iterator;

/**
 * Created by mitya on 8/27/16.
 */
public class Cl245 {
    public static void main(String [] args) {
        int i = 0;
        String s = "EASYQUESTION";
        MaxPQ<Character> pq = new MaxPQ<Character>(s.length());
        while(i < s.length()) {
                pq.insert(s.charAt(i++));
        }

        for(Object it : pq) {
            StdOut.println((Character)it);
        }
    }
}
