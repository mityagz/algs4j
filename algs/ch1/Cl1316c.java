package algs.ch1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/2/16.
 */
public class Cl1316c {
    public static Date [] readDates() {
        Queue<Date> qdate = new Queue<Date>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            StdOut.println(item);
            qdate.enqueue(new Date(item));
        }

        int n = qdate.size();
        Date [] a = new Date[n];
        for(int i = 0; i < a.length; i++){
            a[i] = qdate.dequeue();
        }
        return a;
    }

    public static void main(String [] args){
        Date [] a = Cl1316c.readDates();
        for(int i = 0; i < a.length; i++){
            StdOut.println("Date: " + a[i]);
        }
    }
}
