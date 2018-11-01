package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 2/22/16.
 */
public class StaticSETofInts {
    private int [] a;
    StaticSETofInts(int [] keys){
        a = new int[keys.length];
        for(int i = 0; i < keys.length; i++)
            a[i] = keys[i];
        Arrays.sort(a);
        for(int i = 0; i < a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public boolean contains(int key){
        return rank(key) !=  0;
    }

    /*
    private int rank(int key){
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(key < a[mid]) hi = mid - 1;
            else if(key > a[mid]) lo = lo + 1;
            else return mid;
        }
        return -1;
    }
    */

    private int rank(int key){
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(a[lo] == key){
                return lo;
            }
            if(a[mid] == key){
                if(lo + 1 == mid){
                    return mid;
                }else{
                    hi = mid + 1;
                }
            } else if(key < a[mid]){
                hi = mid - 1;
            } else if(key > a[mid]){
                lo = lo + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int howMany(int key){
        int cnt = 0;
        int index = rank(key);
        for(int i = index; i < a.length; i++){
            if(a[i] == key){
                cnt++;
            }else{
                return cnt;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        int [] a = In.readInts(args[0]);
        StaticSETofInts s = new StaticSETofInts(a);
        StdOut.println("Index of " +args[1] + " key: " + s.rank(Integer.parseInt(args[1])));
        StdOut.println("How many key values " + args[1] + " we have: " + s.howMany(Integer.parseInt(args[1])));
    }
}
