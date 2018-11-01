package algs.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 1/22/16.
 */
public class MoveToFront<Item> implements Iterable {
    private Node first = null;
    private int n;
    private class Node {
        Item item;
        Node next;
    }

    public void c() {
        Node prev = first;
        for (Node x = first; x != null; prev = x, x = x.next) {
          StdOut.println("prev.item = " + prev.item + " x.item = " + x.item);
        }

        /*
        Node y = null;
        prev = first;
        while (y != null){
            prev = y;
            y = y.next;
        }
        */
    }

    public void DeleteInsert(Item key){
        Node f = null;
        for(Node x = first; x != null; x = x.next){
            if(x.item == key){
                f = x;
                first = x.next;
                n--;
            }
            if(x.next != null)
            if(x.next.item == key){
                f = x.next;
                x.next = x.next.next;
                n--;
                break;
            }
        }
        if(f != null) {
            insert(f.item);
        }else {
            insert(key);
        }
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
        MoveToFront mtf = new MoveToFront();
        Integer i;
        while (!StdIn.isEmpty()){
            i = Integer.parseInt(StdIn.readString());
            mtf.DeleteInsert(i);

            //StdOut.println(StdIn.readString());
        }

        mtf.listPrint();
        mtf.c();
    }
}
