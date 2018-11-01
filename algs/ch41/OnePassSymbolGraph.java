package algs.ch41;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/5/17.
 */
public class OnePassSymbolGraph {
    private ST<String, Bag<String>> st;  // string -> index
    private String[] keys;           // index  -> string

    public OnePassSymbolGraph(String filename, String delimiter) {
        In in = new In(filename);
        st = new ST<String, Bag<String>>();
        while (!in.isEmpty()) {
            String [] s = in.readLine().split(delimiter);
            for (int i = 0; i < s.length; i++) {
                put(s[0], s[i]);
                put(s[i], s[0]);
            }
        }
    }

    private void put(String s, String ss) {
        if(!st.contains(s))
            st.put(s, new Bag<String>());
        if(!s.equals(ss))
            st.get(s).add(ss);
    }

    public Iterable<String> Vs() {
        return st.keys();
    }

     public void addEdge(String s, String ss) {
         put(s, ss);
         put(ss, s);
     }

    public Iterable<String> adj(String s) {
        return st.get(s);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String v : Vs()) {
            sb.append(v + " : " + "\n");
            for (String w : adj(v))
                sb.append("    " + w + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OnePassSymbolGraph g = new OnePassSymbolGraph("/home/mitya/wrk/alg/algs4/data/algs4-data/routes.txt", " ");
        StdOut.println(g.toString());
    }
}
