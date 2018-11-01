package algs.ch35;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

/**
 * Created by mitya on 1/2/17.
 */
public class Concordance {
    public static void main(String [] args) {
        int count = 1;
        HashMap<String, Queue<Integer>> map = new HashMap<String, Queue<Integer>>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            if(!map.containsKey(s)) map.put(s, new Queue<Integer>());
            map.get(s).enqueue(count);
            count++;
        }

        for(String s : map.keySet())
            StdOut.println(s + " " + map.get(s));
    }
}
