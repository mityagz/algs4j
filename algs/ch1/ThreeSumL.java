package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/21/16.
 */
public class ThreeSumL {
    public static long count(long [] a){
        long cnt = 0;
        int n = a.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    if(a[i] + a[j] + a[k] == 0){
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String [] args){
        String [] a = In.readStrings(args[0]);
        long [] l = new long [a.length];
        for(int i = 0; i < l.length; i++){
            l[i] = Long.parseLong(a[i]);
        }
        StdOut.println(count(l));
    }
}
