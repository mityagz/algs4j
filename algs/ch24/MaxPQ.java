package algs.ch24;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 8/18/16.
 */
public class MaxPQ<Key extends Comparable<Key>> implements Iterable {
    private Key [] pq;
    private int n = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN];
    }

    public MaxPQ(Key [] a) {
        pq = (Key[]) new Comparable[a.length];
        for(int i = 0; i < a.length; i++) {
            if(n >= pq.length - 1) resize(2 * pq.length);
            pq[++n] = a[i];
            swim(n);
        }

        /*
        for(int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
        */
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key v) {
        if(n >= pq.length - 1) resize(2 * pq.length);
        pq[++n] = v;
        swim(n);
    }

    public Key delMax() {
        if(isEmpty()) throw new NoSuchElementException();
        Key max = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        if(n > 0 && n == ((pq.length - 1) / 4)) resize(pq.length / 2);
        return max;
    }

    private boolean less(int i, int j) {
        if(pq[i].compareTo(pq[j]) < 0){
            return true;
        }
        return false;
    }

    private void exch(int i, int j){
        Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }

    private void swim(int k) {
        while(k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
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

    public Key max() {
        return pq[1];
    }

    private void resize(int capacity) {
        Key [] t = (Key[]) new Comparable[capacity];
        for(int i = 1; i <= n; i++) {
            t[i] = pq[i];
        }
        pq = t;
        t = null;
    }

    public boolean isMaxHeap(int k) {
        if(k > n) return true;
        int left = 2*k;
        int right = left + 1;
        if (left <= n && pq[left].compareTo(pq[k]) > 0) return false;
        if (right <= n && pq[right].compareTo(pq[k]) > 0) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }

    public static void main(String [] args) {
        MaxPQ<String> mpq = new MaxPQ<String>(5);
        while (!StdIn.isEmpty()) {
            String s = String.valueOf(StdIn.readChar());
            if(!s.contains(" ")) {
                mpq.insert(s);
            }
        }

        if(mpq.isMaxHeap(1)) {
            StdOut.println("mpq is MaxHeap");
        } else {
            StdOut.println("mpq isn't MaxHeap");
        }

        while(!mpq.isEmpty()) {
            StdOut.println(mpq.delMax());
        }


        Integer [] a = {1, 3, 18, 2, 15, 199, 3, 9, 255, 13};

        MaxPQ<Integer> pq0 = new MaxPQ<Integer>(a);
         while(!pq0.isEmpty()) {
             StdOut.println(pq0.delMax());
         }


    }

    @Override
    public Iterator<Key> iterator() {
       Iterator<Key>  i = new Iterator<Key>() {

           private int currentIndex = 1;

           @Override
           public boolean hasNext() {
               return currentIndex < pq.length && pq[currentIndex] != null;
           }

           @Override
           public Key next() {
               return (Key)pq[currentIndex++];
           }

           @Override
           public void remove() {

           }
       };

       return (Iterator<Key>)i;
    }
}
