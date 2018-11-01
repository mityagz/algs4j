package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/26/16.
 */
public class Cl1341c {
    public static void main(String [] args){
        RQueue<Integer> q = new RQueue<Integer>();
        q.enqueue(11);
        q.enqueue(13);
        q.enqueue(7);
        q.listPrint();
        StdOut.println("Q: " + q + " Size: " + q.size());

        RQueue<Integer> r = new RQueue<Integer>(q);
        StdOut.println("R: " + r + " Size: " + r.size());
        r.listPrint();
        r.enqueue(155);
        r.listPrint();
        StdOut.println("-----------");
        q.listPrint();

    }
}
