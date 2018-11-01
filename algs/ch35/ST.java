package algs.ch35;

import algs.ch33.RedBlackBST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * Created by mitya on 12/18/16.
 */
public class ST<Key extends Comparable<Key>, Value> extends RedBlackBST<Key, Value>{
    ST() {
        super();
    }

    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }


        st.put("A", 10);
        st.put("B", 11);
        st.put("C", 12);

        StdOut.println(st.min());
        StdOut.println(st.max());

        st.deleteMax();

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        StdOut.println();
    }
}
