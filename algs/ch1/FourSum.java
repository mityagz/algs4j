package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/4/16.
 */
public class FourSum {
    public static int count(int [] a) {
        int cnt = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }
    public static void main(String [] args){
        String [] a = In.readStrings(args[0]);
        int [] l = new int [a.length];
        StdOut.println(count(l));
    }
}
