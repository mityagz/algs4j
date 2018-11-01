package algs.ch32;


import edu.princeton.cs.algs4.StdOut;


/**
 * Created by mitya on 11/26/16.
 */
public class ThreadedST<Key extends Comparable<Key>, Value> extends BST0<Key, Value>{
    private TNode root = null;
    private class TNode extends Node {
        private TNode pred, succ;
        public TNode (Key key, Value val, int n) {
            super(key, val, n);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(TNode x) {
        if(x == null) return 0;
        else return x.n();
    }

    public Key prev(Key key) {
        return null;
    }

    public Key next(Key key) {
        return null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private TNode put(TNode x, Key key, Value val) {
        if(x == null) {
            TNode t = new TNode(key, val, 1);
            return t;
        }

        int c = key.compareTo((Key) x.key);
        if(c < 0) x.left = put((TNode)x.left, key, val);
        else if(c > 0) x.right = put((TNode)x.right, key, val);
        else x.val = val;
        x.n = size((TNode)x.left) + size((TNode)x.right) + 1;
        return x;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private TNode deleteMin(TNode x) {
        if(x.left == null) return (TNode)x.right;
        x.left = deleteMin((TNode)x.left);
        x.n = size((TNode)x.left) + size((TNode)x.right) + 1;
        return x;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private TNode deleteMax(TNode x) {
        if(x.right == null) return (TNode)x.left;
        x.right = deleteMax((TNode)x.right);
        x.n = size((TNode)x.left) + size((TNode)x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private TNode delete(TNode x, Key key) {
        if(x == null) return null;
        int c = key.compareTo((Key)x.key);
        if(c < 0) x.left = delete((TNode)x.left, key);
        else if(c > 0) x.right = delete((TNode)x.right, key);
        else if (c == 0) {
            if(x.right == null) return (TNode)x.left;
            if(x.left == null) return (TNode)x.right;
            Node t = x;
            //x = min(t.right);
            x.right = deleteMin((TNode)t.right);
            x.left = t.left;
        }
        x.n = size((TNode)x.left) + size((TNode)x.right) + 1;
        return x;
    }

    public static void main(String [] args) {
        ThreadedST<String, Integer> bst = new ThreadedST<String, Integer>();
        bst.put("Q", 1);
        bst.put("W", 2);
        bst.put("E", 3);
        bst.put("R", 4);
        bst.put("T", 5);
        bst.put("Y", 6);
        bst.put("U", 7);
        bst.put("A", 8);
        bst.put("B", 9);
        bst.put("C", 10);
        bst.put("D", 11);

        //StdOut.println(bst.select(bst.rank("W")) + " " + bst.rank("W")  + " " + bst.get("W"));
        //bst.delete("E");

        StdOut.println("min:max " + bst.min() + " " + bst.max());
        StdOut.println("floor:ceiling " + bst.floor("F") + " " + bst.ceiling("M"));
        StdOut.println("rank: " + bst.rank("W"));


        Iterable i = bst.keys("R", "T");

        for(Object s : i) {
            StdOut.println((String)s);
        }

        StdOut.println(bst.height());
        StdOut.println();
    }
}
