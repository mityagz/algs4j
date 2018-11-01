package algs.ch41;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/28/17.
 */
public class TestCC {
    public static void main(String [] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);
        int m = cc.count();
        StdOut.println(m + " components");
        Bag<Integer> [] components = new Bag[m];
        for(int i = 0; i < m; i++)
            components[i] = new Bag<Integer>();
        for (int v = 0; v < G.V(); v++)
            components[cc.id(v)].add(v);
        for(int i = 0; i < m; i++) {
            for(int v : components[i])
                StdOut.print(" " + v);
            StdOut.println();
        }
    }
}
