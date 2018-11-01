package algs.ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * Created by mitya on 1/17/16.
 */
public class RandomBag<Item> implements Iterable<Item> {

    private Node first;
    private int n;

    private class Node{
        Item item;
        Node next;
    }

    RandomBag(){

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

    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.next = oldfirst;
        first.item = item;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator<Item> implements Iterator{
        Item [] a;
        int i = 0;

        RandomIterator(){
            int j = 0;
            a = (Item []) new Object[n];
            for(Node i = first; i != null; i = i.next){
                a[j] = (Item) i.item;
                j++;
            }
            StdRandom.shuffle(a);
        }

        @Override
        public boolean hasNext() {
            if(i < a.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return a[i++];
        }

        public void remove(){

        }
    }

    public static void main(String [] args){
            RandomBag rb = new RandomBag<Integer>();

            rb.add(1);
            rb.add(12);
            rb.add(3);

            for(Object i : rb){
                StdOut.println("Item: " + (Integer) i);
            }
    }
}
