package algs.ch25;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

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
//   be = nBound(be, beNew);
// }

/**
 * Created by mitya on 10/7/16.
 */
public class Vector2<Type extends Comparable> {
    Comparable a[][];
    Comparable[] m;

    Vector2() {
        //a = new Integer[][]{{1, 4, 2, 7}, {1, 4, 1, 3}, {2, 5, 23, 1}, {1, 5, 4, 6}, {2, 5, 1, 2}};
        a = new Integer[][]{{1, 1, 2, 7}, {1, 4, 1, 3}, {2, 5, 23, 1}, {1, 4, 4, 6}, {2, 5, 1, 2}};
    }

    Vector2(int il, int jl) {
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
        Integer [] beN = null;
        m = new Comparable[a.length];

        colGen(j);
        index = Insertion2.indirectSort(m);
        map(0, index);
        colGen(j);
        be = boundEq(m);

        for(Integer i : be)
            StdOut.print(i + " ");
            StdOut.println();

        for (j = 1; j < a[0].length; j++) {

            colGen(j);

            for (int n = 0; be[n] != -1; n += 2) {
                index = Insertion2.indirectSort(m, be[n], be[n + 1]);
                map(0, index, be[n], be[n + 1]);
            }

             colGen(j);
             beN = boundEq(m);
             be = nBound(be, beN);
             //be = beN;
        }
    }

    /**
     *
     * @param be    old boundary
     * @param beN   new boundary
     * @return      intersection boundary
     */
    public Integer [] nBound(Integer [] be, Integer [] beN) {
        Integer [] r = new Integer[2*be.length];
        boolean f = false;
        int k = 0;
        for (int i = 0; i < be.length && be[i] != -1; i += 2) {
            for (int j = 0; j < beN.length && beN[j] != -1; j += 2) {
                StdOut.print("be[" + i + "] " + be[i] + " " + be[i + 1] + " : beN[" + j + "] " + beN[j] + " " + beN[j + 1]);
                if (((be[i] <= beN[j]) && (beN[j] <= be[i + 1])) && ((be[i + 1] >= be[j + 1]))) {
                    StdOut.println("cond 1");
                    r[k] = beN[j];
                    r[k + 1] = beN[j + 1]; k += 2;
                } else if (((be[i] <= beN[j]) && (be[i + 1] >= beN[j])) && (be[i + 1] <= beN[j + 1])) {
                    StdOut.println("cond 2");
                    r[k] = beN[j];
                    r[k + 1] = be[j + 1]; k += 2;
                } else if ((be[i] >= beN[j]) && ((be[i] <= beN[j + 1]) && (be[i + 1] >= beN[j + 1]))) {
                    StdOut.println("cond 3");
                    r[k] = be[i];
                    r[k + 1] = beN[j + 1]; k += 2;
                } else if (((be[i] >= beN[j]) && (be[i] <= beN[j +1])) && ((be[i + 1] >= beN[j])) && (be[j +1] <= beN[j + 1])) {
                    StdOut.println("cond 4");
                    r[k] = be[i];
                    r[k + 1] = be[i + 1]; k += 2;
                }
                StdOut.println();
            }
        }
            r[k] = -1;
        /*
        for(Integer l : r)
            StdOut.print(l + " ");
        */

        StdOut.println();
        return r;
    }

    public void colGen(int j) {
        for (int i = 0; i < m.length; i++)
                m[i] = a[i][j];
    }

    public void map(Integer i, Integer[] index) {
        map(i, index, 0, a.length - 1);
    }

    public void map(Integer i, Integer[] index, Integer b0, Integer b1) {
        Comparable[] t;
        Comparable[][] z = Arrays.copyOf(a, a.length);
        for (int k = b0; k <= b1; k++) {
            z[k] = a[index[k]];
        }
        a = z;
    }

    public Integer[] boundEq(Comparable[] m) {
        Integer[] r = new Integer[2 * m.length];
        boolean inRange = false;
        int n = 0;
        for (int i = 0; i < r.length; i++)
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
        Vector2 v = new Vector2();
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
