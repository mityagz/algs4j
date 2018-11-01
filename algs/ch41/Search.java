package algs.ch41;

/**
 * Created by mitya on 1/6/17.
 */
public class Search {
    private Graph G;
    private int s;
    private WeightQuickFindUF uf;

    Search(Graph G, int s) {
        this.G = G;
        this.s = s;
        uf = new WeightQuickFindUF(G.V());
        for(int v = 0; v < G.V(); v++) {
            for(Integer w : G.adj(v)) {
                uf.union(v, w);
            }
        }
    }

    public boolean marked(int v) {
        if(uf.connected(s, v))
            return true;
        return false;
    }

    public int count() {
        return uf.count2(s);
    }

}
