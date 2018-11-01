package algs.ch25;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 9/24/16.
 */
public class Domain implements Comparable {
    String d;

    Domain(String s) {
        String d = "";
        String [] a = s.split("\\.");
        String [] b = new String[a.length];
        for(int i = 0, j = b.length - 1; i < a.length; i++, j--) {
            b[(b.length - 1) - i] = a[i];
            d += a[j] + ".";
        }
        this.d = d;
    }
    @Override
    public int compareTo(Object o) {
        String s1 = ((Domain) o).d;
        return d.compareTo(s1);
    }

    @Override
    public String toString() {
        return d;
    }

    public static void main(String [] args) {
        Domain [] dd = new Domain[6];
        dd[0] = new Domain("cs.princeton.edu");
        dd[1] = new Domain("cs.princeton.org");
        dd[2] = new Domain("cs.princeton.biz");
        dd[3] = new Domain("cs.princeton.com");
        dd[4] = new Domain("cs.princeton.info");
        dd[5] = new Domain("cs.princeton.sex");

        for(int i = 0; i < dd.length; i++) {
            StdOut.println(dd[i]);
        }


        StdOut.println();

        Arrays.sort(dd);

         for(int i = 0; i < dd.length; i++) {
            StdOut.println(dd[i]);
        }
    }
}
