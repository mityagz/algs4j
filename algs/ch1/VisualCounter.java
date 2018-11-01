package algs.ch1;

import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Created by mitya on 12/12/15.
 */
public class VisualCounter  {
    private int count;
    private final String name;

    VisualCounter(String id){
        name = id;
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.blue);
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
    }
    public int tally(){
        return count;
    }
    public void decrement(){
        StdDraw.clear();
        count--;
        StdDraw.textLeft(1, 1, "Count value: " + count);
    }

    public void increment(){
        StdDraw.clear();
        count++;
        StdDraw.textLeft(1, 1, "Count value: " + count);
    }

    public String toString(){
        return count + " " + name;
    }

    public static void main(String [] args){
        VisualCounter vc = new VisualCounter("id");
        for(int i = 0; i < 10; i++) {
            vc.increment();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0; i < 10; i++) {
            vc.decrement();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
