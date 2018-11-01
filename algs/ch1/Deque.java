package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 1/13/16.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node left;
    private Node right;
    private int n;

    private class Node{
        Item item;
        Node prev;
        Node next;
    }


    Deque(){
        left = right = null;
        n = 0;
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

    public void pushLeft(Item item){
        Node node = new Node();
        node.item = item;
        if(left == null && right == null){
            node.prev = null;
            node.next = null;
            left = right = node;
        }else{
            node.prev = null;
            node.next = left;
            left.prev = node;
            left = node;
        }
        n++;
    }

    public void pushRight(Item item){
        Node node = new Node();
        node.item = item;
        if(left == null && right == null){
            node.prev = null;
            node.next = null;
            left = right = node;
        }else{
            node.next = null;
            node.prev = right;
            right.next = node;
            right = node;
        }
        n++;
    }

    public Item popLeft(){
        Node node = left;
        n--;
        if(n == 0){
            left = right = null;
        }else{
            left.next.prev = null;
        left = left.next;
        }
        return node.item;
    }

    public Item popRight(){
        Node node = right;
        n--;
        if(n == 0){
            left = right = null;
        }else{
            right.prev.next = null;
            right = right.prev;
        }
        return node.item;
    }

    public void listPrint(){
        //StdOut.println("First: " + first + " Last: " + last);
        for(Node x = left; x != null; x = x.next){
            StdOut.println("Item: " + x.item + " " + x);
        }
    }

    public void listPrintr(){
        //StdOut.println("First: " + first + " Last: " + last);
        for(Node x = right; x != null; x = x.prev){
            StdOut.println("Item: " + x.item);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String [] args){
        Deque<Integer> dq = new Deque<Integer>();



        dq.pushLeft(2);
        dq.pushLeft(77);
        dq.pushRight(111);

        dq.pushRight(71);
        dq.pushRight(9);

        StdOut.println("Size deq is: " + dq.size());

         dq.listPrint();

        StdOut.println(dq.popLeft());
        StdOut.println(dq.popLeft());
        StdOut.println(dq.popRight());
        StdOut.println(dq.popRight());
        StdOut.println(dq.popRight());


        /*

        DoubleNode dn0 = new DoubleNode();
        dn0.item = 0;
        insertBegin(dl, dn0);

        DoubleNode dn1 = new DoubleNode();
        dn1.item = 1;
        insertBegin(dl, dn1);
        */

        dq.listPrint();

        StdOut.println("Size deq is: " + dq.size());


        dq.pushRight(113);

        dq.listPrint();

        StdOut.println("Size deq is: " + dq.size());
    }
}
