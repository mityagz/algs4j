package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 12/12/15.
 */
public class Transaction implements Comparable<Transaction>{
    private  double amount = 0.0;

    // Turing 5/22/1939 11.99
    public Transaction(String t){
        String [] f = t.split("\\s+");
        String [] fd = f[1].split("/");
        amount = Double.parseDouble(fd[2]);
        StdOut.println(f[0]);
        StdOut.println(fd[2]);
    }

    public int compareTo(Transaction that){
        if(this.amount > that.amount) return 1;
        if(this.amount < that.amount) return -1;
        return 0;
    }

    public static void main(String [] args){
        new Transaction("Turing 5/22/1939 11.99");
    }
}
