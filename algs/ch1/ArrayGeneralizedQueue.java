package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 1/20/16.
 */
public class ArrayGeneralizedQueue<Item> implements Iterable{
    private Item [] a;
    private int n;
    private int head = 0;
    private int tail = 0;
    ArrayGeneralizedQueue(int cap){
        a = (Item[]) new Object[cap];
    }

    public void resize(int cap){
        Item [] na = (Item[]) new Object[cap];
        for(int i = 0, j = 0; i < n; i++){
            if(head + i < a.length) {
                na[i] = a[(head + i)];
            }else {
                 na[i] = a[j++];
            }
        }

        a = na;
        head = 0;
        tail = n;

    }

    public boolean isEmpty(){
        if(n == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return n;
    }

    public int getHead(){
        return head;
    }

    public int getTail(){
        return tail;
    }

    public void insert(Item x){
        if(n == a.length){
            resize(2*a.length);
        }
        a[tail] = x;
        n++;
        tail++;
        if( tail == a.length) {
            tail = 0;
        }
    }

    public Item dequeue(){
        if(isEmpty()){ throw new NoSuchElementException("Queue underflow"); }
        Item item = a[head];
        a[head] = null;
        head++;
        n--;
        if(n != a.length && head == a.length){
            head = 0;
        }
        if(n > 0 && n == a.length/4){
            resize(a.length/2);
        }
        return item;
    }


    public Item delete(int k){
        Item r;
        if (k > n || k == 0) { throw new NoSuchElementException();}
        int x = tail - k;
        if(x >= 0){
            r = a[x];
            while(x < tail){
                    a[x] = a[x + 1];
                    x++;
            }
            tail--;
            n--;
        }else{
            x = a.length + x;
            r = a[x];
            while(x < a.length - 1){
                a[x] = a[x + 1];
                x++;
            }
            a[a.length -1] = a[0];
            x = 0;
            while(x < tail){
                    a[x] = a[x + 1];
                    x++;
            }
            tail--;
            if(tail < 0){
                tail = a.length - 1;
            }
            n--;
        }
        return r;
    }


    @Override
    public Iterator iterator() {
        return new ArrayGeneralizedQueueIterator<Item>();
    }

    private class ArrayGeneralizedQueueIterator<Item> implements Iterator {
        private int i, j = 0;
        private int t = tail;
        private int h = head;
        @Override
        public boolean hasNext() {
            if(i < n) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(!hasNext()){ throw new NoSuchElementException();}
            Item x;
            if(head + i < a.length){
                x = (Item)a[head + i];
            }else{
                x = (Item)a[j];
                j++;
            }
            i++;
            return x;
        }

        public void remove() { throw new UnsupportedOperationException(); }
    }

    public static void main(String [] args){
        ArrayGeneralizedQueue gq = new ArrayGeneralizedQueue(10);
        gq.insert(10);
        gq.insert(3);
        gq.insert(1);
        gq.insert(7);
        gq.insert(5);
        gq.insert(9);
        gq.insert(13);


        for(Object x : gq){
            StdOut.println("X: " + x);
        }

        StdOut.println("Border: " + gq.getHead() + " " + gq.getTail());
        gq.dequeue();
        gq.dequeue();
        StdOut.println("Size: " + gq.size());
        StdOut.println("Border: " + gq.getHead() + " " + gq.getTail());
        for(Object x : gq){
            StdOut.println("X: " + x);
        }

        gq.insert(7);
        gq.insert(5);
        gq.insert(4);
        gq.insert(13);
        gq.insert(17);
        gq.insert(21);

        StdOut.println("Size: " + gq.size());
        StdOut.println("Border: " + gq.getHead() + " " + gq.getTail());
        for(Object x : gq){
            StdOut.println("X: " + x);
        }

        StdOut.println("D: " + gq.delete(5));
        StdOut.println("Border: " + gq.getHead() + " " + gq.getTail());
        StdOut.println("D: " + gq.delete(1));
        StdOut.println("D: " + gq.delete(1));
        StdOut.println("D: " + gq.delete(6));
        StdOut.println("Border: " + gq.getHead() + " " + gq.getTail());
        //gq.insert(111);
        StdOut.println("---");
        for(Object x : gq){
            StdOut.println("X: " + x);
        }

    }
}
