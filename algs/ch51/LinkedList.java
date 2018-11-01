package algs.ch51;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by mitya on 5/6/17.
 */
public class LinkedList<Key extends Comparable<Key>> {

    private Node head;
    private Node tail;
    private int n;

    /*
    private class Node {
        int N;
        Key data;
        Node next, prev;

        public Node(Key data, int N) {
            this.data = data;
            this.N = N;
        }

        public Key getData() {
            return data;
        }
    }
    */

    public LinkedList() {
        head = null;
        tail = null;
        n = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return n;
    }

    public Node getHead() { return head; }
    public Node getTail() { return tail; }

    public boolean add(Key k) {

        Node node = new Node(k, n);

        if(head == null) {
            head = node;
            tail = node;
            node.prev = null;
            node.next = null;
        } else {
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

        return true;
    }

    public boolean exch(Node i, Node j) {
        //
        // a <-> i <-> k <-> n <-> j <-> z
        // i.prev = a; i.next = k;
        // a.prev = null; a.next = i;
        // k.prev = i; k.next = n;
        //
        // j.prev = n; j.next = z;
        // n.prev = k; n.next = j;
        // z.prev = j; z.next = null;

        //
        // a <-> i <-> k <-> n <-> j <-> z
        // i.prev = a; i.next = k;
        // a.next = i;
        // k.prev = i;
        //
        // j.prev = n; j.next = z;
        // n.next = j;
        // z.prev = j;

        //

        Node t = new Node();
        Node tHead = new Node();
        Node tTail = new Node();

        tHead = head;
        tTail = tail;


        t.next = j.next;
        t.prev = j.prev;
        t.data = j.data;

        if(i.prev != null)
            i.prev.next = j;
        if(i.next != null)
            i.next.prev = j;

        if(i.prev == j || j.prev == i) {
            j.prev = i;
        } else {
            j.prev = i.prev;
        }

        if(i.next == j || j.next == i) {
            j.next = i;
        } else {
            j.next = i.next; // !!!!!!
        }

        if(i == tHead) head = j;
        if(i == tTail) tail = j;


        if(t.prev != null)
            t.prev.next = i;

        if(t.next != null)
            t.next.prev = i;

        if(i.prev == j || j.prev == i) {
            i.prev = t;
        } else {
            i.prev = t.prev;
        }

        if(i.next == j || j.next == i) {
            i.next = t;
        } else {
            i.next = t.next;
        }

        if(j == tHead) head = i;
        if(j == tTail) tail = i;

        /*
        Node t = new Node();
        Node tHead = new Node();
        Node tTail = new Node();

        tHead = head;
        tTail = tail;


        t.next = j.next;
        t.prev = j.prev;
        t.data = j.data;

        if(i.prev != null)
            i.prev.next = j;
        if(i.next != null)
            i.next.prev = j;

            j.prev = i.prev;
            j.next = i.next;

        if(i == tHead) head = j;
        if(i == tTail) tail = j;


        if(t.prev != null)
            t.prev.next = i;

        if(t.next != null)
            t.next.prev = i;

            i.prev = t.prev;
            i.next = t.next;

        if(j == tHead) head = i;
        if(j == tTail) tail = i;
        */

        return true;
    }


    public Iterator<Key> iterator()  {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Key> {
        private Node current = head;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            Key item = (Key) current.data;
            current = current.next;
            return item;
        }
    }


}
