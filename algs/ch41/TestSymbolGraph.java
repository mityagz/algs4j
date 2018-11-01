package algs.ch41;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 1/28/17.
 */
public class TestSymbolGraph {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph("/home/mitya/wrk/alg/algs4/data/algs4-data/movies.txt", "/");
        CC cc = new CC(sg.G());
        StdOut.println(cc.count());
        String name = "Bacon, Kevin";
        if(!sg.contains(name))
            return;

        for(int w : sg.G().adj(sg.index(name))) {
            StdOut.println(sg.name(w));
        }


        int [] comNum = new int[cc.count()];
        for(int v = 0; v < sg.G().V(); v++) {
            comNum[cc.id(v)]++;
        }


        StdOut.println(Arrays.toString(comNum));
        StdOut.println(name);
        StdOut.println(sg.index(name));
        StdOut.println(cc.id(sg.index(name)));
        StdOut.println(comNum[cc.id(sg.index(name))]);
    }
}
