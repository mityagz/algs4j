package algs.ch51;

/**
 * Created by mitya on 5/6/17.
 */
public class Node<Key extends Comparable<Key>> {
    int N;
    Key data;
    Node next, prev;

    public Node() {

    }

    public void setNext(Node n) {
        next = n;
    }

    public void setPrev(Node n) {
        prev = n;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public Node(Key data, int N) {
        this.data = data;
        this.N = N;
    }

    public Key getData() {
        return data;
    }
}

