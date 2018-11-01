package algs.ch44;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/26/17.
 */
public class MatrixSP {
    private EdgeWeightedMatrixDigraph G;
    private double[] distTo;
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public MatrixSP(EdgeWeightedMatrixDigraph G, int s) {
        this.G = G;
        this.s = s;
        distTo = new double[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); ++ i)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        for(int v = 0; v < G.V(); v++) {
            double min = Double.POSITIVE_INFINITY;
            int index = 0;
            for (int i = 0; i < G.V(); i++) {
                if(!marked[i] && distTo[i] < min) {
                    min = distTo[i];
                    index = i;
                }
            }
            relax(index);
        }
    }

    private void relax(int v) {
        marked[v] = true;
        for(int w = 0; w < G.V(); w++) {
            if (!marked[w] && distTo[w] > distTo[v] + G.weight(v, w)) {
                distTo[w] = distTo[v] + G.weight(v, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v) {
        if(distTo(v) < Double.POSITIVE_INFINITY)
            return true;
        return false;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Bag<DirectedEdge> path = new Bag<DirectedEdge>();
        while(v != s) {
            path.add(new DirectedEdge(edgeTo[v], v, G.weight(edgeTo[v], v)));
            v = edgeTo[v];
        }
        return path;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public static void main(String[] args)
    {
        EdgeWeightedMatrixDigraph G;
        G = new EdgeWeightedMatrixDigraph(new In("/home/mitya/wrk/alg/algs4/data/algs4-data/tinyEWG.txt"));
        int s = 0;
        MatrixSP sp = new MatrixSP(G, s);

        for(int t = 0; t < G.V(); ++t){
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", sp.distTo(t));
            if(sp.hasPathTo(t))
                for (DirectedEdge e: sp.pathTo(t))
                    StdOut.print(e + "  ");
            StdOut.println();
        }
}
}
