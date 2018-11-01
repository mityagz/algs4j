package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 12/12/15.
 */
public class Cl1215c {
    Cl1215c(){

    }

    public static int [] readInts(String name){
        In in = new In(name);
        String input = in.readAll();
        String [] words = input.split("\\s+");
        int [] ints = new int [words.length];
        for(int i = 0; i < ints.length; i++){
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }

    public static void main(String [] args){
        int [] ints = readInts(args[0]);
        Arrays.sort(ints);
        for(int i = 0; i < ints.length; i++ ){
            StdOut.println(ints[i]);
        }
    }
}
