package algs.ch1;

import edu.princeton.cs.algs4.*;
/**
 * Created by mitya on 1/1/16.
 */
public class Cl1315c {

    public static void main(String [] args){
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<String>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            q.enqueue(item);
        }

        int c = q.size() - k;
        int i = 0;
        for (String s : q){
            //StdOut.println(s);
           if(c == i){
               StdOut.println(s);
           }
           i++;
        }
    }
}
