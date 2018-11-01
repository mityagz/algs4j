package algs.ch51;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 4/15/17.
 */
public class DistCalc {
    public static void main(String [] args) {
        int n = 0;
        int [] count;
        Lerner [] a = new Lerner[1000];
        Lerner [] aux = new Lerner[1000];

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            Integer section = StdIn.readInt();
            a[n] = new Lerner(name, section);
            n++;
        }

        count = new int[n + 1];

        for(int i = 0; i < n; i++)
            StdOut.println(a[i]);

        for(int i = 0; i < n; i++)
            count[a[i].key() + 1]++;

        StdOut.println("--------------------------");

        for(int i = 0; i < n; i++)
            count[i + 1] += count[i];

        for(int i = 0; i < n; i++)
            aux[count[a[i].key()]++] = a[i];

        for(int i = 0; i <= n; i++)
            a[i] = aux[i];

        for(int i = 0; i < n; i++)
            StdOut.println(a[i]);
    }
}
