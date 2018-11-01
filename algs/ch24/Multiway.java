package algs.ch24;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 8/20/16.
 */
public class Multiway {


    public static void merge(In [] streams) {
        int n = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(50);

        for (int i = 0; i < n; i++)
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());


        while (!pq.isEmpty()) {
            StdOut.println(pq.min());
            int i = pq.delMin();
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }

        }

    }


    public static void main(String [] args) {
        int n = args.length;
        StdOut.println(n);
        In [] streams = new In[n];
        for(int i = 0; i < n; i++)
            streams[i] = new In(args[i]);
        merge(streams);
    }
}
