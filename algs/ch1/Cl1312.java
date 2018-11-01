package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 1/2/16.
 */
public class Cl1312 implements Iterable{

    Cl1312(){

    }

    public static Stack<String> copy(Stack<String> ss){
        Stack<String> tds = new Stack<String>();
         Stack<String> ds = new Stack<String>();
        for(String s : ss){
            tds.push(s);
        }
        for(String s : tds){
            ds.push(tds.pop());
        }
        return ds;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String [] args){
        new Cl1312();
        Stack<String> d;
        Stack<String> s = new Stack<String>();
        for (int i = 0; i < 10; i++){
            s.push(String.valueOf(i));
        }
        for(String ss : s){
            StdOut.print(ss + " ");
        }

        StdOut.println();
        d = Cl1312.copy(s);

        for(String ss : d){
            StdOut.print(ss + " ");
        }
        StdOut.println();
        StdOut.printf("s: " + s + " d:" + d);
        StdOut.println();
        if(!s.equals(d)){
            StdOut.println("Stacks aren't equal");
        }
    }
}
