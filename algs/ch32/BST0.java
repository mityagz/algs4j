package algs.ch32;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * Created by mitya on 11/6/16.
 */
public class BST0<Key extends Comparable, Value> {
    private Node root = null;
    private Node lastAccess; // 3.2.28
    public Queue<Node>[] aq = null; // 3.2.37
    private static int level = 0;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right, pred, succ; // pred, succ 3.2.34
        private int n;
        private int height;  // 3.2.6
        private double deep; // 3.2.7
        public Node (Key key, Value val, int n) {
            this.key = key; this.val = val; this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x == null) return 0;
        else return x.n;
    }

    public Key next(Key key) {
        Node x = root;
        x = get2(x, key);
        if(x == null || x.succ == null) return null;
        return x.succ.key;
    }

    public Key prev(Key key) {
        Node x = root;
        x = get2(x, key);
        if(x == null || x.pred == null) return null;
        return x.pred.key;
    }

    public Value get(Key key) {
            return get(root, key);
    }

    private Value get(Node x, Key key) {
        if(lastAccess != null && lastAccess.key.compareTo(x.key) == 0) {
            return x.val;
        }
        if(x == null) return null;
        int c = key.compareTo(x.key);
        if(c < 0) return get(x.left, key);
        else if(c > 0) return get(x.right, key);
        else {
            lastAccess = x;
            return x.val;
        }
    }

    private Node get2(Node x, Key key) {
        if(lastAccess != null && lastAccess.key.compareTo(x.key) == 0) {
            return x;
        }
        if(x == null) return null;
        int c = key.compareTo(x.key);
        if(c < 0) return get2(x.left, key);
        else if(c > 0) return get2(x.right, key);
        else {
            lastAccess = x;
            return x;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null) {
            Node p = floor(root, key);
            Node n = ceiling(root, key);
            Node t = new Node(key, val, 1);
            if(p != null)
                t.pred = p;
            if(n != null)
                t.succ = n;
            return t;
        }
        if(lastAccess != null && lastAccess.key.compareTo(x.key) == 0) {
            x.val = val;
            return x;
        }
        int c = key.compareTo(x.key);
        if(c < 0) x.left = put(x.left, key, val);
        else if(c > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.n = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height1(x.left), height1(x.right)) + 1;
        x.deep = deep(x.left) + deep(x.right) + size(x) - 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else return min(x.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        if(x.right == null)
            return x;
        else return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        Node t = null;
        if(x == null) return null;
        int c = key.compareTo(x.key);
        if(c == 0) return x;
        if(c < 0) return floor(x.left, key);
        t = floor(x.right, key);
        if(t != null)
            return t;
        else return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        Node t = null;
        if(x == null) return null;
        int c = key.compareTo(x.key);
        if(c == 0) return x;
        if(c < 0) {
            t = ceiling(x. left, key);
            if(t != null)
                return t;
            else return x;
        }
        return ceiling(x.right, key);
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if(x == null) return null;
        int t = size(x.left);
        if(t > k) return select(x.left, k);
        else if(t < k) return select(x.right, k - t -1);
        else return x;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if(x == null) return 0;
        int c = key.compareTo(x.key);
        if(c < 0) return rank(x.left, key);
        else if(c > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if(x.left == null) {
            if(x.pred != null)
                x.pred.succ = x.succ;
            if(x.succ != null)
                x.succ.pred = x.pred;
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height1(x.left), height1(x.right)) + 1;
        x.deep = deep(x.left) + deep(x.right) + size(x) - 1;
        return x;
    }

    private Node deleteMin2(Node x) {
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height1(x.left), height1(x.right)) + 1;
        x.deep = deep(x.left) + deep(x.right) + size(x) - 1;
        return x;
    }


    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if(x.right == null) {
            if(x.pred != null)
                x.pred.succ = x.succ;
            if(x.succ != null)
                x.succ.pred = x.pred;
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.n = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height1(x.left), height1(x.right)) + 1;
        x.deep = deep(x.left) + deep(x.right) + size(x) - 1;
        return x;
    }



    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if(x == null) return null;
        int c = key.compareTo(x.key);
        if(c < 0) x.left = delete(x.left, key);
        else if(c > 0) x.right = delete(x.right, key);
        else if (c == 0) {
            if(x.right == null) {
                if (x.pred != null)
                    x.pred.succ = x.succ;
                if (x.succ != null)
                    x.succ.pred = x.pred;
                return x.left;
            }
            if(x.left == null) {
                if (x.pred != null)
                    x.pred.succ = x.succ;
                if (x.succ != null)
                    x.succ.pred = x.pred;
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin2(t.right);
            x.left = t.left;
            if(t.pred != null)
                t.pred.succ = t.succ;
            if(x.succ != null);
                t.succ.pred = t.pred;
        }
        x.n = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height1(x.left), height1(x.right)) + 1;
        x.deep = deep(x.left) + deep(x.right) + size(x) - 1;
        return x;
    }

    public void print() {
        print(root);
    }

    private void print(Node x) {
       if(x == null) return;
       print(x.left);
       StdOut.println(x.key);
       print(x.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if(x == null) return;
        int cLo = lo.compareTo(x.key);
        int cHi = hi.compareTo(x.key);
        if(cLo < 0) keys(x.left, queue, lo, hi);
        if(cLo <= 0 && cHi >= 0) queue.enqueue(x.key); //!!!!
        if(cHi > 0) keys(x.right, queue, lo, hi);
    }

    // 3.2.6
    public int height() {
        return height(root);
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

    public double avgCompares() {
        return avgCompares(root);
    }

    private double avgCompares(Node x) {
        return deepRec(x) / size(x);
    }

    public double avgComp() {
        return avgComp(root);
    }

    private double avgComp(Node x) {
        if(x == null) return 0;
        else return x.deep / size(x);
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

    public Key randomKey() {
        int s = size(root);
        if(s == 0) return null;
        int r = StdRandom.uniform(1,s);
        return select(r);
    }

    public boolean isBinaryTree()  {return isBinaryTree(root);}

    private boolean isBinaryTree(Node x) {
        if(x == null) return true;
        if(size(x) != 1 + size(x.left) + size(x.right)) return false;
        return isBinaryTree(x.left) && isBinaryTree(x.right);
    }

    public boolean isOrdered() { return isOrdered(root, min(), max()); }

    private boolean isOrdered(Node x, Key min, Key max) {
        if(x == null) return true;
        if(!((min != null && max != null) && (x.key.compareTo(min) >= 0 && x.key.compareTo(max) <= 0))) return false;
        return isOrdered(x.left, min, x.key) && isOrdered(x.right, x.key, max);
    }

    public boolean hasNoDuplicates() {
        return hasNoDuplicates(root);
    }

    private boolean hasNoDuplicates(Node x) {
        if(x == null) return true;
        if(x != null &&  x.left != null && x.key.compareTo(x.left.key) == 0) return false;
        if(x != null && x.right != null && x.key.compareTo(x.right.key) == 0) return false;
        return hasNoDuplicates(x.left) && hasNoDuplicates(x.right);
    }

    public boolean isBST() {
        return isBST(root);
    }

    private boolean isBST(Node x) {
        if(!isBinaryTree()) return false;
        if(!isOrdered()) return false;
        if(!hasNoDuplicates()) return false;
        if(!isRankConsistent()) return false;
        return true;
    }

    public boolean isRankConsistent() {
        return isRankConsistent(root);
    }

    private boolean isRankConsistent(Node x) {
        for(int i = 0; i <= size() - 1; i++)
            if(i != rank(select(i))) return false;
        for(Key k : keys())
            if(k != select(rank(k))) return false;
        return true;
    }

    public void printLevel() {
        printLevel(root);
    }

    private void printLevel(Node x) {
        if(x == null) {
            return;
        }
        if(aq == null) aq = new Queue[1000];
        level++;
        printLevel(x.left);
            if(aq[level] == null) aq[level] = new Queue<Node>();
            aq[level].enqueue(x);
        StdOut.println("printLevel: " + level + " " + x.key);
        printLevel(x.right);
        level--;
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
        StdDraw.setXscale(-1, root.n  + 1);
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
        BST0<String, Integer> bst = new BST0<String, Integer>();
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

        StdOut.println(bst.select(bst.rank("W")) + " " + bst.rank("W")  + " " + bst.get("W"));
        //bst.delete("E");
        bst.print(bst.root);

        StdOut.println("min:max " + bst.min() + " " + bst.max());
        StdOut.println("floor:ceiling " + bst.floor("F") + " " + bst.ceiling("M"));
        StdOut.println("rank: " + bst.rank("W"));
        StdOut.println("random key: " + bst.randomKey());

        Iterable i = bst.keys("R", "T");

        for(Object s : i) {
            StdOut.println((String)s);
        }

        StdOut.println(bst.height());
        StdOut.println(bst.height1());
        StdOut.println(bst.avgComp());
        StdOut.println(bst.avgCompares());
        StdOut.println("isBinaryTree: " + bst.isBinaryTree());
        StdOut.println("isOrdered: " + bst.isOrdered());
        StdOut.println("isRankConsistent: " + bst.isRankConsistent());
        StdOut.println("isBST: " + bst.isBST());

        bst.printLevel(bst.root);

        StdOut.println();

        bst.draw();

        /*
        for(int j = 1; j < bst.aq.length; j++) {
            algs.ch32.Node  x;
            while (!bst.aq[j].isEmpty()) {
                //x = bst.aq[j].dequeue();
                StdOut.print(bst.aq[j].dequeue().key + " ");
            }
            StdOut.println();
            StdOut.println("-------------------------");
        }
        */
    }
}
