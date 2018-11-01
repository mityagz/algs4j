package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/12/15.
 */
public class Date {
    private final int month;
    private final int day;
    private final int year;

    Date(int m, int d, int y){
        month = m;
        day = d;
        year = y;
    }
    // date format 5/22/1939
    Date(String date){
        String [] f = date.split("/");
        month = Integer.parseInt(f[0]);
        day = Integer.parseInt(f[1]);
        year = Integer.parseInt(f[2]);
    }

    public int month(){
        return month;
    }

    public int day(){
        return day;
    }

    public int year(){
        return year;
    }

    public String toString(){
        return month() + " " + day() + " " + year();
    }

    public boolean equal(Object x){
        if(this == x) return true;
        if(x == null) return false;
        if(this.getClass() != x.getClass()) return false;
        Date that = (Date) x;
        if(this.day != that.day) return false;
        if(this.month != that.month) return false;
        if(this.year != that.year) return false;
        return true;
    }


    public static void main(String [] args){
        StdOut.println(new Date("5/22/1938"));
    }
}
