package algs.ch1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/26/15.
 */
public class Parentheses {
    public static void main(String [] args){
        Stack s = new Stack<Character>();
        Character p_item;
        while(!StdIn.isEmpty()){
            Character item = StdIn.readChar();
            StdOut.println(item);
            if(item == '(' || item == '[' || item == '{' || item == '<'){
                s.push(item);
            }else if(item == ')' || item == ']' || item == '}' || item == '>'){
                p_item = (Character)s.pop();
                if((item == ')' && p_item != '(') || (item == ']' && p_item != '[') || (item == '}' && p_item != '{')){
                    StdOut.println("False!!!");
                    return;
                }
            }
        }
        StdOut.println("True!!!");
    }
}
