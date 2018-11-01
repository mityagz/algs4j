package algs.ch35;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by mitya on 1/3/17.
 */
public class SparseMatrix {
    private HashMap<Integer, SparseVector> rows;
    private HashMap<Integer, SparseVector> columns;

    public SparseMatrix() {
        rows = new HashMap<Integer, SparseVector>();
        columns = new HashMap<Integer, SparseVector>();
    }

    public void put(int x, int y, double value) {
        if(value == 0)
            return;
        if(!rows.containsKey(x))
            rows.put(x, new SparseVector());
        rows.get(x).put(y, value);
        if(!columns.containsKey(y))
            columns.put(y, new SparseVector());
        columns.get(y).put(x, value);
    }

    public double get(int x, int y) {
        if(rows.containsKey(x))
            return rows.get(x).get(y);
        return 0;
    }

    public SparseMatrix sum(SparseMatrix that) {
        SparseMatrix result = new SparseMatrix();
        for(int i : this.rows.keySet()) {
            SparseVector vector = this.rows.get(i).sum(that.rows.get(i));
            result.rows.put(i, vector);
        }
        for(int i : that.rows.keySet()) {
            SparseVector vector = that.rows.get(i).sum(this.rows.get(i));
            result.rows.put(i, vector);
        }

        result.row2column();
        return result;
    }

    private void row2column() {
        for(int i : rows.keySet()) {
            SparseVector vector = rows.get(i);
            for(Object j : vector.keys()) {
                if(!columns.containsKey(j))
                    columns.put((Integer)j, new SparseVector());
                columns.get(j).put(i, vector.get((Integer)j));
            }
        }
    }
    private void column2row() {
        for(int j : columns.keySet()) {
            SparseVector vector = columns.get(j);
            for(Object i : vector.keys()) {
                if(!rows.containsKey(i))
                    rows.put((Integer)i, new SparseVector());
                rows.get(i).put(j, vector.get((Integer)i));
            }
        }
    }

    public SparseMatrix multi(SparseMatrix that) {
        SparseMatrix result = new SparseMatrix();
        for(int i : rows.keySet()) {
            for(int j: that.columns.keySet());
                //result.put(i, j, rows.get(i).dot(that.columns.get(j)));
        }
        return result;
    }
    public void print() {
        for(int i : rows.keySet()) {
            StdOut.print(i + "[ ");
            rows.get(i).print();
        }
        StdOut.println();

        for(int j : columns.keySet()) {
            StdOut.print(j + "[ ");
            columns.get(j).print();
        }
        StdOut.println();
    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        SparseMatrix matrix1 = new SparseMatrix();
        SparseMatrix matrix2 = new SparseMatrix();
        for(int i = 0 ; i  < N; ++i) {
            int x = StdRandom.uniform(N);
            int y = StdRandom.uniform(N);
            matrix1.put(x, y, StdRandom.uniform());
        }
        for(int i = 0 ; i  < N; ++i) {
            int x = StdRandom.uniform(N);
            int y = StdRandom.uniform(N);
            matrix2.put(x, y, StdRandom.uniform());
        }

        matrix1.print();
        matrix2.print();
        //(matric1.sum(matric2)).print();
        (matrix1.multi(matrix2)).print();
}
}
