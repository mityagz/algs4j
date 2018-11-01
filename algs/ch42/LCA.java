package algs.ch42;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-27
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 * https://github.com/dogeyes/Algorithm/blob/master/chapter4/s4_2/src/LCA.java
 */

public class LCA {
    private Digraph G;
    private int[] height;
    private Queue<Integer> ancestors;
    private Topological topological;
    private int v, w;
    private int result;

    public LCA(Digraph G, int v, int w) {
        this.v = v;
        this.w = w;
        this.G = G;
        height = new int[G.V()];
        for(int i =0 ; i < G.V(); ++i)
            height[i] = G.V();
        topological = new Topological(G);
        count();
    }

    public int lca() {
        return result;
    }

    private void count() {
        ancestors = new Queue<Integer>();
        for(int s: topological.order()) {
            height[s] = 0;
            int state = dfs(s, v, w);
            break;
        }

        int max = 0;
        result = 0;
        for(int s: ancestors) {
            if(height[s] > max) {
                max = height[s];
                result = s;
            }
        }
    }

    private int dfs(int s, int v, int w) {
        if(s == v)
            return 1;
        if(s == w)
            return 2;
        boolean flag1 = false;
        boolean flag2 = false;
        for(int i : G.adj(s)) {
            if(height[s] + 1 < height[i])
                height[i] = height[s] + 1;
            int state = dfs(i, v, w);
            if(state == 1)
                flag1 = true;
            if(state == 2)
                flag2 = true;
            if(state == 3) {
                flag1 = true;
                flag2 = true;
            }
        }
        if(flag1 && flag2) {
            ancestors.enqueue(s);
            return 3;
        }
        else if(flag1)
            return 1;
        else if(flag2)
            return 2;
        else
            return 0;
    }
    public Iterable<Integer> ancestors() {
        return ancestors;
    }

    public static void main(String[] args) {
        //Digraph G = new Digraph(new In("tinyDG4.txt"));
        Digraph G = new Digraph(new In("/home/mitya/wrk/alg/algs4/data/algs4-data/tinyDG.txt"));
        StdOut.println(G);
        LCA lca = new LCA(G, 9, 10);

        StdOut.print(lca.lca());
        StdOut.println();
        for (int i : lca.ancestors())
            StdOut.print(i + " ");
        StdOut.println();
    }
}
