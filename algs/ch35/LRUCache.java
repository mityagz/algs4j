package algs.ch35;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 1/3/17.
 */
public class LRUCache<Key> {
    private Node first;
    private Node last;
    HashMap<Key, Node> map;
    private class Node {
        Key key;
        Node next;
        Node prev;
        public Node(Key key, Node next, Node prev) {
            this.key = key;
            this.next = next;
            this.prev = prev;
        }
    }
    public LRUCache() {
        map = new HashMap<Key, Node>();
    }

    public void access(Key key) {
        if(key == null) throw new NoSuchElementException();
        if(map.containsKey(key)) {
            Node t = map.get(key);
            if(t == first) return;
            if(t == last) {
                last = t.prev;
                last.next = null;
                t.prev = null;
                t.next = first;
                first = t;
            } else {
                if(t.prev != null && t.prev.next != null) t.prev.next = t.next;
                t.next.prev = t.prev;

                t.prev = null;
                t.next = first;
                first = t;
            }
        } else {
            if(first == null) {
                first = new Node(key, null, null);
                last = first;
                map.put(key, first);
            } else {
                first.prev  = new Node(key, first, null);
                first = first.prev;
                map.put(key, first);
            }
        }
    }

    public Key delete() {
        Node t = null;
        if(last == null)
            return null;
        t = last;

        map.remove(t.key);

        last = t.prev;
        if(t.prev != null && t.prev.next != null) t.prev.next = null;
        Key k = t.key;
        t = null;
        return k;
    }

    public boolean isEmpty() {
        if(first == null)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = new int[n];
        LRUCache<Integer> cache = new LRUCache<Integer>();
        for (int i = 0; i < n; ++i) {
            a[i] = StdRandom.uniform(n);
            cache.access(a[i]);
        }
        StdOut.println(Arrays.toString(a));


        while (!cache.isEmpty()) {
            StdOut.print(cache.delete() + " ");
        }
        StdOut.println(0);

    }
}
