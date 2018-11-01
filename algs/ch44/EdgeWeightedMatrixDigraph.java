package algs.ch44;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/26/17.
 */
public class EdgeWeightedMatrixDigraph {
    private double [][] matrix;
    private int V;
    private int E;


    public EdgeWeightedMatrixDigraph(int V) {
        this.V = V;
        matrix = new double[V][V];
        for (int v = 0; v < V; v++)
            for (int w = 0; w < V; w++)
            matrix[v][w] = Double.POSITIVE_INFINITY;
    }

    public EdgeWeightedMatrixDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int e = 0; e < E; e++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            addEdge(v, w, weight);
        }

    }

    private void addEdge(int v, int w, double weight) {
        E++;
        matrix[w][v] = weight;
    }

    public double weight(int v, int w) {
       return matrix[v][w];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int v = 0; v < V; v++) {
            sb.append(v + " : \n");
            for(int w = 0; w < V; w++) {
                if(matrix[v][w] < Double.POSITIVE_INFINITY)
                   sb.append(v + "->" + w + " : " + weight(v, w) + "\n");
            }
        }
        return sb.toString();
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public static void main(String[] args) {
        EdgeWeightedMatrixDigraph G;
        G = new EdgeWeightedMatrixDigraph(new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/tinyEWD.txt"));
        StdOut.println(G.toString());
    }
}
