package algs.ch41;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/4/17.
 */
public class DegreesOfSeparationDFS {
    public static void main(String [] args) {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();
        String source = args[2];
        if(!sg.contains(source)) {
            StdOut.println(source + " don't exists in db");
            return;
        }

        int s = sg.index(source);
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if(sg.contains(sink)) {
                int t = sg.index(sink);
                if (dfs.hasPathTo(t)) {
                    for (int v : dfs.PathTo(t)) {
                        StdOut.println(" " + sg.name(v));
                    }
                } else {
                    StdOut.println("Don't linked");
                }
            } else { StdOut.println("Not in db");}
        }
    }
}
