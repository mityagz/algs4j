package algs.ch1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 3/5/16.
 */
public class LocalMatrixMin {

    private class Pair {
        int i;
        int j;
        public void setI(int ii){
            i = ii;
        }
        public void setJ(int jj){
            j = jj;
        }
        public int getI(){
            return i;
        }
        public int getJ(){
            return j;
        }
        public String toString(){
            return "i: " + i + " j: " + j;
        }
    }

    public Pair search(int [][] a){
        int li = 0, ri = a[0].length - 1;
        int dj = 0, uj = a[0].length - 1;
        int mi = 0, mj =0;
        Pair p = new Pair();
        while(li < ri && dj < uj){
            mi = li + (li + ri)/2;
            mj = dj + (dj + uj)/2;
            if(a[mi][mj] <  a[mi + 1][mj] && a[mi][mj] <  a[mi][mj + 1] && a[mi][mj] < a[mi -1][mj] && a[mi][mj] < a[mi][mj -1]){
                p.setI(mi);
                p.setJ(mj);
                return p;
            }else if(a[mi -1][mj] < a[mi + 1][mj]){
                ri = mi - 1;
                if(a[mi][mj - 1] < a[mi][mj + 1]){
                    uj = mj - 1;
                }else{
                    dj = mj + 1;
                }
            }else {
                li = mi + 1;
                if(a[mi][mj - 1] < a[mi][mj + 1]){
                    uj = mj - 1;
                }else{
                    dj = mj + 1;
                }
            }
        }

        return null;
    }

    public static void main(String [] args){
        int n = Integer.parseInt(args[0]);
        int [][] a = new int [n][n];
        int [] b = In.readInts(args[1]);
        LocalMatrixMin m = new LocalMatrixMin();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = b[i + j];
            }
        }
        Pair p = m.search(a);
        StdOut.println(p);
        StdOut.println("i: " + p.getI() + " j:" + p.getJ() + " value: " + a[p.getI()][ p.getJ()]);
        StdOut.println("i: " + p.getI() + " j:" + p.getJ() + " value: " + a[p.getI() - 1][ p.getJ()]);
        StdOut.println("i: " + p.getI() + " j:" + p.getJ() + " value: " + a[p.getI() + 1][ p.getJ()]);
        StdOut.println("i: " + p.getI() + " j:" + p.getJ() + " value: " + a[p.getI()][ p.getJ() - 1]);
        StdOut.println("i: " + p.getI() + " j:" + p.getJ() + " value: " + a[p.getI()][ p.getJ() + 1]);
    }
}
