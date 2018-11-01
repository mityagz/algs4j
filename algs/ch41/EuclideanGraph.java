package algs.ch41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

/**
 * Created by mitya on 2/5/17.
 */
public class EuclideanGraph {
    private Graph g;
    private int V;
    private int range;

    public EuclideanGraph(Graph g) {
        this.g = g;
        V = g.V();
        range = (int) Math.ceil(Math.sqrt(V));
    }

    private int x(int v) {
        return v % range;
    }

    private int y(int v) {
        return v / range;
    }

    public void show() {
        StdDraw.setXscale(-1, range);
        StdDraw.setYscale(-1, range);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.setPenRadius(0.05);
        for (int i = 0; i < V; ++i) {
            StdDraw.point(x(i), y(i));
        }

        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < V; ++i) {
            for (int w : g.adj(i))
                StdDraw.line(x(w), y(w), x(i), y(i));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(new In("connect.txt"));
        StdOut.println(graph);
        EuclideanGraph draw = new EuclideanGraph(graph);

        draw.show();
    }
}
