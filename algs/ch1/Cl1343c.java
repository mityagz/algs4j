package algs.ch1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * Created by mitya on 1/30/16.
 */
public class Cl1343c {

    Cl1343c(){

    }

    public static  Queue listR(String p, Stack s, Stack d){
        File f = new File(p);
        Queue<String> q = new Queue<String>();
        String [] list;
        list = f.list();

        for (int i = 0; i < list.length; i++){
            File nf = new File(f + "/" + list[i]);
            if(nf.isDirectory()){
                listR(f + "/" + list[i], s, d);
                q.enqueue(nf.getName());
            }else if(nf.isFile()){
                q.enqueue(list[i]);
            }
        }
        d.push(p);
        s.push(q);
        return q;
    }

    public static void main(String [] args){
        if(args.length == 0){StdOut.println("No args, exit."); return;}
        String rootP = args[0];
        Stack s = new Stack<Queue<String>>();
        Stack d = new Stack<String>();

        String out = "";

        listR(rootP, s, d);

        while(!s.isEmpty()){
            Queue q = (Queue)s.pop();
            StdOut.println("Dir: " + d.pop());
            out = "     " + out;
            for(Object c : q){
                StdOut.println("F: " + out + (String)c);
            }
        }
    }
}
