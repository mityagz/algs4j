package algs.ch35;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.TreeMap;

/**
 * Created by mitya on 1/2/17.
 */
public class InvertedConcordance {
    public static void main(String[] args) {

        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        int i = StdIn.readInt();
        while (i != 0) {
            String s = StdIn.readString();
            map.put(i, s);
            i = StdIn.readInt();
        }


        for(Integer ii: map.keySet())
            StdOut.println(ii + " " + map.get(ii));
    }
}
