package algs.ch34;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/14/16.
 */
public class SeparateChainingLiteHashST<Key, Value> {
    private int n;
    private int m;
    private Node[] st;

    private static class Node {
        Object key;
        Object val;
        Node next;
        int numInsertPoint = 0;

        public Node(Object key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SeparateChainingLiteHashST() {
        this(997);
    }

    public SeparateChainingLiteHashST(int m) {
        this.m = m;
        st = new Node[m];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int size() {
        return n;
    }

    public boolean contains(Key key) {
       if(get(key) != null)
           return true;
        return false;
    }

    public Value get(Key key) {
        if(key == null) throw new NullPointerException("argument to get() is null");
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next)
            if(key.equals(x.key))
                return (Value)x.val;
        return null;
    }

    public void put(Key key, Value val) {
        if(key == null || val == null) throw new NullPointerException("argument to put() is null");
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }

            if(x.next == null) {
                x.numInsertPoint = n;
                n++;
                x.next = new Node(key, val, null);
                return;
            }
        }

        st[i] = new Node(key, val, null);
        st[i].numInsertPoint = n;
        n++;

        /* another solutions insert to head, fastest.
            for (Node x = st[i]; x != null; x = x.next) {
                if (key.equals(x.key)) {
                    x.val = val;
                    return;
                }
            }
                n++;
                st[i] = new Node(key, val, st[i]);
         */
    }

    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        int i = hash(key);
        Node prev = null;
        for(Node x = st[i]; x != null; prev = x, x = x.next) {
            if (key.equals(x.key)) {
                StdOut.println("Delete: " + x.key);
                if(prev != null && prev.next != null)
                    prev.next = x.next;
                else st[i] = x.next;
            }
        }
    }

    public void deleteInsPoint(int p) {
        for(int i = 0; i < m; i++)
            for(Node x = st[i]; x != null; x = x.next) {
                if(x.numInsertPoint > p)
                    delete((Key)x.key);
            }
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for(int i = 0; i < m; i++)
            for(Node x = st[i]; x != null; x = x.next) {
                q.enqueue((Key)x.key);
            }
        return q;
    }

    public static void main(String[] args) {
        SeparateChainingLiteHashST<String, Integer> st = new SeparateChainingLiteHashST<String, Integer>(97);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        st.delete("A");
        st.delete("S");

        st.deleteInsPoint(5);

        // print keys
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}
