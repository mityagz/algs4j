package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings{
    private String [] a;
    private int n;
    private int c;

    FixedCapacityStackOfStrings(int cap){
        c = cap;
        a = new String [cap];
    }

    public boolean isEmpty(){
        if(n == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return n;
    }

    public void push(String item){
        a[n++] = item;
        //StdOut.println("N: " + n + "Item: " + item);
    }

    public String pop(){
        //int t = n;
        n--;
        return a[n];
    }

    public boolean isFull(){
        if(n == c){
            return true;
        }
        return false;
    }
}
