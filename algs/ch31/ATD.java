package algs.ch31;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 10/29/16.
 */
public class ATD {
    public static void main(String [] args) {
        BinarySearchST<Time, Event> st = new BinarySearchST<Time, Event>(20);
        st.put(new Time(2016, 10, 19, 10, 0, 10), new Event("Houston"));
        st.put(new Time(2015, 10, 19, 11, 0, 10), new Event("New York"));
        st.put(new Time(2015, 11, 11, 12, 0, 10), new Event("Los Angeles"));

        while (!st.isEmpty()) {
            Time minTime = st.min();
            StdOut.println(minTime + " " + st.get(minTime).toString());
            st.deleteMin();
        }
    }
}



