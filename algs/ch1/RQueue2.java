package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 1/4/16.
 */
public class RQueue2<Item> implements Iterable<Item> {
    private Node last;
    private int n;

    private class Node{
        Item item;
        Node next;
    }

    public Node getNode(){
        return last;
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
        if(isEmpty()){
            last.next = last;
        } else {
          last.next = oldLast.next;
          oldLast.next = last;
        }
        n++;
    }

    public Item dequeue(){
        Node res;
        res = last.next;
        last.next = last.next.next;
        n--;
        return (Item)res.item;
    }

    public void listPrint(){
        int i = 0;
        for(Node x = last.next; i < n; x = x.next, i++){
            StdOut.println("Item: " + x.item);
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    // @deprecated
    public  Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null){
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first  = second;
        }
        return reverse;
    }


    public static void main(String [] args){
        RQueue2<Integer> rq = new RQueue2<Integer>();
        rq.enqueue(10);
        rq.enqueue(5);
        rq.enqueue(7);
        rq.enqueue(9);
        rq.enqueue(3);
        rq.listPrint();
        StdOut.println("--------------\n" +  rq.dequeue());
        StdOut.println("--------------\n" +  rq.dequeue());
        rq.listPrint();
        //rq.reverse(rq.getNode());
        //rq.listPrint();
    }
}
