package algs.ch31;

import java.security.Key;
import java.util.Date;

/**
 * Created by mitya on 10/29/16.
 */
public class Time implements Comparable<Time>  {
    Date date;

    Time(int y, int m, int d, int h, int min, int sec) {
        this.date = new Date(y, m, d, h, min, sec);
    }

    @Override
    public int compareTo(Time x) {
        if(this.date.compareTo(x.date) < 0) {
            return -1;
        } else if(this.date.compareTo(x.date) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(date.getYear()) + "-" + String.valueOf(date.getMonth()) + "-" + String.valueOf(date.getDay()) + " " + String.valueOf(date.getHours()) + ":" + String.valueOf(date.getMinutes()) + ":" + String .valueOf(date.getSeconds());
    }
}
