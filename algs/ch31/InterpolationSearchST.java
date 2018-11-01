package algs.ch31;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by mitya on 10/31/16.
 */
public class InterpolationSearchST <Key extends Integer, Value> implements STBase<Key, Value> {
    private Key [] keys;
    private Value [] vals;
    private int n;
    public InterpolationSearchST(int capacity) {
        keys = (Key []) (new Comparable[capacity]);
        vals = (Value [])(new Object[capacity]);
    }

    public void resize (int capacity) {
        Key [] tKeys = (Key []) (new Comparable[capacity]);
        Value [] tVals= (Value []) (new Object[capacity]);
        for(int i = 0; i < keys.length; i++) {
            tKeys[i] = keys[i];
            tVals[i] = vals[i];
        }

        keys = tKeys;
        vals = tVals;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        if(size() == 0)
            return true;
        return false;
    }

    public int rank(Integer key) {
        int lo = keys[0].intValue(), hi = keys[n - 1].intValue();
        while(lo <= hi) {
            Integer ips = (keys[key].intValue() - keys[lo].intValue()) / (keys[hi].intValue() - keys[lo].intValue());
            int c = key.compareTo(keys[ips]);
            if (c < 0) hi = ips - 1;
            else if (c > 0) lo = ips + 1;
            else return ips;
        }
        return lo;
    }

    public int rank2(Key key, int lo, int hi) {
        if(hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int c = key.compareTo(keys[mid]);
        if(c < 0) rank2(key, lo, mid - 1);
        else if(c > 0) rank2(key, mid + 1, hi);
        else return mid;
        return 0;
    }

    public Value get(Key key) {
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < n && key.compareTo(keys[i]) == 0) return vals[i];
        else return null;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if(i < n && key.compareTo(keys[i]) == 0) {
            vals[i] = val;
            return;
        }
        // code for array size change
        if(keys.length == n) resize(keys.length * 2);
        for(int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        int i = rank(key);
        if(i == n || key.compareTo(key) != 0)
            return;

        for(int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }

        n--;
        keys[n] = null;
        vals[n] = null;
        // code for array size change
        if(n > 0 && n == keys.length / 4) resize(keys.length / 2);
    }

    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        if(get(key) != null)
            return true;
        return false;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[n - 1];
    }

    public Key floor(Key key) {
        if (key == null) throw new NullPointerException("argument to floor() is null");
        int i = rank(key);
        if(i < n && keys[i].compareTo(key) == 0)
            return keys[i];
        if(i - 1 >= 0)
            return keys[i - 1];
        else return null;
    }

    public Key ceiling(Key key) {
        if (key == null) throw new NullPointerException("argument to ceiling() is null");
        int i = rank(key);
        if (i == n) return null;
        else
        return keys[i];
    }

    public Key select(int k) {
        if (k < 0 || k >= n) return null;
        return keys[k];
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
    }

    public int size(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("first argument to size() is null");
        if (hi == null) throw new NullPointerException("second argument to size() is null");
        if(lo.compareTo(hi) > 0) return 0;
        int i0 = rank(lo), i1 = rank(hi);
        if(contains(hi)) return i1 - i0 + 1;
        else
        return  i1 - i0;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("first argument to keys() is null");
        if (hi == null) throw new NullPointerException("second argument to keys() is null");
        Queue<Key> q = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return q;
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if(contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private boolean check() {
        return isSorted() && rankCheck();
    }

    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }

    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }


    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(10);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
