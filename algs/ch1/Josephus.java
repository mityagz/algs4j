package algs.ch1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/19/16.
 */
public class Josephus {

    public static void main(String [] args){
        Queue q = new Queue();
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int c = m;
        Object last;

        for(int i = 0; i < n; i++){
            q.enqueue(i);
        }

        c = m;
        while(q.size() != 1){
                c--;
                if(c == 0){
                    StdOut.print(q.dequeue() + " ");
                    c = m;
                }else{
                    q.enqueue(q.dequeue());
                }
        }
        StdOut.println(q.dequeue());
    }
}
