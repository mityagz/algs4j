package algs.ch41;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/6/17.
 */
public class TestSearch {
    public static void main(String [] args) {
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        Search search = new Search(G, s);
        for(int v = 0; v < G.V(); v++) {
            if(search.marked(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();
        if(search.count() != G.V())
            StdOut.println("НЕ");
        StdOut.println("связанный");
    }
}
