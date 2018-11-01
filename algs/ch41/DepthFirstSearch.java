package algs.ch41;

/**
 * Created by mitya on 1/16/17.
 */
public class DepthFirstSearch {
    private boolean marked [];
    private int count;
    private Graph G;
    private int edgeTo[];
    private int s;


    DepthFirstSearch(Graph G, int s) {
        this.G = G;
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(s);
    }

    /*
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    */

    private void dfs(int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v))
            if(!marked(w)) {
                edgeTo[w] = v;
                dfs(w);
            }
    }


    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v))
            if(!marked(w)) {
                edgeTo[w] = v;
                dfs(G, w);
            }
    }

    public boolean marked(int w) { return  marked[w]; }

    public int count() { return count;}
}
