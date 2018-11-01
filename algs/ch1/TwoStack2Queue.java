package algs.ch1;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by mitya on 3/12/16.
 */
public class TwoStack2Queue<Item> {
    Stack<Item> s0;
    Stack<Item> s1;

    TwoStack2Queue(){
        s0 = new Stack<Item>();
        s1 = new Stack<Item>();
    }

    public void enqueue(Item item){
           s0.push(item);
    }

    public  Item dequeue(){
        if(s1.isEmpty()) {
            try {
                if (s0.isEmpty()) {
                    throw new NoSuchElementException();
                } else {
                    while (!s0.isEmpty()) {
                        s1.push(s0.pop());
                    }
                    return s1.pop();
                }
            } catch (NoSuchElementException e) {
                StdOut.println(e);
                StdOut.println("Queue is empty");
                return null;
            }
        }else{
            return s1.pop();
        }
    }
    public static void main(String [] args){
        TwoStack2Queue ts = new TwoStack2Queue<Integer>();
        ts.enqueue(1);
        ts.enqueue(15);
        ts.enqueue(10);

        StdOut.println(ts.dequeue());
        StdOut.println(ts.dequeue());
        StdOut.println(ts.dequeue());
        ts.enqueue(11);
        StdOut.println(ts.dequeue());
        StdOut.println(ts.dequeue());
    }
}
