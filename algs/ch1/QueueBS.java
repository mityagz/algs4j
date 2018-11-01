package algs.ch1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by mitya on 1/31/16.
 */
public class QueueBS<Item> {
    Stack s0, s1;

    QueueBS(){
        s0 = new Stack();
        s1 = new Stack();
    }

    public void enqueue(Item item){
        s0.push(item);
    }

    public Item dequeue() {
        if(s1.isEmpty()){
            if(s0.isEmpty()){
                throw new NoSuchElementException();
            }else{
                while (!s0.isEmpty()){
                    s1.push(s0.pop());
                }
                return (Item)s1.pop();
            }
        }else{
            return (Item)s1.pop();
        }
    }

    public boolean isEmpty(){
        if((s0.size() + s1.size()) == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return s0.size() + s1.size();
    }

    public static void main(String [] args){
            QueueBS q = new QueueBS<Integer>();
            q.enqueue(1);
            q.enqueue(13);
            q.enqueue(45);
            q.enqueue(60);
            q.enqueue(15);
            while (!q.isEmpty()){
                StdOut.println("E: " + q.dequeue());
            }
    }
}
