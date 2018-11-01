package algs.ch25;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by mitya on 9/19/16.
 */

// 2.5.12

public class SPT {

    public static void main(String [] args) {
        int n = StdIn.readInt();
        Job [] j = new Job[n];

        for(int i = 0; i < n; i++) {
            String name = StdIn.readString();
            double time = StdIn.readDouble();
            j[i] = new Job(name, time);
        }

        Arrays.sort(j);


        for(int i = 1; i < n; i++) {
            StdOut.println(j[i]);
        }

    }
}
