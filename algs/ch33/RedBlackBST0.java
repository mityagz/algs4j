package algs.ch33;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/**
 * Created by mitya on 12/8/16.
 */
public class RedBlackBST0<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int size;
        private int height;
        private double deep;

        Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    public RedBlackBST0() {
    }

    private boolean isRED(Node x) {
        if(x == null) return false;
        if(x.color == RED) return RED;
        return false;
    }

    private int size(Node x) {
        if(x == null) return 0;
        return x.size;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        if(root == null) return true;
        else return false;
    }

    public Value get(Key key) {
        if(key == null) return null;
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while(x != null) {
            int c = key.compareTo(x.key);
            if(c < 0) x = x.left;
            else if(c > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public boolean contains(Key key) {
        if(get(key) != null) return true;
        return false;
    }

    public void put(Key key, Value val) {
        if(key == null) throw new IllegalArgumentException("first argument to put() is null");
        if(val == null) {
            delete(key);
            return;
        }

        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if(h == null) return new Node(key, val, RED, 1);;
        int c = key.compareTo(h.key);
        if(c < 0) h.left = put(h.left, key, val);
        else if(c > 0) h.right = put(h.right, key, val);
        else h.val = val;
        if(isRED(h.right) && !isRED(h.left)) h = rotateLeft(h);
        if(isRED(h.left) && isRED(h.left.left)) h = rotateRight(h);
        if(isRED(h.left)  && isRED(h.right)) flipColor(h);
        h.size = 1 + size(h.left) + size(h.right);
        h.height = Math.max(height1(h.left), height1(h.right)) + 1;
        h.deep = deep(h.left) + deep(h.right) + size(h) - 1;
        return h;
    }

    private int height(Node x) {
        if(x == null) return 0;
        if(x.left == null && x.right == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    private int height1(Node x) {
        if(x == null) return 0;
        else return x.height;
    }

     private double deep(Node x) {
        if(x == null) return 0;
        else return x.deep;
    }

    private double deepRec(Node x) {
        if(x == null) return 0.0;
        else return deep(x.left) + deep(x.right) + size(x) - 1;
    }

    public int height1() {
        return height1(root);
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = RED;
    }

    public void deleteMin() {
        if(!isRED(root.left) && !isRED(root.right))
            root.color = RED;

        root = deleteMin(root);
        if(!isEmpty()) root.color = BLACK;
    }

    private Node deleteMin(Node h) {
        if(h.left == null) return null;
        if(!isRED(h.left) && !isRED(h.left.left))
            h = moveRedLeft(h);
        h.left = deleteMin(h.left);
        return  balance(h);
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");
        if(!isRED(root.left) && !isRED(root.right))
            root.color = RED;

        root = deleteMax(root);
        if(!isEmpty()) root.color = BLACK;
    }

    private Node deleteMax(Node h) {
        if(isRED(h.left))
            h = rotateRight(h);
        if(h.right == null) return null;
        if(!isRED(h.right) && !isRED(h.right.left))
            h = moveRedRight(h);
        h.right = deleteMax(h.right);
        return balance(h);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        if (!isRED(root.left) && !isRED(root.right))
            root.color = RED;

        root = delete(root, key);
        if (!isEmpty()) root.color = BLACK;
    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0)  {
            if (!isRED(h.left) && !isRED(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        }
        else {
            if (isRED(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRED(h.right) && !isRED(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.val = x.val;
                h.right = deleteMin(h.right);
            }
            else h.right = delete(h.right, key);
        }
        return balance(h);

    }

    private Node moveRedLeft(Node h) {
        flipColor(h);
        if(isRED(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColor(h);
        }
        return h;
    }

    private Node moveRedRight(Node h) {
        //flipColor(h);
        if(isRED(h.left)) {
            h = rotateRight(h);
            //flipColor(h);
        }
        return h;
    }

    private Node balance(Node h) {
        if (isRED(h.right))                      h = rotateLeft(h);
        if (isRED(h.left) && isRED(h.left.left)) h = rotateRight(h);
        if (isRED(h.left) && isRED(h.right))     flipColor(h);

        h.size = size(h.left) + size(h.right) + 1;
        return h;
    }

    public boolean is23() {
        return is23(root);
    }

    private boolean is23(Node h) {
        if(h == null) return true;
        if(isRED(h.left.left) && isRED(h.right))
            return false;
        return isRED(h.left) && isRED(h.right);
    }


    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    }

    private Node min(Node x) {
        if(x.left == null) return x;
        else  return min(x.left);
    }

    private Node max(Node x) {
        if(x.right == null) return x;
        else return max(x.right);
    }

    public Iterable<Key> keys() {
        if (isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");
        Queue<Key> q = new Queue<Key>();
        keys(root, q, lo, hi);
        return q;
    }

    private void keys(Node x, Queue<Key> q, Key lo, Key hi) {
        if(x == null) return;
        int clo = lo.compareTo(x.key);
        int chi = hi.compareTo(x.key);
        if(clo < 0) keys(x.left, q, lo, hi);
        if(clo <= 0 && chi >= 0) q.enqueue(x.key);
        if(chi > 0) keys(x.right, q, lo, hi);

    }

    // draw
    private class TNodeXY {
        double x;
        double y;
        double l;
        double r;
        TNodeXY(double x, double y, double l, double r) {
            this.x = x;
            this.y = y;
            this.l = l;
            this.r = r;
        }
    }

    public void draw() {
        StdDraw.setYscale(-1, root.height + 2);
        StdDraw.setXscale(-1, root.size  + 1);
        TNodeXY rootTree = draw(root, 0, root.height);
        drawNode(rootTree, root);
    }

    private TNodeXY draw(Node x, double lBorder, double h) {
        if(x == null) {
            return  new TNodeXY(lBorder, h, lBorder, lBorder + 1);
        }

        TNodeXY lTree = draw(x.left, lBorder, h - 1);
        TNodeXY rTree = draw(x.right, lTree.r, h - 1);
        TNodeXY xTree = new TNodeXY((lTree.x + rTree.x) / 2, h, lTree.l, rTree.r);


        if(x.left != null) {
            StdDraw.line(lTree.x, lTree.y, xTree.x, xTree.y);
            drawNode(lTree, x.left);
        }
        if(x.right != null) {
            drawNode(rTree, x.right);
            StdDraw.line(rTree.x, rTree.y, xTree.x, xTree.y);
        }
        return xTree;
    }

    private void drawNode(TNodeXY t, Node x) {
        //StdDraw.filledCircle(t.x, t.y, 0.3);
        StdDraw.circle(t.x, t.y, 0.3);
        StdDraw.text(t.x, t.y, x.key.toString());
    }

    public static void main(String [] args) {
        RedBlackBST0<String, Integer> st = new RedBlackBST0<String, Integer>();
        /*
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        */
        st.put("A", 10);
        st.put("B", 11);
        st.put("C", 12);
        st.draw();
        StdOut.println(st.min());
        StdOut.println(st.max());

        //st.delete("C");

        //st.deleteMin();
        //st.deleteMax();

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        StdOut.println(); //##

    }
}
