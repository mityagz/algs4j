package algs.ch44;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

/**
 * Created by mitya on 3/26/17.
 */
public class MultiSourceDijkstraSP {
    private EdgeWeightedDigraph G;
    private double [] distTo;
    private DirectedEdge [] edgeTo;
    private IndexMinPQ<Double> pq;
    private int source;

    public MultiSourceDijkstraSP(EdgeWeightedDigraph G, Iterable<Integer> sources) {
        this.G = G;
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for(int i = 0; i < G.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;

        for(int i : sources) {
            distTo[i] = 0.0;
            pq.insert(i, distTo[i]);
        }
    }

    public MultiSourceDijkstraSP(EdgeWeightedDigraph G, int s) {
        source = s;
        this.G = G;
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for (int i = 0; i < G.V(); ++i)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[source] = 0;
        pq.insert(source, distTo[source]);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            relax(v);
        }
    }

    private void relax(int v) {
        for(DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if(distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if(!pq.contains(w)) {
                    pq.insert(w, distTo[w]);
                } else {
                    pq.change(w, distTo[w]);
                }
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        if(distTo[v] != Double.POSITIVE_INFINITY)
            return true;
        return false;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> stack = new Stack<DirectedEdge>();
        /*
        for (DirectedEdge e = edgeTo[v]; edgeTo[v] != null; e = edgeTo[v], v = edgeTo[v].from()) {
            stack.push(e);
        }
        */


        while(edgeTo[v] != null ) {
            stack.push(edgeTo[v]);
            v = edgeTo[v].from();
        }


        return stack;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/tinyEWD.txt"));
        StdOut.print();

        Bag<Integer> sources = new Bag<Integer>();
        In sin = new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/sources.txt");
        //In tin = new In("target.txt");
        while (!sin.isEmpty()) {
            int v = sin.readInt();
            sources.add(v);
        }
        MultiSourceDijkstraSP sp = new MultiSourceDijkstraSP(G, sources);
        for (int v = 0; v < G.V(); ++v) {
            StdOut.print(v + " " + sp.distTo(v) + "   : ");
            for (DirectedEdge e : sp.pathTo(v))
                StdOut.print(e + "   ");
            StdOut.println();
        }

        /*
        double min = Double.POSITIVE_INFINITY;
        while (!tin.isEmpty()) {
            int t = tin.readInt();
            if (sp.distTo(t) < min)
                min = sp.distTo(t);
        }

        StdOut.println(min);
        */
    }
}
