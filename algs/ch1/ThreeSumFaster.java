package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/4/16.
 */
public class ThreeSumFaster {

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
                negA[-a[i]]++;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                    if((a[i]  +  a[j] ) > 0 && (a[i] + a[j] <  negMax)) {
                        if (negA[a[i] + a[j]] > 0) {
                            cnt++;
                            negA[a[i] + a[j]]--;
                            //StdOut.println("1: " + a[i] + " 2: " + a[j] + " 3: " + (a[i] + a[j]));
                        }
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
