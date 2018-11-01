package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/8/16.
 */
public class QuickUnionUF {
    private int [] id;
    private int count;
    public QuickUnionUF(int n){
        count = n;
        id = new int[n];
        for(int i = 0; i < id.length; i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }


    public int find(int p){
        int s = p;
        while(p != id[p])
            p = id[p];

        // link to root

        while(s != id[s]) {
            id[s] = p;
            s = id[s];
        }

        return  p;
    }

    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot)
            return;
        id[pRoot] = qRoot;
        count--;
    }

    public boolean connected(int p, int q){
        if(find(p) == find(q))
            return true;
        return false;
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
}
