package algs.ch35;

import algs.ch34.SeparateChainingHashST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by mitya on 12/24/16.
 */
public class HashSET<Key> {
    private SeparateChainingHashST st;
    private Object object;
    HashSET() {
        st = new SeparateChainingHashST<Key, Objects>();
        object = new Object();
    }

    public int size() {
        return st.size();
    }

    public void add(Key key) {
        st.put(key, object);
    }

    public void delete(Key key) {
        st.delete(key);
    }

    public boolean contains(Key key) {
        return st.contains(key);
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Object k : st.keys()) {
            Key key = (Key) k;
            sb.append(key + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = i;
        }
        StdRandom.shuffle(a);


        StdOut.println(Arrays.toString(a));
        HashSET<Integer> set = new HashSET<Integer>();
        for (int i = 0; i < n; ++i) {
            set.add(a[i]);
        }
        StdOut.println(set.toString());
    }
}
