package algs.ch24;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 8/27/16.
 */
public class Cl241 {

    public static void main(String [] args) {
        int i = 0;
        String s = "PRIO*R**I*T*Y***QUE***U*E";
        MaxPQ pq = new MaxPQ(20);
        while(i < s.length()) {
            if(s.charAt(i) != '*') {
                pq.insert(s.charAt(i));
            } else {
                StdOut.println(pq.delMax());
            }
            i++;
        }
    }
}
