package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/2/16.
 */
public class Cl136c {
    public static void main(String [] args){
        //Reverse
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        ResizingArrayQueue<String> q = new ResizingArrayQueue<String>(1);
        for(int i = 0; i < 10; i++){
            q.enqueue(String.valueOf(i));
        }
        for(String c : q){
            StdOut.print(c + " ");
        }
        StdOut.println();

        while(!q.isEmpty()){
            s.push(q.dequeue());
        }
        while (!s.isEmpty()){
            q.enqueue(s.pop());
        }

        for(String c : q){
            StdOut.print(c + " ");
        }
    }
}
