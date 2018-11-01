package algs.ch42;

import edu.princeton.cs.algs4.Queue;

import java.util.Iterator;

/**
 * Created by mitya on 2/22/17.
 */
public class Degrees {
    private int[] indegrees;
    private int[] outdegrees;
    private Queue<Integer> sources;
    private Queue<Integer> sinks;
    private boolean isMap;

    Degrees(Digraph G) {
        isMap = true;
        indegrees = new int[G.V()];
        outdegrees = new int[G.V()];
        sources = new Queue<Integer>();
        sinks = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                outdegrees[v]++;
                indegrees[w]++;
            }
        }

        for (int v = 0; v < G.V(); v++) {
            if (outdegrees[v] == 0)
                    sinks.enqueue(v);
            if (indegrees[v] == 0)
                    sources.enqueue(v);
            if(outdegrees[v] != 1)
                isMap = false;
        }
    }

    public int indegree(int v) {
        return indegrees[v];
    }

    public int outdegree(int v) {
        return outdegrees[v];
    }

    public Iterable<Integer> sources() {
        return sources;
    }

    public Iterable<Integer> sinks() {
        return sinks;
    }

    public boolean isMap() {
        return isMap;
    }
}
