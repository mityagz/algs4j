package algs.ch34;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/15/16.
 */
public class LazyDelLinearProbingHashST<Key, Value> {
     private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values

    public LazyDelLinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public LazyDelLinearProbingHashST(int capacity) {
        this.m = capacity;
        keys = (Key []) new Object[capacity];
        vals = (Value []) new Object[capacity];
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
        if(get(key) != null) return true;
        return false;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    private void resize(int capacity) {
        LazyDelLinearProbingHashST stmp = new LazyDelLinearProbingHashST(capacity);
        for(int i = 0; i <  m; i++)
            if(keys[i] != null)
                stmp.put(keys[i], vals[i]);

        this.m = stmp.m;
        this.n = stmp.n;
        this.keys = (Key [])stmp.keys;
        this.vals = (Value [])stmp.vals;
        stmp = null;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("argument to put() is null");
        if(n > m / 2) resize(2 * m);

        int i = hash(key);

        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
            i = (i + 1) % m;
        }

        n++;
        keys[i] = key;
        vals[i] = val;
    }

    public Value get(Key key) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) return vals[i];
            else i = (i + 1) % m;
        }
        return null;
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;
        StdOut.println("Delete: " + key);
        int i = hash(key);
        while (keys[i] != null) {
            if(keys[i].equals(key))
                vals[i] = null;
            i = (i + 1) % m;
        }
        n--;
        if(m > 0 && n <= m / 8) resize(m / 2);
    }

    public Iterable<Key> keys() {
        Queue q = new Queue();
        for(int i = 0; i < m; i++) {
            if(keys[i] != null && vals[i] != null) q.enqueue(keys[i]);
        }
        return q;
    }

    private boolean check() {
        return false;
    }

    public int sizeST() {
        return m;
    }


    public static void main(String[] args) {
        LazyDelLinearProbingHashST<String, Integer> st = new LazyDelLinearProbingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
            StdOut.println("STSize: " + st.sizeST() + " Size: " + st.size());
        }

        st.put("Z", 999);
        st.put("X", 998);
        st.put("W", 997);
        st.put("Q", 996);
        st.put("V", 995);

        st.delete("A");
        st.delete("E");
        st.put("Y", 999);
        st.delete("C");
        st.delete("H");
        st.delete("L");
        st.delete("M");
        st.delete("P");
        st.delete("R");
        st.delete("S");
        st.delete("Q");
        st.delete("V");
        //st.delete("");

        StdOut.println("STSize: " + st.sizeST() + " Size: " + st.size());
        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
