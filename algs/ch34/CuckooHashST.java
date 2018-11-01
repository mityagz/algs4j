package algs.ch34;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/16/16.
 */
public class CuckooHashST<Key, Value> {
    private int m0;
    private int m1;
    private int n0;
    private int n1;
    private Key [] keys0;
    private Key [] keys1;
    private Value [] vals0;
    private Value [] vals1;
    private int set;

    CuckooHashST(int m) {
        keys0 = (Key []) new Object[m];
        keys1 = (Key []) new Object[m];
        vals0 = (Value []) new Object[m];
        vals1 = (Value []) new Object[m];
        m0 = m;
        m1 = m;
        set = 0;
    }

    private int hash0(Key key) {
        return ((key.hashCode() * 31) & 0x7fffffff) % m0;
    }

    private int hash1(Key key) {
        return ((key.hashCode() * 31) & 0x7fffffff) % m1;
    }

    public int size() {
        return n0 + n1;
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

    private void resize(int capacity) {
        CuckooHashST cst = new CuckooHashST(capacity);

        for(int i = 0; i <  m0; i++)
            if(keys0[i] != null)
                cst.put(keys0[i], vals0[i]);

        for(int i = 0; i <  m1; i++)
            if(keys1[i] != null)
                cst.put(keys1[i], vals1[i]);

        this.keys0 = (Key [])cst.keys0;
        this.keys1 = (Key [])cst.keys1;
        this.vals0 = (Value [])cst.vals0;
        this.vals1 = (Value [])cst.vals1;

        this.m0 = cst.m0;
        this.m1 = cst.m1;
        this.n0 = cst.n0;
        this.n1 = cst.n1;
        this.set = cst.set;
        cst = null;
    }

    public void put(Key key, Value val) {
        Key nextKey;
        Value nexValue;
        while (true) {
            if(set == 0) {
                int i0 = hash0(key);
                nextKey = keys0[i0];
                nexValue = vals0[i0];
                keys0[i0] = key;
                vals0[i0] = val;
                set = 1;
                if(nextKey != null && nextKey.equals(key))
                    return;
                n0++;
                if(2 * n0 > m0) resize(2 * m0);
                if(nextKey == null)
                    return;
            } else {
                int i1 = hash1(key);
                nextKey = keys1[i1];
                nexValue = vals1[i1];
                keys1[i1] = key;
                vals1[i1] = val;
                set = 0;
                if(nextKey != null && nextKey.equals(key))
                    return;
                n1++;
                if(2 * n1 > m1) resize(2 * m1);
                if(nextKey == null)
                    return;
            }
            key = nextKey;
            val = nexValue;
        }
    }

    public Value get(Key key) {
        int i0 = hash0(key);
        int i1 = hash1(key);
        if(keys0[i0] != null && keys0[i0].equals(key))
            return vals0[i0];
        if(keys1[i1] != null && keys1[i1].equals(key))
            return vals1[i1];
        return null;
    }

    public void delete(Key key) {
        int i0 = hash0(key);
        int i1 = hash1(key);
        if(keys0[i0] != null && keys0[i0].equals(key)) {
            StdOut.println("Delete0: " + keys0[i0]);
            keys0[i0] = null;
            vals0[i0] = null;
        }

        if(keys1[i1] != null && keys1[i1].equals(key)) {
            StdOut.println("Delete1: " + keys1[i1]);
            keys1[i1] = null;
            vals1[i1] = null;
        }

    }

    public Iterable<Key> keys() {
        Queue q = new Queue();
        for(int i = 0; i < m0; i++) {
            if (keys0[i] != null)
                q.enqueue(keys0[i]);
            if(keys1[i] != null)
                q.enqueue(keys1[i]);
        }
        return q;
    }

    public static void main(String[] args) {
        CuckooHashST<String, Integer> st = new CuckooHashST<String, Integer>(4);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        //st.delete("A");
        //st.delete("E");
        //st.put("Y", 999);

        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
