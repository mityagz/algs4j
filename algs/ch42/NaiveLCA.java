package algs.ch42;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 2/25/17.
 */
public class NaiveLCA {
    private int v;
    private int w;
    private int min;
    private int result;
    private Digraph G;
    BreadthFirstDirectedPaths dp;
    private Stack<Integer> rpv;
    private Stack<Integer> rpw;
    private ST<Integer, Integer> stw;

    public NaiveLCA(Digraph G, int s,  int v, int w) {
        this.v = v;
        this.w = w;
        this.G = G;
        Topological topological = new Topological(G);

        //if(!topological.isDAG()) return;
        //for(int s : topological.order()) {
            dp = new BreadthFirstDirectedPaths(G, s);
            //break;
        //}
    }

    public int lca() {
        if((dp != null) && (dp.hasPathTo(v) && dp.hasPathTo(w))) {
            rpv = new Stack<Integer>();
            rpw = new Stack<Integer>();
            stw = new ST<Integer, Integer>();
            Iterable<Integer> pv = dp.pathTo(v);
            Iterable<Integer> pw = dp.pathTo(w);

            for(int pvv : pv)
                rpv.push(pvv);

            for(int pww : pw) {
                rpw.push(pww);
                stw.put(pww, pww);
            }

            for(int r : rpv){
                if(stw.contains(r))
                    return r;
                /*
                StdOut.println("r is: " + r);
                StdOut.println("stw(r): " + stw.contains(r));
                */
            }
            return -1;
        } else {
            StdOut.println("dp is null");
            return -1;
        }
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/tinyDG.txt"));
        StdOut.println(G);

        NaiveLCA nLca = new NaiveLCA(G, 8, 6, 9);
        StdOut.println("lca vertex is " + nLca.lca());
    }
}
