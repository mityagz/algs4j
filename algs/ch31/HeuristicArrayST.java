package algs.ch31;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by mitya on 10/30/16.
 */
// 3.1.22
public class HeuristicArrayST<Key, Value> implements STBase<Key, Value> {
    private Key [] keys;
    private Value [] vals;
    private int n;
    public HeuristicArrayST(int capacity) {
        keys = (Key []) (new Comparable[capacity]);
        vals = (Value [])(new Object[capacity]);
    }

    public void resize (int capacity) {
        Key [] tKeys = (Key []) (new Comparable[capacity]);
        Value [] tVals= (Value []) (new Object[capacity]);
        //for(int i = 0; i < keys.length; i++) {
        for(int i = 0; i < n; i++) {
            tKeys[i] = keys[i];
            tVals[i] = vals[i];
        }

        keys = tKeys;
        vals = tVals;
    }

    @Override
    public Value get(Key key) {
        if(key == null) throw new NullPointerException("argument to get() is null");
        for(int i = 0; i < n; i++)
            if(key.equals(keys[i])) {
                forwardShift(i);
                return vals[0];
            }
        return null;
    }

    //
    @Override
    public void put(Key key, Value val) {
        if(key == null) throw new NullPointerException("argument to get() is null");
        if(val == null) {
            delete(key);
            return;
        }

        for(int i = 0; i < n; i++)
            if(key.equals(keys[i])) {
                vals[i] = val;
                forwardShift(i);
                return;
            }
        if(keys.length == n) resize(keys.length * 2);
        keys[n] = key;
        vals[n] = val;
        n++;
    }

    @Override
    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        if(get(key) != null)
            return true;
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        if(size() == 0)
            return true;
        return false;
    }


    @Override
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        for(int i = 0; i < n; i++) {
             if (key.equals(keys[i])) {
                 keys[i] = keys[n - 1];
                 vals[i] = vals[n - 1];
                 n--;
                 if (n > 0 && n == keys.length/4) resize(keys.length/2);
                 return;
             }
        }
    }

    private void exch(int i, int j) {
        Key tKey = keys[i]; Value tVal = vals[i];
        keys[i] = keys[j]; vals[i] = vals[j];
        keys[j] = tKey; vals[j] = tVal;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for(int i = 0; i < n; i++)
            q.enqueue(keys[i]);
        return q;
    }

    private void forwardShift(int i) {
        Key tKey = keys[i]; Value tVal = vals[i];
        for(int j = i; j > 0; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[0] = tKey;
        vals[0] = tVal;
    }
}
