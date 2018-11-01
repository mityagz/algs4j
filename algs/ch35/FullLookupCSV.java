package algs.ch35;

import algs.ch25.StrStr;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;

/**
 * Created by mitya on 1/3/17.
 */
public class FullLookupCSV {
    //HashMap
    public static void main(String [] args) {
        String  s = StdIn.readLine();
        String [] columns = s.split(",");
        int n = columns.length;
        HashMap<String, Queue<String []>> [] maps = new HashMap[columns.length];

        for(int i = 0; i < n; i++)
            maps[i] = new HashMap<String, Queue<String[]>>();

        for(String [] ss = columns;!StdIn.isEmpty(); ss = StdIn.readLine().split(",")) {
            for(int i = 0; i < n; i++) {
                if(!maps[i].containsKey(columns[i]))
                    maps[i].put(columns[i], new Queue<String[]>());
                maps[i].get(columns[i]).enqueue(columns);
            }
        }
    }
}
