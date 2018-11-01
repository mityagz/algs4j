package algs.ch44;

import edu.princeton.cs.algs4.In;

/**
 * Created by mitya on 4/1/17.
 */
public class LineGraph {
    private double[] weight;
    private int V;
    public LineGraph(In in) {
        V = in.readInt();
        weight = new double[V];
        for(int i = 0; i < V - 1; ++i) {
            double e = in.readDouble();
            weight[i + 1] = weight[i] + e;
        }
    }
    public double weight(int v, int w) {
        return Math.abs(weight[w] - weight[v]);
    }
    public int V() {
        return V;
    }
}
