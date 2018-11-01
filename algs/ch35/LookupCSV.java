package algs.ch35;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by mitya on 1/1/17.
 */
public class LookupCSV {
    public static void main(String [] args) {
        In in = new In(args[0]);
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);
        HashMap<String, Queue<String>> st = new HashMap<String, Queue<String>>();
        while(in.hasNextLine()) {
            String line = in.readLine();
            String [] token = line.split(",");
            String key = token[0];
            if(st.get(key) == null) st.put(key, new Queue<String>());
            for(int i = 1; i < token.length; i++) {
                st.get(key).enqueue(token[i]);
                StdOut.print(token[0] + " " + token[i] + " ");
            }
            StdOut.println();
        }

        while (!StdIn.isEmpty()) {
            String query = StdIn.readString();
            StdOut.print("Key : Value " + query + " : ");
            if(st.containsKey(query)) {
                //for (String s : st.get(query))
                for( Iterator i = st.get(query).iterator(); i.hasNext(); )
                    StdOut.print(i.next() + " ");
                StdOut.println();
            }
        }
    }
}
