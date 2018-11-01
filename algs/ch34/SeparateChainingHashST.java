package algs.ch34;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;

/**
 * Created by mitya on 12/14/16.
 */
public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;
    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  //

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }


    public SeparateChainingHashST(int m) {
        this.m = m;
        st = new SequentialSearchST[m];
        for(int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private void resize(int chains) {
        SeparateChainingHashST tmp = new SeparateChainingHashST<Key, Value>(chains);
        for(int i = 0; i <  m; i++)
            for(Key k : st[i].keys())
                tmp.put(k, st[i].get(k));

        this.m = tmp.m;
        this.n = tmp.n;
        this.st = tmp.st;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        if(size() == 0) return true;
        return false;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        if(get(key) != null)
            return true;
        return false;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        if(n > m / 2) resize(2 * m);
        int i = hash(key);
        if(!st[i].contains(key)) n++;
        st[i].put(key, val);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);
        if(m > INIT_CAPACITY && n <= 2 * m) resize(m / 2);
    }

    public Iterable<Key> keys() {
        Queue queue = new Queue();
        for(int i = 0; i < m; i++) {
            for(Key k : st[i].keys())
                queue.enqueue(k);
        }
        return queue;
    }

    public static void main(String [] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
