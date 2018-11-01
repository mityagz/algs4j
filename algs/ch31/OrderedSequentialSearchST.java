package algs.ch31;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 10/23/16.
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Node first;
    private static int n = 0;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    // number of keys less than key
    @Override
    public int rank(Key key) {
        int i = 0;
        if(n == 0) return 0;
        for(Node x = first; x != null && x.key.compareTo(key) < 0; x = x.next)
            i++;
        return i;
    }

    // number of keys less than key
    @Override
    public int rank2(Key key, int lo, int hi) {
        return 0;
    }


    @Override
    public Key min() {
        if(first != null) {
            return first.key;
        }
        return null;
    }


    @Override
    public Key max() {
        Node prev = null;
        Node x = null;
        for(x = first; x != null; prev = x, x = x.next);
            return prev.key;
    }

    //largest key less than or equal to key, pol
    @Override
    public Key floor(Key key) {
        return null;
    }

    //  smallest key greater than or equal to key
    @Override
    public Key ceiling(Key key) {
        Node x = null, prev = null;
        for(x = first; x != null && x.key.compareTo(key) < 0; prev = x, x = x.next);
        if(x != null) {
            return x.key;
        } else {
            return null;
        }
    }

    // key of rank k
    @Override
    public Key select(int k) {
        if(n == 0 || k > n) return null;
        int i = 0;
        for (Node x = first; x != null && i != k; x = x.next, i++)
            return x.key;
        return null;
    }


    @Override
    public void deleteMin() {
        if(first == null) {
            return;
        } else {
            first = first.next;
            n--;
            return;
        }
    }


    @Override
    public void deleteMax() {
        Node x = first;
        Node prev = null;
        if(first == null) {
            return;
        } else {
            //for(x = first; x != null; prev = x, x = x.next);
            for(int i = 1; i < n - 1; i++) {
                x = x.next;
            }
            x.next = null;
            n--;
        }
    }


    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    //
    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }


    @Override
    public Value get(Key key) {
        Node x = null;
        if(key == null) throw new NullPointerException("argument to get() is null");
        for(x = first; x != null && x.key.compareTo(key) < 0; x = x.next);

            if(x != null && x.key.compareTo(key) == 0)
                return x.val;

        return null;
    }


    @Override
    public void put(Key key, Value val) {
        Node x = null;
        Node prev = null;
        if(key == null) throw new NullPointerException("argument to put() is null");
        for(x = first; x != null && x.key.compareTo(key) < 0; prev = x, x = x.next);

        if(n == 0 || x == first) {
            first = new Node(key, val, first);
        } else if(x == null || x.key.compareTo(key) > 0) {
            prev.next = new Node(key, val, prev.next);
        } else {
            x.val = val;
            return;
        }
        n++;
    }


    @Override
    public boolean contains(Key key) {
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
        if(first == null)
            return true;
        return false;
    }


    @Override
    public void delete(Key key) {
        Node x = null;
        Node prev = null;
        if(key == null) throw new NullPointerException("argument to put() is null");
        for(x = first; x != null && x.key.compareTo(key) < 0; prev = x, x = x.next);

        if(x != null && x.key.compareTo(key) == 0) {
            prev.next = x.next;
            x = null;
            n--;
            return;
        }
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            q.enqueue(x.key);
        return q;
    }
}
