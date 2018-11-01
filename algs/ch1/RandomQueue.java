package algs.ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 1/17/16.
 */
public class RandomQueue<Item> implements Iterable {

    private Item [] a;
    private int head = 0;
    private int tail = 0;
    private int n = 0;

    RandomQueue(int cap){
        a = (Item[]) new Object[cap];
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

    public void resize(int max){
         Item [] t = (Item[]) new Object[max];
         int j = 0;
         for(int i = head; i < n; i++, j++){
             if(i == a.length)
                 i = 0;
             t[j] = a[i];
         }
        a = t;
        head = 0;
        tail = n;
    }

    public void enqueue(Item item){
        if(n == a.length){
            resize(2 * a.length);
        }
        a[tail] = item;
        n++;
        tail++;
        if(tail == a.length){
            tail = 0;
        }
    }

    public Item dequeue(){
        if(isEmpty()){ throw new NoSuchElementException("Queue underflow"); }
        tail--;
        n--;

        int t = StdRandom.uniform(0, n + 1);
        Item temp = a[t];
        a[t] = a[tail];
        a[tail] = temp;

        Item item = a[tail];
        a[tail] = null;

        if(tail == 0)
            tail = a.length - 1;

        if( n > 0 && n == a.length/4)
            resize(a.length/2);

        return item;
    }

    public Item sample(){
        return null;
    }

    public int aSize(){
        return a.length;
    }


    @Override
    public Iterator iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator {
        private int i = 0;
        private int t = tail;
        private int h = head;
        private int ind, ind1, ind2 = 0;

        RandomQueueIterator(){

        }

        @Override
        public boolean hasNext() {
            if(i < n)
                return true;
            return false;
        }

        @Override
        public Object next() {
            if(head < tail){
              ind = StdRandom.uniform(head, tail);
            } else {
                if(StdRandom.bernoulli(0.5)){
                    ind = StdRandom.uniform(head, a.length - 1);
                }else{
                    ind = StdRandom.uniform(0, tail);
                }
            }
            i++;
            return  a[ind];
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    /*
    private class RandomQueueIterator implements Iterator{

        private int i;
        private int c;

        RandomQueueIterator(){
           c = 0;
           i = head;
        }

        @Override
        public boolean hasNext() {
            if(c < n) {
                if (i == a.length) {
                    i = 0;
                }
                c++;
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return (Item)a[i++];
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    */



    public static void main(String [] args){
        RandomQueue rq = new RandomQueue<Integer>(5);
        rq.enqueue(1);
        rq.enqueue(3);
        rq.enqueue(7);
        rq.enqueue(5);
        StdOut.println("Size: " + rq.aSize());
        rq.enqueue(9);
        //StdOut.println("Size: " + rq.aSize());
        rq.enqueue(17);
        rq.enqueue(13);
        //StdOut.println("Size: " + rq.aSize());
        rq.enqueue(1);
        rq.enqueue(3);
        rq.enqueue(7);
        rq.enqueue(5);
        rq.enqueue(9);
        StdOut.println("Size: " + rq.aSize());

        for(Object x : rq){
            StdOut.println("Item: " + x);
        }

        //StdOut.println("Size: " + rq.aSize());
        /*
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println("Size: " + rq.aSize());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println("Size: " + rq.aSize());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println("Size: " + rq.aSize());
        StdOut.println(rq.dequeue());
        //StdOut.println(rq.dequeue());
        //StdOut.println(rq.dequeue());
        //StdOut.println(rq.dequeue());
        */
    }
}
