package algs.ch24;

import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 8/28/16.
 */
public class OrderedLinkedListMaxPQ<Key extends  Comparable> implements IMaxPQ<Key> {
    LinkedList<Key> pq;
    private int n = 0;

    OrderedLinkedListMaxPQ() {
        pq = new LinkedList<Key>();
    }

    @Override
    public void insert(Key key) {
        n++;
        Key prev = null;
        try {
            prev = pq.getFirst();
        } catch (NoSuchElementException e) {
            pq.addFirst(key);
            return;
        }
        if (key.compareTo(prev) < 0 || key.compareTo(prev) == 0) {
            pq.addFirst(key);
            return;
        }
        for (Key curr : pq) {
            if (key.compareTo(curr) == 0 || key.compareTo(prev) > 0 && key.compareTo(curr) < 0) {
                pq.add(pq.indexOf(curr), key);
                return;
            }
        }
        pq.addLast(key);
    }

    @Override
    public Key max() {
        return pq.getLast();
    }

    @Override
    public Key delMax() {
        n--;
        return pq.removeLast();
    }

    @Override
    public boolean isEmpty() {
        if (n == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    public static void main(String[] args) {
        OrderedLinkedListMaxPQ<Integer> p = new OrderedLinkedListMaxPQ<Integer>();

        /*
        p.insert("Z");
        p.insert("E");
        p.insert("A");
        p.insert("R");
        p.insert("A");
        p.insert("S");
        p.insert("W");
        p.insert("I");

        p.delMax();
        p.insert("Z");
        */

        p.insert(1);
        p.insert(8);
        p.insert(7);
        p.insert(4);
        p.insert(9);
        p.insert(13);
        p.insert(11);
        p.insert(127);


        while (!p.isEmpty()) {
            StdOut.println(p.delMax());
        }
    }
}
