package algs.ch52;

import algs.ch51.Node;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/17/17.
 */
public class TrieST<Value> {
    private static int R = 256;
    private Node root;
    private static class Node {
       private Object val;
       private Node [] next = new Node[R];
    }

    public Value get(String key) {
       Node x =  get(root, key, 0);
       if(x == null) return null;
       return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if(x == null) return null;
        if(d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if(x == null) x = new Node();
        if(d == key.length()) {
            x.val = val;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    private int size(Node x) {
        if(x == null) return 0;
        int cnt = 0;
        if(x.val != null) cnt++;
        for(int c = 0; c < R; c++) {
            cnt += size(x.next[c]);
        }
        return cnt;
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new Queue<String>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    public void collect(Node x, String pre, Queue<String> q) {
        if(x == null) return;
        if(x.val != null) q.enqueue(pre);
        for(int c = 0; c < R; c++) {
            collect(x.next[c], pre + (char)c, q);
        }
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) {
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        if (x.val != null) return x;
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new Queue<String>();
        collect(root, "", pat, q);
        return q;
    }

    public void collect(Node x, String pre, String pat, Queue<String> q) {
        if(x == null) return;
        int d = pre.length();
        if(d == pat.length() && x.val != null) q.enqueue(pre);
        if(d == pat.length()) return;

        char next = pat.charAt(d);
        for(char c = 0; c < R; c++)
            if(next == '.' || next == c)
                collect(x.next[c], pre + c, pat, q);
    }

    public String longestPrefixOf(String s) {
        int i = search(root, s, 0, 0);
        return  s.substring(0, i);
    }

    private int search(Node x, String s, int d, int length) {
        if(x == null) return length;
        if(x.val != null) length = d;
        if(d == s.length()) return length;
        char c = s.charAt(d);
        length = search(x.next[c], s, d + 1, length);
        return length;
    }

    public static void main(String[] args) {
        TrieST<Integer> st = new TrieST<Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

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

        StdOut.println("longestPrefixOf(\"quicksort\"):");
        StdOut.println(st.longestPrefixOf("quicksort"));
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
