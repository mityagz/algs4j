package algs.ch34;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/16/16.
 */
public class SeparateShortChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 3;
    private int n;                                // number of key-value pairs
    private int m;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  //

    SeparateShortChainingHashST() {
        this(INIT_CAPACITY);
    }


    public SeparateShortChainingHashST(int m) {
        this.m = m;
        st = new SequentialSearchST[m];
        for(int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private void resize(int chains) {
        SeparateShortChainingHashST tmp = new SeparateShortChainingHashST<Key, Value>(chains);
        for(int i = 0; i <  m; i++)
            for(Key k : st[i].keys())
                tmp.put(k, st[i].get(k));

        this.m = tmp.m;
        this.n = tmp.n;
        this.st = tmp.st;
    }

    private int hash0(Key key) {
        return ((key.hashCode() & 0x7fffffff) * 11)  % m;
    }

    private int hash1(Key key) {
        return ((key.hashCode() & 0x7fffffff) * 17) % m;
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
        int i0 = hash0(key);
        int i1 = hash1(key);
        Value v0, v1;
        v0 = st[i0].get(key);
        v1 = st[i1].get(key);
        if(v0 != null)
            return v0;
        else return v1;
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        if(n > m / 2) resize(2 * m);
        int i0 = hash0(key);
        int i1 = hash1(key);
        if(!st[i0].contains(key) || !st[i1].contains(key)) n++;
        if(st[i0].size() < st[i1].size()) {
            st[i0].put(key, val);
        } else {
            st[i1].put(key, val);
        }
        StdOut.println("--\nPut " + i0 + " #0 size: " + st[i0].size());
        StdOut.println("Put " + i1 + " #1 size: " + st[i1].size());
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        int i0 = hash0(key);
        int i1 = hash1(key);
        if (st[i0].contains(key)) {
            st[i0].delete(key);
        } else if (st[i1].contains(key)) {
            st[i1].delete(key);
        }
        n--;
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
        SeparateShortChainingHashST<String, Integer> st = new SeparateShortChainingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
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
        // print keys

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
