package algs.ch41;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/4/17.
 */
public class DegreeOfSeparation {
    public static void main(String [] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();
        String source = args[2];
        if(!sg.contains(source)) {
            StdOut.println(source + " don't exists in db");
            return;
        }

        int s = sg.index(source);
        BreadFirstPaths bfs = new BreadFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if(sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (int v : bfs.pathTo(t)) {
                        StdOut.println(" " + sg.name(v));
                    }
                } else {
                    StdOut.println("Don't linked");
                }
            } else { StdOut.println("Not in db");}
        }
    }
}
