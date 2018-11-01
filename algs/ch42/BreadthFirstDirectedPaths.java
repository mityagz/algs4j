package algs.ch42;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

/**
 * Created by mitya on 2/11/17.
 */
public class BreadthFirstDirectedPaths {
    private int s;
    private Digraph G;
    private int edgeTo[];
    private int distTo[];
    private int maxDist;
    private boolean marked[];

    BreadthFirstDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> q = new Queue();
        q.enqueue(s);
        marked[s] = true;
        distTo[s] = 0;
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for(int w : G.adj(v)) {
                if(!marked[w]) {
                    q.enqueue(w);
                    marked[w] = true;
                    distTo[w] = distTo[v] + 1;
                    edgeTo[w] = v;
                    if(distTo[w] > maxDist)
                        maxDist = distTo[w];
                }
            }
        }
    }


    public int distTo(int v) { return distTo[v]; }

    public boolean hasPathTo(int v) { return marked[v]; }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x = v; x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }

    public int maxDist() { return maxDist; }
}
