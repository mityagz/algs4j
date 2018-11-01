package algs.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/15/16.
 */
public class Cl1516c {
    public static int cnt = 0;
    public static void main(String [] args) {
        int n = StdIn.readInt();

        int [] cost;
        int [] total = new int[2*n];
        for(int i = 0; i < n; i++){
             total[i] = 0;
        }
        WeightedQuickUnionUF quf = new WeightedQuickUnionUF(n);
        //QuickFindUF qff = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(quf.connected(p, q)){
                cnt++;
                continue;
            }
            quf.union(p, q); cnt++;
            StdOut.println(p + " " + q);
        }
        StdOut.println(quf.count() + "компонентов");
        cost = quf.getCost();

        for (int i = 1; i <= n; i++){
                 total [i] = total[i - 1] +  cost[i];
        }


        for(int i = 0; i < n; i++){
            StdOut.println("cost[" + i + "] = " + cost[i] + " : total[" + i + "] = " + total[i]);
        }
    }
}
