package algs.ch54;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 7/16/17.
 */
public class GREP {
    public static void main(String [] args) {
        String regex = "(.*" + args[0] + ".*)";
        NFA nfa = new NFA(regex);
        while (StdIn.hasNextLine()) {
            String s = StdIn.readLine();
            StdOut.println(nfa.recognizes(s));
            if(nfa.recognizes(s))
                StdOut.println(s);
        }
    }
}
