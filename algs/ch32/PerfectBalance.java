package algs.ch32;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 11/26/16.
 */
public class PerfectBalance {
    static int cnt = 0;
    BST0 bst;
    PerfectBalance(Comparable [] obj) {
        bst = new BST0();
        mid(bst, obj, 0, obj.length - 1);
    }

    public BST0 getBST() {
        return bst;
    }

    private void mid(BST0 b, Comparable [] c, int lo, int hi) {
        if(lo > hi) return;
        int mid = lo + (hi - lo)/2;
        //StdOut.print(c[mid] + " " + mid + " " + cnt + ":");
        StdOut.print(c[mid] + " ");
        b.put(c[mid], cnt++);
        mid(b, c, lo, mid - 1);
        mid(b, c, mid + 1, hi);
    }

    public static void main(String [] args) {

        //String [] str = {"Q", "W", "E", "R", "T", "Y", "U", "A", "B", "C", "D"};
        String [] str = {"P", "E", "R", "F", "C", "T", "B", "I", "N", "A", "R", "Y", "S", "R", "H"};

        Merge.sort(str);

        PerfectBalance pb = new PerfectBalance(str);
        BST0 bst = pb.getBST();

        StdOut.println();

        for(Object o : bst.keys()) {
            StdOut.print(o + " ");
        }

        StdOut.println();

        StdOut.println("min:max " + bst.min() + " " + bst.max());
    }
}
