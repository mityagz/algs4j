package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/5/16.
 */
public class LocalArrayMin {

    public static int search(int [] a) {
        int l = 0;
        int r = a.length;
        int m = 0;
        while (l < r) {
            m = l + (r + l)/2;
            if(a[m] < a[m - 1] && a[m] < a[m + 1]){
                return m;
            }else if(a[m -1] < a[m + 1]){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return -1;
    }


    public static void main(String [] args){
        int [] a = In.readInts(args[0]);
        StdOut.println(search(a));
    }
}
