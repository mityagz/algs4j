package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/8/16.
 */
public class Ch153c {
    public static void main(String [] args){
        //int [] in = {9, 0, 3, 4, 5, 8, 7, 2, 2, 1, 5, 7, 0, 3, 4, 2};
        int [] in = {4, 3, 3, 8, 6, 5, 9, 4, 2, 1, 8, 9, 5, 0, 7, 2, 6, 1, 1, 0, 6, 7};
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(10);
        int i = 0;
        while(i < in.length){
            if(uf.connected(in[i], in[i + 1])) {
                i += 2;
                continue;
            }
            uf.union(in[i], in[i + 1]);

            uf.printId();
            StdOut.println(in[i] + " " + in[(i + 1)]);
            StdOut.println();
            i += 2;
        }
        uf.printId();
    }
}
