package algs.ch52;

//import edu.princeton.cs.algs4.*;
//import edu.princeton.cs.algs4.TST;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/27/17.
 */
public class StringSET {
    private TST<String> st;
    private static String mark = new String("mark");

    public StringSET() {
         st = new TST();
    }

    public void add(String key) {
        st.put(key, mark);
    }

    public void delete(String key) {
        st.delete(key);
    }

    public boolean contains(String key) {
        if(st.get(key) == null)
            return false;
        else
            return true;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String i : st.keys()) {
            sb.append(" ");
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringSET st = new StringSET();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.add(key);
        }

       StdOut.println(st.toString());

        st.delete("quick");
        st.delete("she");

        StdOut.println(st.size());
        StdOut.println(st.toString());
    }
}
