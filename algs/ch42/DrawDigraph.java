package algs.ch42;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午7:09
 * To change this template use File | Settings | File Templates.
 */

public class DrawDigraph {
    private Digraph g;
    private int V;
    private int range;
    public DrawDigraph(Digraph g) {
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
        for(int i = 0; i < V; ++i) {
            for(int w : g.adj(i))
                StdDraw.line(x(w),y(w),x(i),y(i));
        }
        StdDraw.setPenRadius(0.05);
        for(int i = 0; i < V; ++i) {
            StdDraw.setPenColor(Color.GREEN);
            StdDraw.point(x(i), y(i));
            StdDraw.setPenColor(Color.RED);
            StdDraw.textLeft(x(i), y(i), i + " ");
        }
    }
    public static void main(String[] args) {
        Digraph G = new Digraph(new In("/home/mitya/wrk/alg/algs4/data/algs4-data/tinyDAG.txt"));
        StdOut.println(G);

        Topological topological = new Topological(G);
        if (topological.isDAG()) {
            for (int w : topological.order()) {
                StdOut.print(w + " ");
            }
            StdOut.println();
        } else
            StdOut.println("not DAG");

        DrawDigraph drawDigraph = new DrawDigraph(G);
        drawDigraph.show();
    }
}
