package algs.ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 5/18/16.
 */
public class ErdosRenyi {

    public static void main(String [] args){
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        StdOut.println("Connected component: " + count(n, m));
    }

    public static int count(int n, int m){
        UF uf = new UF(n);
        for(int i = 0; i < n; i++) {
            int p = StdRandom.uniform(0, n - 1);
            int q = StdRandom.uniform(0, n - 1);
            StdOut.println("p: " + p + " q: " + q);
            if(uf.connected(p, q)){
                continue;
            }
            uf.union(p, q);
        }
        return uf.count();
    }
}
