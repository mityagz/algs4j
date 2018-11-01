package algs.ch25;

import javax.swing.*;

/**
 * Created by mitya on 9/19/16.
 */
public class Job implements Comparable {
    private String name;
    private double time;

    Job(String name, double time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }


    public double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name + " " + time;
    }

    @Override
    public int compareTo(Object o) {
        double x = ((Job)o).time;
        if(time < x)
            return -1;
        if(time > x)
            return 1;
        return 0;
    }
}
