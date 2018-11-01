package algs.ch41;

/**
 * Created by mitya on 1/26/17.
 */
public class Cycle {
    private boolean[] marked;
    private boolean hasCycle;
    private Graph G;

    public Cycle(Graph G) {
        this.G = G;
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); i++) {
            if(!marked[i])
                dfs(i, i);
        }
    }

    private void dfs(int v, int f) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(w, v);
            } else {
                if(w != f)
                    hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
