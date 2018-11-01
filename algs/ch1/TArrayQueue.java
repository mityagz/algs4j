package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.*;

/**
 * Created by mitya on 1/1/16.
 */
public class TArrayQueue {

    public static void main(String [] args){

        ResizingArrayQueue<String> q = new ResizingArrayQueue<String>(1);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                q.enqueue(item);
            }else if(!q.isEmpty()){
                StdOut.print(q.dequeue() + " ");
            }
            //StdOut.println("Array size: " + q.sarray());
        }
        StdOut.println();
        StdOut.println("В очереди осталось: " + q.size());
        for(String i : q){
            StdOut.print(i + " ");
        }
        StdOut.println();
        if(q.isFull()){
            StdOut.println("Места в очереде больше нет!");
        }
    }

}
