package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 1/5/16.
 */
public class MQueue<Item> implements Iterable {
    private Node first;
    private Node last;
    private int n;

    private class Node{
        Item item;
        Node next;
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

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue(){
        Node res;
        res = first;
        first = first.next;
        n--;
        return (Item)res.item;
    }

    public void listPrint(){
        for(Node x = first; x != null; x = x.next){
            StdOut.println("Item: " + x.item);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }


    public  Node reverse(Node x) {
        Node first = x;
        Node last = x;
        Node reverse = null;
        while (first != null){
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first  = second;

        }
        this.first = reverse;
        this.last = last;
        return reverse;
    }
    int i = 0;
    public Node reverser(Node first){
        if(first == null) return null;
        StdOut.println("1 Item recurs: " + first.item + " i: " + i++);
        if(first.next == null) return first;
        Node second = first.next;
        StdOut.println("2 Item recurs: " + first.item + " i: " + i++);
        Node rest = reverser(second);
         StdOut.println("3 Item recurs first: " + first.item + " i:" + i++);
         second.next = first;
         first.next = null;
        this.first = rest;
        return rest;
    }

    public Node getFirstNode(){
        return first;
    }


    public static void main(String [] args){
        MQueue<Integer> rq = new MQueue<Integer>();
        rq.enqueue(10);
        rq.enqueue(5);
        rq.enqueue(7);
        rq.enqueue(9);
        rq.enqueue(3);
        rq.listPrint();
        StdOut.println("--------------\n" +  rq.dequeue());
        //StdOut.println("--------------\n" +  rq.dequeue());
        //StdOut.println("--------------\n" + rq.getFirstNode());

        rq.listPrint();
        StdOut.println("--------------\n");
        rq.reverser(rq.getFirstNode());
        rq.listPrint();
        /*
        rq.enqueue(17);
        rq.enqueue(19);
        StdOut.println("--------------\n");
        rq.listPrint();
        StdOut.println("--------------\n");
        rq.reverser(rq.getFirstNode());
        rq.listPrint();
        rq.enqueue(21);
        StdOut.println("--------------\n");
        rq.listPrint();
        */
    }
}
