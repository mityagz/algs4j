package algs.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;



/**
 * Created by mitya on 1/2/16.
 */
public class EvaluatePostfix {

    public static void main(String [] args){
        Stack<Integer> operand = new Stack<Integer>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(item.equals("*") || item.equals("/") || item.equals("-") || item.equals("+")){
                if(item.equals("*"))
                    operand.push(operand.pop() * operand.pop());
                if(item.equals("/"))
                    operand.push(operand.pop() / operand.pop());
                if(item.equals("+"))
                    operand.push(operand.pop() + operand.pop());
                if(item.equals("-"))
                    operand.push(operand.pop() - operand.pop());
            }else{
                operand.push(Integer.parseInt(item));
            }
        }
        StdOut.println(operand.pop());
    }
}
