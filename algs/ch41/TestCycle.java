package algs.ch41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/28/17.
 */
public class TestCycle {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        Cycle cycle = new Cycle(G);
        StdOut.println(cycle.hasCycle());
    }
}
