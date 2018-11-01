package algs.ch25;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by mitya on 9/19/16.
 */
public class Processor implements Comparable {
    //Job [] j;
    Queue<Job> j;
    private double amount;

    Processor() {
        amount = 0;
        j = new Queue<Job>();
    }

    public void add(Job job) {
        amount += job.getTime();
        j.enqueue(job);
    }


    @Override
    public String toString() {
        String r = "";
        while (!j.isEmpty()) {
            r += " " + j.dequeue().getName();
        }
        return r + " Amount time: " + String.valueOf(amount);
    }

    @Override
    public int compareTo(Object o) {
        double x = ((Processor)o).amount;
        if(amount < x)
            return -1;
        if(amount > x)
            return 1;
        return 0;
    }
}
