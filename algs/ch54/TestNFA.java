package algs.ch54;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 7/7/17.
 */
public class TestNFA {
    public static void main(String[] args) {
        In in = new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/tinyL.txt");
        //String regexp = StdIn.readString();
        String regexp = args[0];

        NFA18 nfa = new NFA18(regexp);

        while (!in.isEmpty()) {
            String s = in.readLine();
            if (nfa.recognizes(s))
                StdOut.println("Match: " + s);

        }

        //nfa.recognizes("MITYA");
    }
}
