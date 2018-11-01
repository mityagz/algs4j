package algs.ch25;

import algs.ch2.Selection;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 9/11/16.
 */
public class Version implements Comparable {
    private int v0;
    private int v1;
    private int v2;
    Version(int v0, int v1, int v2) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return v0 + "." + v1 + "." + v2;
    }

    @Override
    public int compareTo(Object v) {
        v = (Version)v;
        if(this.v0 < ((Version) v).v0) {
            return -1;
        } else if (this.v0 > ((Version) v).v0) {
            return 1;
        } else {
            if (this.v1 < ((Version) v).v1) {
                return -1;
            } else if (this.v1 > ((Version) v).v1) {
                return 1;
            } else {
                if (this.v2 < ((Version) v).v2) {
                    return -1;
                } else if (this.v2 > ((Version) v).v2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String [] args) {
        Version [] v = new Version[5];
        v[0] = new Version(1, 2, 3);
        v[1] = new Version(1, 0, 2);
        v[2] = new Version(2, 3, 5);
        v[3] = new Version(1, 3, 7);
        v[4] = new Version(1, 5, 6);


        for(int i = 0; i < v.length; i++)
            StdOut.println(v[i]);

        edu.princeton.cs.algs4.Selection.sort(v);
        StdOut.println();

        for(int i = 0; i < v.length; i++)
            StdOut.println(v[i]);
    }
}
