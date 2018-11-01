package algs.ch25;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 9/19/16.
 */
public class LPT {
    public static void main(String [] args) {
        int m = Integer.parseInt(args[0]);

        int n = StdIn.readInt();
        Job [] j = new Job[n];

        for(int i = 0; i < n; i++) {
            String name = StdIn.readString();
            double time = StdIn.readDouble();
            j[i] = new Job(name, time);
        }

        Arrays.sort(j);

        /*
        for(int i = 1; i < n; i++) {
            StdOut.println(j[i]);
        }
        */


        MinPQ<Processor> pq = new MinPQ<Processor>(m);
        for(int i = 0; i < m; i++) {
            pq.insert(new Processor());
        }

        for(int i = n - 1; i >= 0; i--) {
            Processor min_proc = pq.delMin();
            min_proc.add(j[i]);
            pq.insert(min_proc);
        }

        while (!pq.isEmpty())
            StdOut.println(pq.delMin());
    }
}
