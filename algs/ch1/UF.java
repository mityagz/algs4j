package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/8/16.
 */
public class UF {
    private int [] id;
    private int count;
    public UF(int n){
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
        return id[p];
    }

    public int qfind(int p){
        while(p != id[p])
            p = id[p];
        return  p;
    }

    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if(pID == qID)
            return;
        for(int i = 0; i < id.length; i++){
            if(id[i] == pID)
                id[i] = qID;
        }
        count--;
    }

    public void qunion(int p, int q){
        int pRoot = qfind(p);
        int qRoot = qfind(q);
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
