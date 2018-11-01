package algs.ch32;

/**
 * Created by mitya on 11/27/16.
 */
public class Node<Key extends Comparable<Key>, Value> {
    public Key key;
    public Value val;
    public Node left, right;
    public int n;

    public Node(Key key, Value val, int n) {
        this.key = key;
        this.val = val;
        this.n = n;
    }

    public int n() { return n;}
}

