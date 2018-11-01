package algs.ch2;

import algs.ch1.Transaction;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

/**
 * Created by mitya on 7/2/16.
 */
public class SortTransaction {
    public static Transaction [] readTransaction(){
        ArrayList<Transaction> t = new ArrayList<Transaction>();
        while(!StdIn.isEmpty()){
            String str = StdIn.readString();
            t.add(new Transaction(str));
        }
        return (Transaction [])t.toArray();
    }

    public static void main(String [] args){
        Transaction [] transactions = readTransaction();
        Shell.sort(transactions);
        for(Transaction t : transactions){
            StdOut.println(t);
        }
    }
}
