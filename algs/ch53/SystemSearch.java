package algs.ch53;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 6/3/17.
 */
public class SystemSearch {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String text  = "a";
        String query = "a";
        for (int i = 0; i < n; i++) {
            text  = text  + text;
            query = query + query;
        }
        text = text + text;
        query = query + "b";
        StdOut.println(text.indexOf(query));
    }

}
