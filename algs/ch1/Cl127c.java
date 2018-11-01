package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/12/15.
 */
public class Cl127c {
    public static String mystery(String s){
        int n = s.length();
        if(n <= 1) return s;
        String a = s.substring(0, n/2);
        String b = s.substring(n/2, n);
        StdOut.println("----\n" + a);
        StdOut.println(b + "\n----");
        return mystery(a) + mystery(b);
    }
    public static void main(String [] args){
        StdOut.println(mystery("Hello"));

    }
}
