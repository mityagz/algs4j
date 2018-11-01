package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/14/16.
 */
public class WHQuickUnionUF {
    private int [] id;
    private int [] sz;
    private int [] height;
    private int count;

    public WHQuickUnionUF(int n){
        count = n;
        id = new int[n];
        for(int i = 0; i < id.length; i++) id[i] = i;
        sz = new int [n];
        for(int i = 0; i < sz.length; i++) sz[i] = 1;
        height = new int[n];
        for(int i = 0; i < height.length; i++) height[i] = 0;
    }

    public int count(){
        return count;
    }

    public int find(int p){
        int h = 0;
        while(p != id[p]){
            p = id[p];
            h++;
        }
        if(h > height[p]){
            height[p] = h;
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

        /*
        if(sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot; sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot; sz[pRoot] += sz[qRoot];
        }
        */
        if(height[pRoot] < height[qRoot]){
            id[pRoot] = qRoot; height[qRoot] += height[pRoot];
        }else{
            if(height[pRoot]== 0 && height[qRoot] == 0){
                height[pRoot] = 1;
                //height[qRoot] = 1;
            }
            id[qRoot] = pRoot; height[pRoot] += height[qRoot];
        }
        count--;
    }

    public int getHeight(int p){
        return height[p];
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

    public void printH(){
        for(int i = 0; i < height.length; i++) {
            StdOut.print(i + " ");
        }

        StdOut.println();

        for(int i = 0; i < height.length; i++) {
            StdOut.print(height[i] + " ");
        }
    }
}
