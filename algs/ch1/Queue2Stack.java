package algs.ch1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by mitya on 3/12/16.
 */
public class Queue2Stack<Item> {
    Queue<Item> q;
    int s;
    Queue2Stack(){
        q = new Queue<Item>();
    }

    public void push(Item item){
        q.enqueue(item);
    }

    public Item pop(){
        try {
            if (q.isEmpty()) {
                throw new NoSuchElementException();
            }else{
                s = q.size();
                while (s > 1){
                    q.enqueue(q.dequeue());
                    s--;
                }
                return (Item) q.dequeue();
            }
        }catch (NoSuchElementException e){
            StdOut.println("Stack is empty");
            StdOut.println(e);
            return null;
        }
    }
    public static void main(String [] args){
        Queue2Stack<Integer> qs = new Queue2Stack<Integer>();
        qs.push(1);
        qs.push(17);
        qs.push(13);
        StdOut.println(qs.pop());
        StdOut.println(qs.pop());
        StdOut.println(qs.pop());
        qs.push(1111);
        StdOut.println(qs.pop());
    }
}