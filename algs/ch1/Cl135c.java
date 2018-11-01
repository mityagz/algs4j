package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/27/15.
 */
public class Cl135c {

    public static void main(String [] args){
        int n = Integer.parseInt(args[0]);
        Stack<Integer> stack = new Stack<Integer>();
        while(n > 0){
            stack.push(n % 2);
            n = n / 2;
        }
        for(int i : stack){
            StdOut.print(i + " ");
        }
        StdOut.println();
        stack.push(100500);
        StdOut.println(stack.peek() + "peek");
        StdOut.println(stack.peek() + "peek");
    }
}
