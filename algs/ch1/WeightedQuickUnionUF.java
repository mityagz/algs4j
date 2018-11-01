package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/8/16.
 */
public class WeightedQuickUnionUF {
    private int [] id;
    private int [] sz;
    private int count;
    private int [] cost;
    private int [] total;
    //private int cnt;

    public WeightedQuickUnionUF(int n){
        count = n;
        id = new int[n];
        for(int i = 0; i < id.length; i++) id[i] = i;
        sz = new int [n];
        for(int i = 0; i < sz.length; i++) sz[i] = 1;
        sz = new int [n];
        cost = new int [2*n];
        total = new int [2*n];
        for(int i = 0; i < cost.length; i++){
            cost[i] = 0;
            total[i] = 0;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        while(p != id[p]){
            p = id[p];
            cost[Cl1516c.cnt]++;
        }
        return p;
    }

    public boolean connected(int p, int q){
        if(find(p) == find(q))
            return true;
        return false;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) return;

        if(sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot; sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot; sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    public void printId(){
        for(int i = 0; i < id.length; i++) {
            StdOut.print(i + " ");
        }

        StdOut.println();

        for(int i = 0; i < id.length; i++) {
            StdOut.print(id[i] + " ");
        }
    }

    public int [] getCost(){
        return cost;
    }
}
