package algs.ch42;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/23/17.
 */
public class ShortestAncestralPath {
    private int v;
    private int w;
    private int min;
    private int result;
    private Digraph G;
    public ShortestAncestralPath(Digraph G, int v, int w)
    {
        this.v = v;
        this.w = w;
        this.G = G;
        DirectedBFS dv = new DirectedBFS(G.reverse(),v);
        DirectedBFS dw = new DirectedBFS(G.reverse(),w);

        LCA lca = new LCA(G, v, w);
        StdOut.println("lca is " + lca.lca());
        min = G.V();

        for(int i : lca.ancestors()) {
            if(dv.dis(i) + dw.dis(i) < min) {
                min = dv.dis(i) + dw.dis(i);
                result = i;
            }
        }
    }
    public int sap()
    {
        return result;
    }
    public static void main(String[] args) {
        Digraph G = new Digraph(new In("tinyDG6.txt"));
        StdOut.println(G);

        ShortestAncestralPath sap = new ShortestAncestralPath(G, 4, 6);
        StdOut.println("sap is " + sap.sap());
    }
}
