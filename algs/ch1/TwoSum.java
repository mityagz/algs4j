package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/4/16.
 */
public class TwoSum {
    public static int count(int [] a){
        int cnt = 0;
        int n = a.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                    if(a[i] + a[j] == 0){
                        cnt++;
                }
            }
        }

        return cnt;
    }

    public static void main(String [] args){
        int [] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
