package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/29/16.
 */
public class Cl1342c {

    public static void main(String [] args){
        Stack s = new Stack<Integer>();
        s.push(11);
        s.push(7);
        s.push(3);
        for(Object i : s){
            StdOut.println("s: " + i);
        }

        StdOut.println("---");

        Stack n = new Stack(s);
        for(Object i : n){
            StdOut.println("n: " + i);
        }

        StdOut.println("---");

        s.pop();

        n.push(91);

            for(Object i : s){
            StdOut.println("s: " + i);
        }

        StdOut.println("---");


        for(Object i : n){
            StdOut.println("n: " + i);
        }

    }
}
