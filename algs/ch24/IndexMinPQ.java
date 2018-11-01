package algs.ch24;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 8/20/16.
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
    private int n;
    private int pq[];
    private int qp[];
    private Key [] keys;

    public IndexMinPQ(int maxN) {
        keys = (Key [])new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for(int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

    public boolean isEmpty() {
        if(n == 0)
            return true;
        return false;
    }

    public boolean contains(int k) {
        if(qp[k] != -1)
            return true;
        return false;

    }

    public void insert(int k, Key key) {
        // resize
        if(n >= pq.length - 1 || k >= qp.length) resize(2 * pq.length);
        //StdOut.println("k:key " + k + ":" + key);
        n++;
        pq[n] = k;
        keys[k] = key;
        qp[k] = n;
        swim(n);
        // debug purpose
        for(int i = 1; i < pq.length; i++) {
            StdOut.print(pq[i]);
        }
        StdOut.println();
    }

    public Key min() {
        return keys[pq[1]];
    }

    public int delMin() {
        int indexMin = pq[1];
        exch(1, n--);
        sink(1);
        qp[pq[n + 1]] = -1;
        keys[pq[n + 1]] = null;
        // resize
        // if(n > 0 && n == ((pq.length - 1) / 4) && pq[n] < qp.length / 4) resize(pq.length / 2);
        return indexMin;
    }

    public int minIndex() {
        return pq[1];
    }

    public void delete(int k) {
        StdOut.println("del: " + keys[k]);
        // debug purpose
        StdOut.print("pq: ");
        for(int i = 1; i < pq.length; i++) {
            StdOut.print(pq[i]);
        }
        StdOut.print();
        //

        exch(qp[k], n--);
        swim(qp[k]);
        sink(qp[k]);
        keys[pq[n + 1]] = null;
        qp[pq[n + 1]] = -1;
        // resize
    }

    public void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    public int size() {
        return  n;
    }


    private void exch(int i, int j) {

        /*
        Key t = keys[pq[i]];
        keys[pq[i]] = keys[pq[j]];
        keys[pq[j]] = t;
        */

        int t = pq[i]; pq[i] = pq[j]; pq[j] = t;
        qp[pq[i]] = i;
        qp[pq[j]] =j;

        // pq[n] = k;  qp[k] = n; keys[k] = key;
        // k0       k1
        // key0 <-> key1;
    }

    private boolean less(int i, int j) {
        if(keys[pq[i]].compareTo(keys[pq[j]]) > 0)
            return true;
        return false;
    }

    private void sink(int k) {
        while (2 * k <= n){
            int j = 2 * k;
            if(j < n && less(j, j + 1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while(k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void resize(int capacity) {
        StdOut.println("resize: " + n);
        Key [] t0 = (Key[]) new Comparable[capacity];
        int [] t1 = new int [capacity];
        int [] t2 = new int [capacity];
        for(int i = 1; i <= n; i++) {
            t0[i] = keys[i];
            t1[i] = pq[i];
            t2[i] = qp[i];
        }
        for(int i = n + 1; i < t2.length; i++) {
            t2[i] = -1;
        }
        keys = t0;
        pq = t1;
        qp = t2;
        //t0 = null;
        //t1 = null;
        //t2 = null;
    }

    public static void main(String [] args) {
        IndexMinPQ<String> p = new IndexMinPQ<String>(1);

        p.insert(1, "Z");
        p.insert(2, "E");
        p.insert(3, "A");
        p.insert(4, "R");
        p.insert(5, "A");
        p.insert(6, "S");
        p.insert(7, "W");
        p.insert(8, "I");


        // p.change(5, "Q");
        //p.delete(3);

        while (!p.isEmpty()) {
            StdOut.println(p.min());
            p.delMin();
        }
    }


}
