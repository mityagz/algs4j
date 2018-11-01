package algs.ch41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/28/17.
 */
public class TestTwoColor {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        TwoColor twoColor = new TwoColor(G);
        StdOut.println(twoColor.isTwoColorable());
    }
}
