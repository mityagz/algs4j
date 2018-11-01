package algs.ch42;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/16/17.
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle cycleFinder = new DirectedCycle(G);
        if(!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        if(order != null) return true;
        return false;
    }

    public static void main(String [] args) {
        String filename = args[0];
        String separator = args[1];
        SymbolDigraph sg = new SymbolDigraph(filename, separator);

        Topological top = new Topological(sg.G());

        for(int v : top.order)
            StdOut.println(sg.name(v));
    }
}
