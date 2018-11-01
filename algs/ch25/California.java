package algs.ch25;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by mitya on 9/21/16.
 */
public class California {
    public static void main(String [] args) {
        Calif [] a = new Calif[5];
        a[0] = new Calif("Leland Stanford");
        a[1] = new Calif("Frederick Loewe");
        a[2] = new Calif("Robert Whitney Waterman");
        a[3] = new Calif("Hiram Warren Johnson");
        a[4] = new Calif("Earl Warren");

        for(int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }

        Arrays.sort(a);
        StdOut.println();

        for(int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
