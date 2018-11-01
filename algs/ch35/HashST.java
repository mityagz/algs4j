package algs.ch35;

import algs.ch34.LinearProbingHashST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/18/16.
 */
public class HashST<Key, Value> extends LinearProbingHashST<Key, Value> {
    HashST() {
        super();
    }

    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        st.delete("A");
        st.delete("E");
        st.put("Y", 999);

        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
