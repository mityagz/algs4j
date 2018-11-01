package algs.ch33;

import edu.princeton.cs.algs4.StdIn;

/**
 * Created by mitya on 12/10/16.
 */

// 3.3.16

public class InsRBT {

    public static void main(String [] args) {
        int n = StdIn.readInt();
        RedBlackBST0<String, Integer> bst = new RedBlackBST0<String, Integer>();
        for(int i = 0; i < n; i++) {
            String s = StdIn.readString();
            bst.put(s, i);
        }
        bst.draw();
    }
}
