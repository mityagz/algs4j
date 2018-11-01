package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 11/26/15.
 */
public class ex1121 {
    public static void main(String [] args){
        int [] a = new int [3];
        String str;
        String [] str0 = new String [3];
        while(!StdIn.isEmpty()){
            str = StdIn.readLine();
            str0 = str.split(" ");
            StdOut.println(str0[0] + " " + str0[1] + " " + str0[2] + " " + Double.parseDouble(str0[1])/Double.parseDouble(str0[2]));
        }

    }
}
