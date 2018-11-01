package algs.ch42;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/18/17.
 */
public class KosarajuSCC {
    private boolean marked[];
    private int id[];
    private int count;

    KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
            for(int s : order.reversePost())
                if(!marked[s]) {
                    dfs(G, s);
                    count++;
                }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }

    public boolean stronglyConnected(int w, int v) {
        if(id[w] == id[v]) return true;
        return false;
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String [] args) {
        String f = args[0];
        Digraph dag = new Digraph(new In(f));
        KosarajuSCC scc = new KosarajuSCC(dag);
        StdOut.println(scc.count() + " component");
        Queue [] q = new Queue[scc.count];
        for(int v = 0; v < dag.V(); v++) {
            if(q[scc.id(v)] == null) q[scc.id(v)] = new Queue();
            q[scc.id(v)].enqueue(v);
        }

        for(int i = 0; i < q.length; i++)
            StdOut.println(q[i].toString());
    }
}
