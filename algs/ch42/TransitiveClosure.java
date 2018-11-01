package algs.ch42;

/**
 * Created by mitya on 2/18/17.
 */
public class TransitiveClosure {
    private DirectedDFS [] all;

    TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for(int v = 0; v < G.V(); v++)
            all[v] = new DirectedDFS(G, v);
    }

    public boolean reachable(int v, int w) {
        if(all[v].marked(v)) return true;
        return false;
    }
}
