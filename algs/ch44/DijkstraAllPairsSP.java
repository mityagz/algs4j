package algs.ch44;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/9/17.
 */
public class DijkstraAllPairsSP {
    private DijkstraSP [] all;

    DijkstraAllPairsSP(EdgeWeightedDigraph G) {
        all = new DijkstraSP[G.V()];
        for(int v = 0; v < G.V(); v++)
            all[v] = new DijkstraSP(G, v);
    }

    public Iterable<DirectedEdge> path(int s, int t) {
        return  all[s].pathTo(t);
    }

    public double dist(int s, int t) {
        return all[s].distTo(t);
    }

    public static void main(String [] args) {
        In in = new In(args[0]);
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
        DijkstraAllPairsSP allPairsSP = new DijkstraAllPairsSP(G);

        for(int v = 0; v < G.V(); v++) {
            for (int w = 0; w < G.V(); w++) {
                if(v != w) {
                    StdOut.println("v:" + v + " w:" + w);
                    StdOut.printf("%.2f\n", allPairsSP.dist(v, w));
                    StdOut.print(allPairsSP.path(v, w) + " ");
                }
                StdOut.println();
            }
            StdOut.println();
        }
    }
}
