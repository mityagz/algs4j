package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mitya on 3/5/16.
 */
public class ClosestPair {
    private class Pair{
        int i0;
        int i1;
        int min0;
        int min1;
        public void setI0(int i){
            i0 = i;
        }
        public void setI1(int i){
            i1 = i;
        }
        public void setMin0(int m){
            min0 = m;
        }
        public void setMin1(int m){
            min1 = m;
        }
        public int getI0(){
            return i0;
        }
        public int getI1(){
            return i1;
        }

        public String toString() {
            return "i0: " + i0 + " i1: " + i1 + " min0: " + min0 + " min1: " + min1 + " subs min: " + (min1 - min0);
        }

    }
    public  Pair searchMin(int [] a){
        Pair p = new Pair();
        int min = 1000000000;
        int minI0 = 0, minI1 = 0;
        for(int i = 0; i < a.length; i++){
            if(Math.abs(a[i]) < min){
                minI0 = i;
                min = Math.abs(a[i]);
                p.setMin0(Math.abs(a[i]));
            }
        }
        p.setI0(minI0);
        min = 1000000000;
        for(int i = 0; i < a.length; i++){
            if(Math.abs(a[i]) < min && i != minI0){
                minI1 = i;
                min = Math.abs(a[i]);
                p.setMin1(Math.abs(a[i]));
            }
        }

        p.setI1(minI1);
        return p;
    }



    public static void main(String [] args){
        int [] a = In.readInts(args[0]);
        StdOut.println(new ClosestPair().searchMin(a));
    }
}
