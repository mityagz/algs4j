package algs.ch41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/28/17.
 */
public class TestGraphProperties {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        GraphProperties properties = new GraphProperties(G);

        StdOut.println(G);
        StdOut.println(properties.center());
        StdOut.println(properties.radius());
        StdOut.println(properties.diameter());
        StdOut.println(properties.girth());
    }
}
