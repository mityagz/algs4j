package algs.ch24;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 9/2/16.
 */
public class LinkedMaxPQ<Key extends Comparable<Key>> implements IMaxPQ<Key>{

    private class Node<Key> {
        int n;
        Key data;
        Node<Key> parent;
        Node<Key> left;
        Node<Key> right;
        Node(Key data, int n) {
            this.data = data;
            this.n = n;
        }
    }

    private Node<Key> root;
    private Node<Key> lastIns;

    private int size(Node<Key> x) {
        if (x == null) return 0;
        return x.n;
    }

    private void swapNodeData(Node<Key> x, Node<Key> y) {
        Key t = x.data;
        x.data = y.data;
        y.data = t;
    }

    private Node insert(Node<Key> x, Key data) {
        if(x == null) {
            lastIns = new Node<Key>(data, 1);
            return lastIns;
        }

        int leftSize = size(x.left);
        int rightSize = size(x.right);

        if(leftSize <= rightSize) {
                Node inserted = insert(x.left, data);
                x.left = inserted;
                inserted.parent = x;
        } else {
                Node inserted = insert(x.right, data);
                x.right = inserted;
                inserted.parent = x;
        }

        x.n = size(x.left) + size(x.right) + 1;

        return x;
    }

    private void swim(Node<Key> x) {
        if(x == null) return;
        if(x.parent == null) return; // We are root
        int c = x.parent.data.compareTo(x.data);
        if(c < 0) {
            swapNodeData(x.parent, x);
            swim(x.parent);
        }
    }

    private void sink(Node<Key> x) {
        Node<Key> swapNode;
        if(x == null) return;
        if(x.left == null && x.right == null) {
            return;
        } else if(x.left == null){
            swapNode = x.right;
            int c = x.data.compareTo(swapNode.data);
            if(c < 0)
                swapNodeData(swapNode, x);
        } else if(x.right == null){
            swapNode = x.left;
            int c = x.data.compareTo(swapNode.data);
            if(c < 0)
                swapNodeData(swapNode, x);
        } else {
            int c = x.left.data.compareTo(x.right.data);
            if(c >= 0) {
                swapNode = x.left;
            } else {
                swapNode = x.right;
            }
            int cNode = x.data.compareTo(swapNode.data);
            if(cNode < 0) {
                swapNodeData(swapNode, x);
                sink(swapNode);
            }
        }
    }


    private Node resetLastIns(Node<Key> x) {
        return x;
    }

    private Node resetLastInserted(Node<Key> x){
        if(x == null) return null;
        if(x.left == null && x.right == null) return x;
        if(size(x.right) < size(x.left))return resetLastInserted(x.left);
        else                            return resetLastInserted(x.right);
    }


    @Override
    public void insert(Key data) {
        insert(root, data);
        swim(lastIns);
    }

    @Override
    public Key max() {
        if(root == null) return null;
        return root.data;
    }

    @Override
    public Key delMax() {
        if(size() == 1) {
            Key ret = root.data;
            root = null;
            return ret;
        }
        swapNodeData(root, lastIns);
        Node lastInsParent = lastIns.parent;
        Key lastInsData = lastIns.data;
        if(lastIns == lastInsParent.left) {
            lastInsParent.left = null;
        } else {
            lastInsParent.right = null;
        }

        Node traverser = lastIns;
        while(traverser != null){
            traverser.n--;
            traverser = traverser.parent;
        }

        lastIns = resetLastInserted(root);

        sink(root);

        return lastInsData;
    }

    @Override
    public boolean isEmpty() {
        if(size() == 0)
            return true;
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    public static void main(String [] args) {
        LinkedMaxPQ<String> p = new LinkedMaxPQ<String>();


        p.insert("Z");
        p.insert("E");
        p.insert("A");
        p.insert("R");
        p.insert("A");
        p.insert("S");
        p.insert("W");
        p.insert("I");

        //p.delMax();
        //p.insert("Z");
        /*
        p.insert(1);
        p.insert(8);
        p.insert(7);
        p.insert(4);
        p.insert(9);
        p.insert(13);
        p.insert(11);
        p.insert(127);
        */

        while (!p.isEmpty()) {
             StdOut.println(p.delMax());
        }
    }
}
