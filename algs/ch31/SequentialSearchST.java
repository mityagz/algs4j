package algs.ch31;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 10/15/16.
 */
public class SequentialSearchST<Key, Value> implements STBase<Key, Value>{
    private Node first;
    private static int n = 0;


    SequentialSearchST() {

    }

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

    public Value get(Key key) {
        if(key == null) throw new NullPointerException("argument to get() is null");
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;
        return null;
    }

    public void put(Key key, Value val) {
        if(key == null) throw new NullPointerException("argument to get() is null");
        if(val == null) {
            delete(key);
            return;
        }


        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key)) {
                x.val = val;
                return;
            }
        first = new Node(key, val, first);
        n++;
    }

    public boolean contains(Key key) {
        if(key != null && get(key) != null)
            return true;
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        if(size() == 0)
            return true;
        return false;
    }

    /*
    public void delete(Key key) {
        // Immediate key remove
        if(key == null) throw new NullPointerException("argument to delete() is null");
        if(key.equals(first.key)) {
            first = first.next;
            n--;
            return;
        }
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.next.key)) {
                x.next = x.next.next;
                n--;
                return;
            }
        }
    }
    */



    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        first = delete(first, key);
    }

    public Node delete(Node x, Key key) {
        if(x == null) return null;
        if(key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }


    /*
    @Override
    public Iterator<Key> iterator() {
        return null;
    }
    */

    public Iterable<Key> keys() {
        Queue<Key> q = new Queue<Key>();
        for(Node x = first; x != null; x = x.next){
            q.enqueue(x.key);
        }
        return q;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        //st.delete("tag");
        st.delete("bed");

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

    /*
    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to delete() is null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
    */

    /*
    public Iterator<Key> keys() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<Key>{

        private Node current = first;
        private int cnt = cntOp;

        @Override
        public boolean hasNext() {
            if(cnt != cntOp){ throw new IllegalArgumentException("Pop or Push op invoke");}
            if(current != null){
                return true;
            }
            return false;
        }

        @Override
        public Key next() {
            if(cnt != cntOp){ throw new IllegalArgumentException("Pop or Push op invoke");}
            Key item = current.item;
            current = current.next;
            return item;
        }

        public void remove(){

        }
    */

    /**
     *  require implement:
     *  ST();
     *  int size();
     *  void delete(Key key);   //Energy
     *  boolean contains(Key key);
     *  boolean isEmpty();
     *  Iterable<Key> keys();
     *
     */
}

