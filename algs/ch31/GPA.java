package algs.ch31;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by mitya on 10/22/16.
 */
public class GPA {
    public static void main(String [] args) {
        ST st = new BinarySearchST(10);
        st.put("A+", 4.33);
        st.put("A", 4.00);
        st.put("A-", 3.67);
        st.put("B+", 3.33);
        st.put("B", 3.00);
        st.put("B-", 2.67);
        st.put("C+", 2.33);
        st.put("C", 2.00);
        st.put("C-", 1.67);
        st.put("D", 1.00);
        st.put("F-", 0.00);

        int n;
        double s = 0.0;
        for(n = 0; !StdIn.isEmpty(); n++) {
            String g = StdIn.readString();
            double v = (Double) st.get(g);
            s += v;
        }
        StdOut.println("Average gpa: " + s/n);
    }
}
