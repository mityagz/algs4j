package algs.ch41;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/28/17.
 */
public class CC {
    private boolean [] marked;
    private int [] id;
    private int count;
    private Graph G;

    CC(Graph G) {
        this.G = G;
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int i = 0; i < G.V(); i++) {
            if(!marked[i]) {
                //dfs(i);
                //dfs(G, i);
                bfs(i);
                count++;
            }
        }
    }

    public void dfs(Graph G, int v) {
    //public void dfs(int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                //StdOut.println(w);
                dfs(G, w);
            }
        }
    }

    private void bfs(int v) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[v] = true;
        id[v] = count;
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            v = queue.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    id[w] = count;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean connected(int v, int w) {
        if(id(w) == id(v)) return true;
        return false;
    }
    public int count() { return  count; }
    public int id(int v) {return id[v]; }
}
