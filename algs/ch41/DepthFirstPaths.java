package algs.ch41;

import edu.princeton.cs.algs4.Stack;

/**
 * Created by mitya on 1/16/17.
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int [] edgeTo;
    private int s;
    private int count;
    private Graph G;

    /*
    DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    */

    DepthFirstPaths(Graph G, int s) {
        this.G = G;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    /*
    private void dfs(int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

        }
    }
    */

    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }

        }
    }

    public int count() { return count; }

    public boolean hasPathTo(int v) {
        return marked[v];
    }


    public Iterable<Integer> PathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path     ;
    }

    public boolean marked(int w) { return  marked[w]; }
}
