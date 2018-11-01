package algs.ch1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by mitya on 3/17/16.
 */
public class HotCold {
    int rnd;
    int prev = 100;

    HotCold() {
        rnd = StdRandom.uniform(0, 99);
        StdOut.println("Random number is: " + rnd);
    }

    public boolean isHot(int s) {
        int p = prev;
        prev = s;
        StdOut.println("Diff: " + Math.abs(rnd - s) + " " +  Math.abs(rnd - p));
        if(Math.abs(rnd - s) < Math.abs(rnd - p)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isMatch(int n) {
        if(rnd == n){
            return true;
        }
        return false;
    }

    public static void main(String [] args){
        HotCold hc = new HotCold();
        int i = 0, n = 100;
        int mid;
        int l = 0;
        int r = n;

        while(i < n){
            StdOut.println("isHot ?: " + hc.isHot(i) + " i: " + i);
            if(hc.isMatch(i)){
                StdOut.println("Number is found: " + i);
                break;
            }
            i++;
        }

        /*
        while( l < r ){
            mid = l + (r - l)/2;
            if(hc.isMatch(mid)){
                StdOut.println("Num is found! Num is: " + mid);
                break;
            }else if(hc.isHot(mid)){
                    r = mid;
            }else{
                    l = mid;
            }
        }
        */
    }
}
