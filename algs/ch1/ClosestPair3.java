package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 3/5/16.
 */
public class ClosestPair3 {
    private class Pair {
        int i0;
        int i1;
        int min0;
        int min1;

        public void setI0(int i) {
            i0 = i;
        }

        public void setI1(int i) {
            i1 = i;
        }

        public void setMin0(int m) {
            min0 = m;
        }

        public void setMin1(int m) {
            min1 = m;
        }

        public int getI0() {
            return i0;
        }

        public int getI1() {
            return i1;
        }

        public String toString() {
            return "i0: " + i0 + " i1: " + i1 + " min0: " + min0 + " min1: " + min1 + " subs min: " + (min1 - min0);
        }

    }

    public  Pair searchMin(int [] a) {
        int [] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        Pair p = new Pair();
        int min = 1000000000;
        int minI0 = 0, minI1 = 0;
        for (int i = 1; i < a.length; i++) {
            if (Math.abs(b[i - 1] - b[i]) < min) {
                minI0 = i - 1;
                minI1 = i;
                min = Math.abs(b[minI0] - b[minI1]);
                p.setMin0(min);
            }
        }

        p.setMin0(b[minI0]);
        p.setMin1(b[minI1]);
        //StdOut.println(minI0 + " " + minI1);
        p.setI0(Arrays.binarySearch(a, b[minI0]));
        p.setI1(Arrays.binarySearch(a, b[minI1]));
        return p;
    }

    public static void main(String [] args){
        int [] a = In.readInts(args[0]);
        StdOut.println(new ClosestPair3().searchMin(a));
    }
}
