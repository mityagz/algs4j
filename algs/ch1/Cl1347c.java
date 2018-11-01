package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/31/16.
 */
public class Cl1347c {

    public static void main(String [] args){
        Stack s0 = new Stack<Integer>();
        Stack s1 = new Stack<Integer>();

        s0.push(1);
        s0.push(3);
        s0.push(7);
        s1.push(2);
        s1.push(4);

        for(Object x : s0){
            StdOut.println("S0: " + (Integer)x);
        }

        StdOut.println("--------------------");

        for(Object x : s1){
            StdOut.println("S1: " + (Integer)x);
        }

        StdOut.println("--------------------");

        s1.concatenate(s0);

        for(Object x : s1){
            StdOut.println("S1: " + (Integer)x);
        }
    }
}
