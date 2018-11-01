package algs.ch35;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/31/16.
 */
public class MultiLinearProbingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Key[] keys;      // the keys
    private Value[] vals;    // the values

    public MultiLinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    public MultiLinearProbingHashST(int capacity) {
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
        MultiLinearProbingHashST stmp = new MultiLinearProbingHashST(capacity);
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
        if (key == null || val == null) throw new IllegalArgumentException("argument to put() is null");
        if(n > m / 2) resize(2 * m);

        int i = hash(key);

        while (keys[i] != null) {
            /*
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
            */
            i = (i + 1) % m;
            StdOut.println("Trap delete0");
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

    /*
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;
        StdOut.println("Delete: " + key);
        int i = hash(key);
        while (!keys[i].equals(key))
            i = (i + 1) % m;
            keys[i] = null;
            vals[i] = null;

        i = (i + 1) % m;
        while (keys[i] != null) {
            Key saveKey = keys[i];
            Value saveValue = vals[i];
            n--;
            put(saveKey, saveValue);
             i = (i + 1) % m;
        }
        //if(contains(key))
            //delete(key);
        if(m > INIT_CAPACITY && n <= 2 * m) resize(m / 2);
    }
    */


    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key))
                break;
            i = (i + 1) % m;
        }
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                vals[i] = null;
                i = (i + 1) % m;
                continue;
            }
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            put(keyToRedo, valToRedo);
            i = (i + 1) % m;
        }
        n--;
        if (n > 0 && n == m / 8) resize(m / 2);
    }


    public Iterable<Key> keys() {
        Queue q = new Queue();
        for(int i = 0; i < m; i++) {
            if(keys[i] != null) q.enqueue(keys[i]);
        }
        return q;
    }

    private boolean check() {
        return false;
    }


    public static void main(String[] args) {
        MultiLinearProbingHashST<String, Integer> st = new MultiLinearProbingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        st.delete("A");
        st.delete("E");

        st.put("Y", 999);
        st.put("Y", 777);

        st.delete("Y");

        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
