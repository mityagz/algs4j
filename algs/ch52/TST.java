package algs.ch52;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 5/21/17.
 */
public class TST<Value> {

    private Node root;


    private class Node {
        char c;
        Node left, mid, right;
        Value val;
    }

    public Value get(String key) {
       Node x =  get(root, key, 0);
       if(x == null) return null;
       return (Value) x.val;
    }

    private Node get(Node x, String key, int d) {
        if(x == null) return null;
        char c = key.charAt(d);
        if(c < x.c) return get(x.left, key, d);
        else if(c > x.c) return get(x.right, key,d);
        else if(d < key.length() - 1) return get(x.mid, key, d + 1);
        else return x;
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
     }

    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if(x == null) { x = new Node(); x.c = c;}
        if(c < x.c) x.left = put(x.left, key, val, d);
        else if(c > x.c) x.right = put(x.right, key, val, d);
        else if(d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);
        else x.val = val;
        return x;
    }

    public Iterable<String> keys() {
        Queue<String> queue = new Queue<String>();
        collect(root, "", queue);
        return queue;
    }


    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue = new Queue<String>();
        Node x = get(root, prefix, 0);
        if (x == null) return queue;
        if (x.val != null) queue.enqueue(prefix);
        collect(x.mid, prefix, queue);
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



    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        char c = key.charAt(d);
        if(c < x.c) x.left = delete(x.left, key, d);
        else if(c > x.c) x.right = delete(x.right, key, d);
        else {
            if(d == key.length() - 1) {
                x.val = null;
            } else {
                x.mid = delete(x.mid, key, d + 1);
            }
        }

        if(x.val != null) return x;

        if(x.left == null && x.mid == null && x.right == null)
            x = null;

        return x;
    }


    public String longestPrefixOf(String s) {
        int i = search(root, s, 0, 0);
        return  s.substring(0, i);
    }

    private int search(Node x, String s, int d, int length) {
        if(x == null) return length;

        if(d == s.length()) return length;
        char c = s.charAt(d);

        if(c < x.c)
            length = search(x.left, s, d, length);
        else if(c > x.c)
            length = search(x.right, s, d ,length);
        else {
            if(x.val != null) length = d + 1;
            length = search(x.mid, s, d + 1, length);

        }
         return length;
    }


    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue = new Queue<String>();
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


    public static void main(String[] args) {
        TST<Integer> st = new TST<Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
            StdOut.println("keys(\"\"):");
            for (String key : st.keys()) {
                StdOut.println(key + " " + st.get(key));
            }
            StdOut.println();





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


        st.delete("sea");
        st.delete("quick");

        StdOut.println("keys(\"\"):");
            for (String key : st.keys()) {
                StdOut.println(key + " " + st.get(key));
            }
            StdOut.println();

    }
}
