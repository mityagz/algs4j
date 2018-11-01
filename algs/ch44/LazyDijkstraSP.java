package algs.ch44;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/19/17.
 */
public class LazyDijkstraSP {
    private EdgeWeightedDigraph G;
    private double[] disTo;
    private DirectedEdge[] edgeTo;
    private MinPQ<Pack> pq;
    private boolean[] marked;
    private int source;

    private class Pack implements Comparable<Pack> {
        double disTo;
        int p;

        public Pack(int p, double disTo) {
            this.p = p;
            this.disTo = disTo;
        }

        public int compareTo(Pack other) {
            if (disTo > other.disTo)
                return 1;
            if (disTo < other.disTo)
                return -1;
            return 0;
        }
    }

    public LazyDijkstraSP(EdgeWeightedDigraph G, int s) {
        source = s;
        this.G = G;
        disTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        marked = new boolean[G.V()];
        pq = new MinPQ<Pack>();
        for(int i = 0; i < G.V(); ++i)
            disTo[i] = Double.POSITIVE_INFINITY;
        disTo[source] = 0;
        pq.insert(new Pack(source, distTo(source)));
        while(!pq.isEmpty()) {
            Pack v = pq.delMin();
            if (!marked[v.p]) {
                relax(v.p);
                marked[v.p] = true;
            }
        }
    }

    private void relax(int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (disTo[w] > disTo[v] + e.weight()) {
                disTo[w] = disTo[v] + e.weight();
                edgeTo[w] = e;
                pq.insert(new Pack(w, distTo(w)));
            }
        }
    }

    public double distTo(int v) {
        return disTo[v];
    }

    public boolean hasPathTo(int v) {
        return disTo[v] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
        while (edgeTo[v] != null) {
            stack.push(edgeTo[v]);
            v = edgeTo[v].from();
        }
        return stack;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/tinyEWD.txt"));
        int s = 0;
        LazyDijkstraSP sp = new LazyDijkstraSP(G, s);

        for (int t = 0; t < G.V(); ++t) {
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", sp.distTo(t));
            if (sp.hasPathTo(t))
                for (DirectedEdge e : sp.pathTo(t))
                    StdOut.print(e + "  ");
            StdOut.println();
        }
    }
}
