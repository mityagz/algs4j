package algs.ch24;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 8/28/16.
 */
public class UnorderedLinkedListMaxPQ<Key extends  Comparable> implements IMaxPQ<Key> {
    LinkedList<Key> pq;
    private int n = 0;


    UnorderedLinkedListMaxPQ() {
        pq = new LinkedList<Key>();
    }


    @Override
    public void insert(Key key) {
        n++;
       pq.addLast(key);
    }

    @Override
    public Key max() {
        Key max = pq.getFirst();
        for(Key c : pq)
            if(c.compareTo(max) > 0)
                max = c;
        return max;
    }

    @Override
    public Key delMax() {
        Key max = max();
        pq.remove(max);
        n--;
        return max;
    }

    @Override
    public boolean isEmpty() {
        if(n == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public static void main(String [] args) {
        UnorderedLinkedListMaxPQ<String> p = new UnorderedLinkedListMaxPQ<String>();


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
        /*
        p.insert(1);
        p.insert(8);
        p.insert(7);
        p.insert(4);
        p.insert(9);
        p.insert(13);
        p.insert(11);
        p.insert(127);
        */

        while (!p.isEmpty()) {
             StdOut.println(p.delMax());
        }
    }
}
