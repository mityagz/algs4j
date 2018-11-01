package algs.ch41;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/6/17.
 */
public class WeightQuickFindUF {
    private int [] id;
    private int [] sz;
    private int count;
    private int[] weight;

    WeightQuickFindUF(int n) {
        id = new int [n];
        sz = new int [n];
        weight = new int[n];

        count = n;
        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = i;
            weight[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        if(find(p) == find(q))
            return true;
        return false;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;
        if(sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
            weight[rootQ] += weight[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
            weight[rootP] += weight[rootQ];
        }
        count--;
    }

    public int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    public int count() {
        return count;
    }

    public int count2(int s) { return weight[find(s)]; }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightQuickFindUF uf = new WeightQuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}
