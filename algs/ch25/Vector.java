package algs.ch25;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import sun.awt.dnd.SunDropTargetContextPeer;

import java.io.File;
import java.util.Arrays;

// index = indirectSort(m[0], 0, m.length)
// map(0, index);
// be = boundEq(m[0]);
// for(m[1] < a.length) {
//  for (int n = 0; be[n] != -1; n += 2) {
//       index = Insertion2.indirectSort(m, be[n], be[n + 1]);
//       map(0, index, be[n], be[n + 1]);
//   }
//   beNew = boundEq(m[i]);
//   be = nbound(be, beNew);
// }

/**
 * Created by mitya on 10/7/16.
 */
public class Vector<Type extends Comparable> {
    Comparable a[][];

    Vector() {
        //a = new Integer[][]{{1, 4, 2, 7}, {1, 4, 1, 3}, {2, 5, 23, 1}, {1, 5, 4, 6}, {2, 5, 1, 2}};
        a = new Integer[][]{{1, 4, 2, 7}, {1, 4, 1, 3}, {2, 5, 23, 1}, {1, 1, 4, 6}, {2, 5, 1, 2}};
    }

    Vector(int il, int jl) {
        a = new Integer[il][jl];
        for (int i = 0; i < il; i++)
            a[i] = new Integer[jl];

        for (int i = 0; i < il; i++)
            for (int j = 0; j < jl; j++)
                a[i][j] = StdRandom.uniform(0, 99);
    }

    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                r += a[i][j] + " ";
            }
            r += '\n';
        }
        return r;
    }

    public void multiSort() {
        int j = 0;
        Integer[] index;
        Integer[] be = null;
        Comparable[] m = new Comparable[a.length];
        Comparable[] mPrev = new Comparable[a.length];
        StdOut.println("m[0]----------------------------");
        StdOut.print("m: ");
        for (int i = 0; i < m.length; i++) {
            m[i] = a[i][j];
            StdOut.print(m[i] + " ");
        }
        index = Insertion2.indirectSort(m);
        map(0, index);
        StdOut.println("!m[0]---------------------------");
        StdOut.println();


        //
        for (j = 1; j < a[0].length; j++) {
            for (int i = 0; i < m.length; i++) {
                mPrev[i] = a[i][j - 1];
            }
            be = boundEq(mPrev);
            StdOut.println("m[" + j + "]:-------------------");
            StdOut.print("m:");
            for (int i = 0; i < a.length; i++) {
                m[i] = a[i][j];
                StdOut.print(m[i] + " ");
            }
            //
            StdOut.println();
            for (int t = 0; t < be.length; t++) {
                StdOut.print(be[t] + " ");
            }

            for (int n = 0; be[n] != -1; n += 2) {
                index = Insertion2.indirectSort(m, be[n], be[n + 1]);
                map(0, index, be[n], be[n + 1]);
            }
            StdOut.println();
        }
    }

    public void map(Integer i, Integer[] index) {
        map(i, index, 0, a.length - 1);
    }

    public void map(Integer i, Integer[] index, Integer b0, Integer b1) {
        Comparable[] t;
        Comparable[][] z = Arrays.copyOf(a, a.length);
        for (int k = b0; k <= b1; k++) {
            //StdOut.println(k + " " + index[k]);
            z[k] = a[index[k]];
            //StdOut.println(k + " " +a[index[k]]);
        }
        a = z;

        StdOut.println();
        for (int u = 0; u < a.length; u++) {
            for (int y = 0; y < a[0].length; y++) {
                StdOut.print(a[u][y] + " ");
            }
            StdOut.println();
        }

        StdOut.println("b0:" + b0 + " b1:" + b1);
        StdOut.print("index: ");
        for (int x = 0; x < index.length; x++) {
            StdOut.print(index[x] + " ");
        }
        StdOut.println();
    }

    public Integer[] boundEq(Comparable[] m) {
        Integer[] r = new Integer[m.length];
        boolean inRange = false;
        int n = 0;
        for (int i = 0; i < m.length; i++)
            r[i] = -1;
        int i;
        for (i = 1; i < m.length; i++) {
            if (m[i] == m[i - 1]) {
                if (!inRange) {
                    r[n++] = i - 1;
                    inRange = true;
                }
            } else {
                if (inRange) {
                    r[n++] = i - 1;
                    inRange = false;
                }
            }
        }
        if (inRange)
            r[n++] = i - 1;

        return r;
    }

    public static void main(String[] args) {
        Vector v = new Vector();
        StdOut.println(v);
        v.multiSort();
        StdOut.println(v);

        Integer[] b = {4, 4, 5, 5, 5};
        Integer[] eq = v.boundEq(b);
        for (int i = 0; i < b.length; i++) {
            StdOut.print(eq[i] + " ");
        }
    }
}
