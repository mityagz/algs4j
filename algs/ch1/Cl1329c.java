package algs.ch1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/5/16.
 */
public class Cl1329c {
    private class Node<Item>{
        Item item;
        Node next;
    }

    public static Node reverse(Node x) {
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
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(77);
        for(Integer item : q){
            StdOut.println(item);
        }

    }
}
