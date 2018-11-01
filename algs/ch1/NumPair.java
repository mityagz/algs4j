package algs.ch1;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by mitya on 2/22/16.
 */
public class NumPair {

    public static int count(int [] a){
        int cnt = 0;
        int n = a.length;
        int index;
        Arrays.sort(a);
        for(int i = 0; i < n; i++) {
            index = 0;
            /*
            StdOut.println(a[i] + " " + edu.princeton.cs.algs4.BinarySearch.indexOf(a, a[i]));
            if ((index = edu.princeton.cs.algs4.BinarySearch.indexOf(a, a[i])) > i) {
                index = BinarySearch.indexOf(a, a[i]);
                StdOut.println("a["+ i + "] = " + a[i] + " index: " + index);
                //cnt++;
            }
            */
            for(int j = i + 1; j < n; j++){
                if(a[i] == a[j])
                    cnt++;
            }
        }

        cnt = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i - 1] == a[i] ){
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String [] args){
        int [] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
