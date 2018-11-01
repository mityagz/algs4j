package algs.ch44;

import edu.princeton.cs.algs4.DijkstraSP;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/22/17.
 */
public class Diameter {
    public static void main(String [] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/tinyEWD.txt"));
        DijkstraSP[] st = new DijkstraSP[G.V()];
        double d = 0.0;
        for (int v = 0; v < G.V(); v++) {
            st[v] = new DijkstraSP(G, v);
            for(int i = 0; i < G.V();i++)
                if(st[v].distTo(i) > d)
                    d = st[v].distTo(i);
        }
        StdOut.println(d);
    }
}
