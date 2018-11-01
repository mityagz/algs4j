package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 2/22/16.
 */
public class ArrayConcat {

    public static void concat(int [] a, int [] b){
        int ia = 0, ib = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i < a.length || i < b.length; i++) {
            if (a[ia] <= b[ib]) {
                StdOut.println(a[ia]);
                ia++;
            } else {
                StdOut.println(b[ib]);
                ib++;
            }
        }
        if(ia < a.length) {
            for (;ia < a.length; ia++) {
                 StdOut.println(a[ia]);
            }
        }else{
            for (;ib < b.length; ib++) {
                 StdOut.println(a[ib]);
            }
        }
    }

    public static void main(String  [] args) {
        int[] a = In.readInts(args[0]);
        int[] b = In.readInts(args[1]);
        concat(a, b);
    }
}
