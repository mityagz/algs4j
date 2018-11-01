package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by mitya on 1/3/16.
 */
public class RQueue<Item> {
    private Node<Item> last;
    private int n = 0;

    private class Node<Item> {
        private Item item;
        Node next;
    }

    RQueue(){
        last = null;
    }

    RQueue(RQueue<Item> q){
        int ns = q.size();
        Item  item;
        RQueue r = this;
        for(int i = 0; i < ns - 1; i++){
            item = (Item)q.dequeue();
            q.enqueue(item);
            r.enqueue(item);
        }
    }

    public void enqueue(Item i){
        int j = 1;
        Node x;
        Node old_last = last;
        last = new Node<Item>();
        last.item = i;
        n++;
        if(old_last == null){
            last.next = last;
        }else {
            last.next = old_last;
            for (x = last;j < n ;x = x.next) {
                j++;
            }
            x.next = last;
        }

    }

    public Item dequeue(){
        int j = 1;
        Node x, prev = null;
        if(last == null) throw  new NoSuchElementException("Очередь пуста");
        for (x = last; j  < n ; x = x.next, j++) {
                prev = x;
            }
        x.next = last;
        n--;
        return (Item)prev.next.item;
    }

    public boolean isEmpty(){
        if(last != null){
            return true;
        }
        return false;
    }

    public int size(){
        return n;
    }

    public void listPrint(){
        int i = 0;
        for(Node x = last; i < n; x = x.next, i++){
            StdOut.println("Item: " + x.item);
        }
    }

    // Queue API methods
    // Queue create empty queue
    // void enqueue(Item item)
    // Item dequeue()
    // boolean isEmpty()
    // int size()

    public static void main(String [] args){
        RQueue<Integer> rq = new RQueue<Integer>();
        rq.enqueue(1);
        rq.enqueue(5);
        rq.enqueue(7);
        rq.enqueue(4);
        rq.enqueue(77);
        rq.listPrint();
        StdOut.println("Dequeue element: " + rq.dequeue());
        rq.listPrint();
        StdOut.println("Dequeue element: " + rq.dequeue());
        rq.listPrint();
        StdOut.println("Dequeue element: " + rq.dequeue());
        rq.listPrint();
        StdOut.println("Dequeue element: " + rq.dequeue());
        rq.listPrint();
        StdOut.println("------------------");
        rq.enqueue(99);
        rq.listPrint();
        StdOut.println("Dequeue element: " + rq.dequeue());
        rq.listPrint();

    }
}
