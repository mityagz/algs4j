package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 1/22/16.
 */
public class GeneralizedQueue<Item> implements Iterable {
    private Node first;
    private int n;
    private class Node {
        Item item;
        Node next;
    }

    GeneralizedQueue(){

    }

    public boolean isEmpty(){
        if(n == 0){
            return true;
        }
        return false;
    }

    public void insert(Item x){
        Node oldFirst = first;
        first = new Node();
        first.item = x;
        first.next = oldFirst;
        n++;
    }

    /*
    public Item delete(int k){
        Node x = first;
        Item item;
        int i = n - k - 1;
        while (i > 0){
            x = x.next;
            i--;
        }
        item = x.next.item;
        x.next = x.next.next;
        n--;
        return item;
    }
    */

    public Item delete(int k){
        if(k == 0 || k > n ) { new NoSuchElementException();}
        Item item;
        Node x;
        int c = n - k - 1;
        for(x = first; c > 0; x = x.next, c--){

        }
        item = x.next.item;
        x.next = x.next.next;
        n--;
        return item;
    }

     public void listPrint(){
        for(Node x = first; x != null; x = x.next){
            StdOut.println("Item: " + x.item + " " + x);
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String [] args){
        GeneralizedQueue<Integer> gq = new GeneralizedQueue<Integer>();
        gq.insert(2);
        gq.insert(7);
        gq.insert(13);
        gq.insert(3);

        gq.listPrint();

        StdOut.println("D: " + gq.delete(2));

        gq.listPrint();
    }
}
