package algs.ch35;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * Created by mitya on 12/24/16.
 */
public class SparseVector {
    private HashST<Integer, Double> st;
    SparseVector() {
        st = new HashST<Integer, Double>();
    }

    public void put(int i, double x) {
        st.put(i, x);
    }

    public double get(int i) {
        if(!st.contains(i)) return 0.0;
        else return st.get(i);
    }

    public double dot(double [] that) {
        double sum = 0.0;
        for(int i : st.keys()) {
                sum += this.get(i) * that[i];
        }
        return sum;
    }

    public void print() {
        int [] k = new int [st.size()];
        int j = 0;
        for(int i : this.st.keys())
            k[j++] = i;

        for(j = 0; j < k.length; j++) {
            if(k[j] != 0)
            StdOut.print(j + ":" + this.get(j) + " ");
        }
        StdOut.println();
    }

    public SparseVector sum(SparseVector that) {
        if(that == null)
            return null;
        SparseVector result = new SparseVector();
        for(int i : this.st.keys()) {
            double s = this.get(i) + that.get(i);
            if(s != 0.0)
                result.put(i, s);
        }

        for(int i : that.st.keys()) {
            double s = this.get(i) + that.get(i);
            if(s != 0.0)
                result.put(i, s);
        }
        return result;
    }

    public Iterable keys() {
        return st.keys();
    }


    public static void main(String args[]) {
        int n = StdIn.readInt();
        SparseVector[] vectors = new SparseVector[n];

        double[] x = new double[n];
        for(int i = 0; i < n; ++i) {
            x[i] = StdIn.readDouble();
            vectors[i] = new SparseVector();
        }

        for(int i = 0; i < 2 * n; ++i) {
            int u = StdRandom.uniform(0, n);
            int v = StdRandom.uniform(0, n);
            vectors[u].put(v, StdRandom.uniform());
        }

        StdOut.println("+Print: ");
        for(int i = 0; i < n; ++i) {
            vectors[i].print();
        }
        StdOut.println("-Print: ");

        StdOut.println();
        double[] b = new double[n];
        for(int i = 0; i < n; ++i) {
            b[i] = vectors[i].dot(x);
            StdOut.println(b[i]);
        }
        vectors[0].sum(vectors[1]).print();
    }
}
