package algs.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/2/16.
 */
public class InfixToPostfix {
    InfixToPostfix(){

    }
    public static void main(String [] args){
        Stack<String> op = new Stack<String>();
        String res = "";
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/")){
                    //op.push(item);
                if(item.equals("+") || item.equals("-")){
                    if(op.peek().equals("+") || op.peek().equals("-") || op.peek().equals("*") || op.peek().equals("/")){
                        res += op.pop() + " ";
                    }
                    op.push(item);
                }else if(item.equals("*") || item.equals("/")){
                    if(op.peek().equals("*") || op.peek().equals("/")){
                        res += op.pop() + " ";
                    }
                    op.push(item);
                }
            }else if(item.equals(")")){
                    for(String o : op){
                        if(!o.equals("(")) {
                            res += op.pop() + " ";
                        }else{
                            break;
                        }
                    }
            }else if(item.equals("(")){
                op.push(item);
            }else{
                res += item + " ";
            }
        }
        for(String ops : op){
            if(!ops.equals("(")) {
                res += ops + " ";
            }
        }
        StdOut.println(res);
    }
}
