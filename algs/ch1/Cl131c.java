package algs.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/25/15.
 */
public class Cl131c {
    public static void main(String [] args){
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(10);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                if(!s.isFull()) {
                    s.push(item);
                }else{
                    throw new NullPointerException("Array is too small");
                }
            }else if(!s.isEmpty()){
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(В стеке отсталось " + s.size() + ")");
    }
}

