package algs.ch1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/2/16.
 */
public class Cl139c {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        Stack<String> op = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item;
            /*
            Character item;
            item = StdIn.readChar();

            if (item == '*' || item == '/' || item == '+' || item == '-') {
                op.push(item + "");
            } else if (item == '(' || item == ' ') {
                //continue;
            } else if (item == ')') {
                s.push(op.pop());
            } else {
                s.push(item + "");
            }
            */

            item = StdIn.readString();

            if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-")) {
                op.push(item);
            } else if (item.equals("(")) {
                //continue;
            } else if (item.equals(")")) {
                s.push(op.pop());
            } else {
                s.push(item);
            }

        }

        for (String ss : s) {
            op.push(s.pop());
        }

        Stack<String> sb = new Stack<String>();
        for (String item : op) {
            if (item.equals("+")) {
                sb.push(" ( " + sb.pop() + " + " + sb.pop() + " ) ");
            } else if (item.equals("-")) {
                sb.push(" ( " + sb.pop() + " - " + sb.pop() + " ) ");
            } else if (item.equals("*")) {
                sb.push(" ( " + sb.pop() + " * " + sb.pop() + " ) ");
            } else {
                sb.push(item);
            }
        }

        String pres = sb.pop();
        //StdOut.println(pres);
        Character[] resArr = new Character[pres.length()];
        for (int i = 0, j = pres.length() - 1; i < pres.length(); i++, j--) {
            if (pres.charAt(j) == ')') {
                resArr[i] = '(';
            } else if (pres.charAt(j) == '(') {
                resArr[i] = ')';
            } else {
                resArr[i] = pres.charAt(j);
            }

        }
         for (int n = 0; n < resArr.length; n++) {
                StdOut.print(resArr[n]);
            }

            StdOut.println();
    }
}
