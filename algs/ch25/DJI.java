package algs.ch25;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Date;

/**
 * Created by mitya on 9/10/16.
 */

// ex 2.5.9
public class DJI implements Comparable{
    private double i;
    private Date d;

    DJI(double i, Date d){
        this.i = i;
        this.d = d;
    }

    public double getInd() {
        return i;
    }

    public Date getDate() {
        return d;
    }

    @Override
    public int compareTo(Object dj) {
        DJI dji = (DJI) dj;
        if(this.i < dji.i)
            return -1;
        if(this.i > dji.i)
            return 1;

        if(this.i == dji.i){
            if(this.d.compareTo(dji.d) < 1)
                return -1;
            if(this.d.compareTo(dji.d) > 1)
                return 1;
            if(this.d.compareTo(dji.d) == 0)
                return 0;
        }

        return 0;
    }

    public static void main(String [] args){
        int n = 0;
        int i = 0;
        DJI [] a = new DJI[50000];
        while(!StdIn.isEmpty()) {
            String dt = StdIn.readString();
            String di = StdIn.readString();
            a[i++] = new DJI(Double.parseDouble(di), new Date(dt));
            n++;
        }

        DJI [] b = new DJI[n];
        for(int k = 0; k < b.length; k++){
            b[k] = a[k];
        }

        edu.princeton.cs.algs4.Insertion.sort(b);

        for(int j = 0; j < n; j++){
            StdOut.println("Date: " + b[j].getDate() + "Index: " + b[j].getInd());
        }
    }
}
