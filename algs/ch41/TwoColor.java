package algs.ch41;

/**
 * Created by mitya on 1/27/17.
 */
public class TwoColor {
    private boolean[] marked;
    private boolean isTwoColorable = true;
    private boolean[] color;
    private Graph G;

    public TwoColor(Graph G) {
        this.G = G;
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
                dfs(0);

    }

    private void dfs(int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                color[w] = !color[v];
                dfs(w);
            } else if(color[w] == color[v]) {
                    isTwoColorable = false;
            }
        }
    }

    public boolean isTwoColorable() {
        return isTwoColorable;
    }
}
