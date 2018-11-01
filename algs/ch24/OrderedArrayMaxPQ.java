package algs.ch24;

import algs.ch2.Insertion;
import algs.ch23.Quick;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 8/27/16.
 */
public class OrderedArrayMaxPQ<Key extends  Comparable> implements IMaxPQ<Key> {
    private Key [] pq;
    private int n = 0;

    OrderedArrayMaxPQ(int max){
         pq = (Key[]) new Comparable[max];
    }

    @Override
    public void insert(Key key) {
        n++;
        if(n >= pq.length - 1) resize(2 * pq.length);
        int j = n - 1;
        while(j > 0 && (pq[j].compareTo(key) > 0)) {
            pq[j + 1] = pq[j];
            j--;

        }
        pq[j + 1] = key;
    }

    @Override
    public Key max() {
        return pq[n];
    }

    @Override
    public Key delMax() {
        if(n > 0 && n == ((pq.length - 1) / 4)) resize(pq.length / 2);
        return pq[n--];
    }

    @Override
    public boolean isEmpty() {
        if(n == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return n;
    }

    private void resize(int capacity) {
        Key [] t = (Key[]) new Comparable[capacity];
        for(int i = 1; i <= n; i++) {
            t[i] = pq[i];
        }
        pq = t;
        t = null;
    }

    public static void main(String [] args) {
        OrderedArrayMaxPQ<String> p = new OrderedArrayMaxPQ<String>(10);


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
