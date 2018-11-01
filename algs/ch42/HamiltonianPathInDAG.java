package algs.ch42;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/25/17.
 */
public class HamiltonianPathInDAG {
    private Digraph G;
    Topological topological;
    private boolean hasHamiltonianPath;
    public HamiltonianPathInDAG(Digraph G) {
        this.G = G;
        topological = new Topological(G);
        if(!topological.isDAG()) {
            StdOut.println("Graph isn't DAG");
            return;
        }

        hasHamiltonianPath = true;

        int p = -1;
        for(int i : topological.order()) {
            if(p == -1) {
                p = i;
                continue;
            }
            if(!G.hasEdge(p, i)) {
                hasHamiltonianPath = false;
                break;
            }
            p = i;

            /*
            boolean f = false;
            for (int v : G.adj(p)) {
                if(v == i) {
                    f = true;
                    break;
                }
                if(!f) {
                    hasHamiltonianPath = false;
                    break;
                }
            p = i;
            }
            */
        }

    }

    public boolean hasHamiltonianPath() {
        return hasHamiltonianPath;
    }

    public Iterable<Integer> hamiltonianPath() {
        return topological.order();
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In("/home/mitya/wrk/alg/algs4/data/algs4-data/tinyDAG.txt"));
        StdOut.println(G);

        HamiltonianPathInDAG hamiltonianPathInDAG = new HamiltonianPathInDAG(G);
        StdOut.println(hamiltonianPathInDAG.hasHamiltonianPath());
    }
}
