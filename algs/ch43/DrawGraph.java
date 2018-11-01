package algs.ch43;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Created by mitya on 3/5/17.
 */
public class DrawGraph {
    private EdgeWeightedGraph g;
    private int V;
    private int range;
    public DrawGraph(EdgeWeightedGraph g) {
        this.g = g;
        V = g.V();
        range = (int)Math.ceil(Math.sqrt(V));
    }

    private int x(int v) {
        return v % range;
    }
    private int y(int v) {
        return v/ range;
    }

    public void show() {
        StdDraw.setXscale(-1, range);
        StdDraw.setYscale(-1, range);

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < V; ++i) {
            for (Edge e : g.adj(i)) {
                int w = e.other(i);
                StdDraw.line(x(w), y(w), x(i), y(i));
            }
        }
        StdDraw.setPenRadius(0.05);
        for (int i = 0; i < V; ++i) {
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.point(x(i), y(i));
            StdDraw.setPenColor(Color.RED);
            StdDraw.textLeft(x(i), y(i), i + " ");
        }
    }
    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(new In("/home/mitya/wrk/alg/algs4/data/algs4-data/tinyEWD.txt"));
        DrawGraph drawGraph = new DrawGraph(G);
        drawGraph.show();
    }
}
