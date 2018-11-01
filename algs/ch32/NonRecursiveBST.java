package algs.ch32;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 11/19/16.
 */
public class NonRecursiveBST<Key extends Comparable, Value> {
    private Node root = null;
    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
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

    public Value get(Key key) {
        Node x = root;
        while ( x != null) {
            int c = key.compareTo(x.key);
            if (c < 0) x = x.left;
            else if (c > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public Node put(Key key, Value val) {
        Node x = root;
        Node prev = null;
        int c = -1;

        if(x == null) {
            //x = new Node(key, val, 1);
            x = new Node(key, val, 0);
            root = x;
            return x;
        }

        while (x != null) {
            prev = x;
            c = key.compareTo(x.key);
            if (c < 0) x = x.left;
            else if (c > 0) x = x.right;
            else {
                x.val = val;
                return x;
            }
        }

        if(x == null) {
            Node t;
            //x = new Node(key, val, 1);
            x = new Node(key, val, 0);
            if (c < 0) prev.left = x;
            else if (c > 0) prev.right = x;
            t = x;
            x = root;
            while(x != null) {
                x.n++;
                c = key.compareTo(x.key);
                if (c < 0) x = x.left;
                else x = x.right;
            }
            return t;
        }
        return null;

        /*
        x.n = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height1(x.left), height1(x.right)) + 1;
        x.deep = deep(x.left) + deep(x.right) + size(x) - 1;
        */
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        while(x.left != null) {
            x = x.left;
        }
        return x;
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node x) {
        while(x.right != null) {
            x = x.right;
        }
        return x;
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
        while(x != null) {
            int c = key.compareTo(x.key);
            if (c == 0) return x;
            else if (c < 0) x = x.left;
            else if (c > 0) t = x.right;
            if(t == null)
                return x;
            else x = t;
        }
        return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        Node t = null;
        Node r = null;
        boolean f = false;
        if(x == null) return null;
        while(x != null) {
            int c = key.compareTo(x.key);
            if (c == 0) return x;
            if(c < 0) {
                r = x;
                x = x.left;
            } else if(c > 0) {
                t = x;
                x = x.right;
            }
        }
        if(x == null)
        return r;
        else if (r == null)
            return t;
        else return x;
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

    public Key select2(int k) {
        Node x = root;
        //if(x == null) return null;
        while (x != null) {
            int t = size(x.left);
            if (t > k) x = x.left;
            else if (t < k) {
                x = x.right;
                k = k - t - 1;
            } else return x.key;
        }
        return null;
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


    public int rank2(Key key) {
        int rank = 0;
        Node x = root;
        while(x != null) {
            int c = key.compareTo(x.key);
            if (c < 0) {
                StdOut.println("c < 0 : rank " + x.key + " " + rank);
                x = x.left;
            } else if (c > 0) {
                //if (x.left == null)
                    rank++;
                rank += size(x.left);
                StdOut.println("c > 0 : rank " + x.key + " " + rank);
                x = x.right;
            } else {
                rank += size(x.left);
                StdOut.println("c == 0 : rank " + x.key + " " + rank);
                return rank;
            }
        }
        return rank;
    }


    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
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
        if(x.right == null) return x.left;
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
            if(x.right == null) return x.left;
            if(x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.n = size(x.left) + size(x.right) + 1;
        x.height = Math.max(height1(x.left), height1(x.right)) + 1;
        x.deep = deep(x.left) + deep(x.right) + size(x) - 1;
        return x;
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

    public static void main(String [] args) {
        NonRecursiveBST<String, Integer> bst = new NonRecursiveBST<String, Integer>();
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

//        StdOut.println(bst.select(bst.rank("W")) + " " + bst.rank("W")  + " " + bst.get("W"));
        //bst.delete("E");
        bst.print(bst.root);

        StdOut.println("min:max " + bst.min() + " " + bst.max());
        StdOut.println("floor:ceiling " + bst.floor("F") + " " + bst.ceiling("N"));
        StdOut.println("rank: " + bst.rank("P"));
        StdOut.println("rank2: " + bst.rank2("P"));
        StdOut.println("select: " + bst.select(5));
        StdOut.println("select2: " + bst.select2(5));


        Iterable i = bst.keys("R", "T");

        for(Object s : i) {
            StdOut.println((String)s);
        }

        StdOut.println(bst.size());
        StdOut.println(bst.height());
        StdOut.println(bst.avgCompares());
    }
}
