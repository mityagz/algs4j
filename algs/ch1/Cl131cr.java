package algs.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/26/15.
 */
public class Cl131cr {
    public static void main(String [] args){
        ResizingArrayStack s;
        s = new ResizingArrayStack();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                    s.push(item);
            }else if(!s.isEmpty()){
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(В стеке отсталось " + s.size() + ")");
    }
}
