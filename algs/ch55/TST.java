package algs.ch55;

/******************************************************************************
 *  Compilation:  javac TST.java
 *  Execution:    java TST < words.txt
 *  Dependencies: StdIn.java
 *
 *  Symbol table with string keys, implemented using a ternary search
 *  trie (TST).
 *
 *
 *  % java TST < shellsST.txt
 *  keys(""):
 *  by 4
 *  sea 6
 *  sells 1
 *  she 0
 *  shells 3
 *  shore 7
 *  the 5
 *
 *  longestPrefixOf("shellsort"):
 *  shells
 *
 *  keysWithPrefix("shor"):
 *  shore
 *
 *  keysThatMatch(".he.l."):
 *  shells
 *
 *  % java TST
 *  theory the now is the time for all good men
 *
 *  Remarks
 *  --------
 *    - can't use a key that is the empty string ""
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 *  The TST class represents an symbol table of key-value
 *  pairs, with string keys and generic values.
 *  It supports the usual put, get, contains,
 *  delete, size, and is-empty methods.
 *  It also provides character-based methods for finding the string
 *  in the symbol table that is the longest prefix of a given prefix,
 *  finding all strings in the symbol table that start with a given prefix,
 *  and finding all strings in the symbol table that match a given pattern.
 *  A symbol table implements the associative array abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be null&mdash;setting the
 *  value associated with a key to null is equivalent to deleting the key
 *  from the symbol table.
 *
 *  This implementation uses a ternary search trie.
 *
 *  For additional documentation, see  href="http://algs4.cs.princeton.edu/52trie">Section 5.2 of
 *  Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne.
 */
public class TST<Value> {
    private int N;              // size
    private Node root;   // root of TST

    private static class Node<Value> {
        private char c;                        // character
        private Node left, mid, right;  // left, middle, and right subtries
        private Value val;                     // value associated with string
    }

    /**
     * Initializes an empty string symbol table.
     */
    public TST() {
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return N;
    }

    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return true if this symbol table contains key and
     *     false otherwise
     * @throws NullPointerException if key is null
     */
    public boolean contains(String key) {
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key.
     * @param key the key
     * @return the value associated with the given key if the key is in the symbol table
     *     and null if the key is not in the symbol table
     * @throws NullPointerException if key is null
     */
    public Value get(String key) {
        if (key == null) throw new NullPointerException();
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value)x.val;
    }

    // return subtrie corresponding to given key
    private Node get(Node x, String key, int d) {
        if (key == null) throw new NullPointerException();
        if (key.length() == 0) throw new IllegalArgumentException("key must have length >= 1");
        if (x == null) return null;
        char c = key.charAt(d);
        if      (c < x.c)              return get(x.left,  key, d);
        else if (c > x.c)              return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid,   key, d+1);
        else                           return x;
    }

    /**
     * Inserts the key-value pair into the symbol table, overwriting the old value
     * with the new value if the key is already in the symbol table.
     * If the value is null, this effectively deletes the key from the symbol table.
     * @param key the key
     * @param val the value
     * @throws NullPointerException if key is null
     */
    public void put(String key, Value val) {
        if (!contains(key)) N++;
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node<Value>();
            x.c = c;
        }
        if      (c < x.c)               x.left  = put(x.left,  key, val, d);
        else if (c > x.c)               x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1)  x.mid   = put(x.mid,   key, val, d+1);
        else                            x.val   = val;
        return x;
    }

    /**
     * Returns the string in the symbol table that is the longest prefix of query,
     * or null, if no such string.
     * @param query the query string
     * @return the string in the symbol table that is the longest prefix of query,
     *     or null if no such string
     * @throws NullPointerException if query is null
     */
    public String longestPrefixOf(String query) {
        if (query == null || query.length() == 0) return null;
        int length = 0;
        Node x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char c = query.charAt(i);
            if      (c < x.c) x = x.left;
            else if (c > x.c) x = x.right;
            else {
                i++;
                if (x.val != null) length = i;
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }

    /**
     * Returns all keys in the symbol table as an Iterable.
     * To iterate over all of the keys in the symbol table named st,
     * use the foreach notation: for (Key key : st.keys()).
     * @return all keys in the sybol table as an Iterable
     */
    public Iterable<String> keys() {
        Queue queue = new Queue<String>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }

    /**
     * Returns all of the keys in the set that start with prefix.
     * @param prefix the prefix
     * @return all of the keys in the set that start with prefix,
     *     as an iterable
     */
    public Iterable<String> keysWithPrefix(String prefix) {
        Queue queue = new Queue<String>();
        Node x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.enqueue(prefix);
        collect(x.mid, new String(prefix), queue);
        return queue;
    }

    public void collect(Node x, String pre, Queue<String> q) {
        if(x == null) return;
        collect(x.left, pre, q);
        if(x.val != null) q.enqueue(pre + x.c);
        collect(x.mid, pre + (x.c), q);
        pre = pre.substring(0, pre.length());
        collect(x.right, pre, q);
    }

    // all keys in subtrie rooted at x with given prefix
    private void collect(Node x, StringBuilder prefix, Queue<String> queue) {
        if (x == null) return;
        collect(x.left,  prefix, queue);
        if (x.val != null) queue.enqueue(prefix.toString() + x.c);
        collect(x.mid,   prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }


    /**
     * Returns all of the keys in the symbol table that match pattern,
     * where . symbol is treated as a wildcard character.
     * @param pattern the pattern
     * @return all of the keys in the symbol table that match pattern,
     *     as an iterable, where . is treated as a wildcard character.
     */
    public Iterable<String> keysThatMatch(String pattern) {
        Queue queue = new Queue<String>();
        collect(root, new StringBuilder(), 0, pattern, queue);
        return queue;
    }

    private void collect(Node x, StringBuilder prefix, int i, String pattern, Queue<String> queue) {
        if (x == null) return;
        char c = pattern.charAt(i);
        if (c == '.' || c < x.c) collect(x.left, prefix, i, pattern, queue);
        if (c == '.' || c == x.c) {
            if (i == pattern.length() - 1 && x.val != null) queue.enqueue(prefix.toString() + x.c);
            if (i < pattern.length() - 1) {
                collect(x.mid, prefix.append(x.c), i + 1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.c) collect(x.right, prefix, i, pattern, queue);
    }


    /**
     * Unit tests the TST data type.
     */
    public static void main(String[] args) {

        // build symbol table from standard input
        TST<Integer> st = new TST<Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        // print results
        if (st.size() < 100) {
            StdOut.println("keys(\"\"):");
            for (String key : st.keys()) {
                StdOut.println(key + " " + st.get(key));
            }
            StdOut.println();
        }

        StdOut.println("longestPrefixOf(\"shellsort\"):");
        StdOut.println(st.longestPrefixOf("shellsort"));
        StdOut.println();

        StdOut.println("keysWithPrefix(\"shor\"):");
        for (String s : st.keysWithPrefix("shor"))
            StdOut.println(s);
        StdOut.println();

        StdOut.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
            StdOut.println(s);
    }
}
