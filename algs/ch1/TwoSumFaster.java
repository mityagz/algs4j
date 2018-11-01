package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/4/16.
 */
public class TwoSumFaster {

    public static int count(int [] a) {
        int negN = 0;
        int negMax = 0;
        int cnt = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                if(-a[i] > negMax){
                    negMax = -a[i];
                }
            }else if(a[i] > 0){
                if(a[i] > negMax){
                    negMax = a[i];
                }
            }
        }
        int [] negA = new int[negMax + 1];
        for(int i = 0; i < n; i++) {
            if(a[i] < 0){
                negA[-a[i]] = 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(a[i] > 0) {
                if (negA[a[i]] == 1) {
                    StdOut.println(a[i]);
                    cnt++;
                }
            }
        }
        return  cnt;
    }

    public static void main(String [] args){
        int [] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
