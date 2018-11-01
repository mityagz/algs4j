package algs.ch35;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by mitya on 12/24/16.
 */
public class SET<Key extends Comparable<Key>> {
    private ST<Key, Object> st;
    private Object object;

    public SET() {
        st = new ST<Key, Object>();
        object = new Object();
    }

    public void add(Key key) {
        st.put(key, object);
    }

    public boolean contains(Key key) {
        return st.contains(key);
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public void delete(Key key) {
        st.delete(key);
    }

    public Iterable<Key> keys() {
        return st.keys();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Key k : st.keys()) {
            sb.append(k.toString() + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        int[] a = new int[N];
        for(int i = 0; i < N; ++i) {
            a[i] = i;
        }

        StdRandom.shuffle(a);

        StdOut.println(Arrays.toString(a));
        SET<Integer> set = new SET<Integer>();
        for(int i = 0; i < N; ++i) {
            set.add(a[i]);
        }
        StdOut.println(set.toString());
}
}
