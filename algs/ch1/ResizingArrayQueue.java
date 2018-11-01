package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 1/1/16.
 */
public class ResizingArrayQueue<Item> implements Iterable<Item> {
    private Item [] a;
    private int n;
    private int head = 0;
    private int tail = 0;
    ResizingArrayQueue(int cap){
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty(){
        if(n == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(n == a.length){
            return true;
        }else {
            return false;
        }
    }

    public int size(){
        return n;
    }

    public int sarray(){
        return a.length;
    }

    public void resize(int cap){
        Item [] na = (Item[]) new Object[cap];
        for(int i = 0, j = 0; i < n; i++){
            // na[i] = a[(head + i) % a.length]; // !!!!!!

            if(head + i < a.length) {
                na[i] = a[(head + i)];
            }else {
                 na[i] = a[j++];
            }
           // StdOut.println("i, j: " + i + ", " + j );
        }

        a = na;
        head = 0;
        tail = n;

    }

    public void enqueue(Item item){
        if(n == a.length){
            resize(2*a.length);
        }
        a[tail] = item;
        n++;
        tail++;
        if(!isFull() && tail == a.length) {
            tail = 0;
        }
    }

    public Item dequeue(){
        if(isEmpty()){ throw new NoSuchElementException("Queue underflow"); }
        Item item = a[head];
        a[head] = null;
        head++;
        n--;
        if(!isFull() && head == a.length){
            head = 0;
        }
        if(n > 0 && n == a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public Item peek(){
        if(isEmpty()){ throw new NoSuchElementException("Queue underflow"); }
        return a[head];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
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
        public Item next() {
            if(!hasNext()){ throw new NoSuchElementException();}
            int lh = h;
            Item item;
            // Item item = a[(head + i) % a.length]; // !!!!!!

            if(head + i < a.length) {
                item = a[(head + i)];
            } else {
                item = a[i];
            }

            if(!isFull() && h == a.length) {
                h = 0;
            }
            i++;
            h++;
            return item;
        }

        public void remove(){ throw new UnsupportedOperationException();}
    }
}
