package algs.ch43;

import edu.princeton.cs.algs4.*;

/**
 * Created by mitya on 3/5/17.
 */
public class SpecifiedSet {
    private UF uf;
    private MinPQ<Edge> pq;
    private EdgeWeightedGraph G;
    private Bag<Edge> edges;
    private double weight;
    private boolean f = true;

    public SpecifiedSet(EdgeWeightedGraph G, Iterable<Edge> edgeSet) {
        this.G = G;
        pq = new MinPQ<Edge>();
        uf = new UF(G.V());
        edges = new Bag<Edge>();

        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        for (Edge e : edgeSet) {
            int v = e.either();
            int w = e.other(v);
            uf.union(v, w);
            edges.add(e);
            weight += e.weight();
        }

        while (!pq.isEmpty() && edges.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) continue;
            else {
                f = false;
                edges.add(e);
                uf.union(v, w);
                weight += e.weight();
            }
        }
    }

    public boolean hasSet() {
        return f;
    }

    public double weight() {
        return weight;
    }

    public Iterable<Edge> edges() {
        return edges;
    }

    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("/home/mitya/wrk/alg/algs4/data/algs4-data/tinyEWG.txt"));
        StdOut.println(G);
        Bag<Edge> set = new Bag<Edge>();
        In in = new In("/home/mitya/wrk/alg/algs4/data/algs4-data/edgeSet.txt");
        while (!in.isEmpty()) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            set.add(new Edge(v, w, weight));
        }

        SpecifiedSet specifiedSet = new SpecifiedSet(G, set);

        for (Edge e : specifiedSet.edges()) {
            StdOut.print(e + " ");
        }

        StdOut.println();
        StdOut.println("Is Set? " + specifiedSet.hasSet());
        StdOut.println();
        StdOut.println(specifiedSet.weight());
    }
}
