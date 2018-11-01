package algs.ch1;

import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

/**
 * Created by mitya on 1/23/16.
 */
public class ADeque<Item> implements Iterable {

    private Item[] a;
    private int n;
    private int head;
    private int tail;
    private int capacity = 8;

    ADeque(){
        a = (Item[]) new Object[capacity];
    }

    public void resize(int max) {
        if (max < a.length) {
            new IllegalAccessException("Decrease array size isn't implemented");
        }
        int p = head;
        int n = a.length;
        int r = n - p;
        Item[] t = (Item[]) new Object[max];
        System.arraycopy(a, p, t, 0, r);
        System.arraycopy(a, 0, t, r, p);
        a = t;
        capacity = max;
        head = 0;
        tail = n;
    }

    public boolean isEmpty() {
        if (n == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return n;
    }


    public void addFirst(Item x) {
        if (x == null) {
            new NullPointerException();
        }
        a[head = (head - 1) & capacity - 1]= x;
        n++;
        if(head == tail){
            resize(2*capacity);
        }
    }

    public void addLast(Item x) {
        if (x == null) {
            new NullPointerException();
        }
        a[tail] = x;
        if ((tail = (tail + 1) & capacity - 1) == head) {
            resize(2*capacity);
        }
        n++;
    }

    public Item removeFirst() {
        int h = head;
        Item result = a[h];
        n--;
        if(result != null){
            a[h] = null;
            head = (head + 1) & capacity - 1;
        }
        return result;
    }

    public Item removeLast() {
        int t = tail;
        t = (tail - 1) & capacity - 1;
        Item result = a[t];
        if(result != null){
            a[t] = null;
            tail = t;
        }
        n--;
        return result;
    }

    public void pushLeft(Item item) {

    }

    public void pushRight(Item item) {

    }

    public Item popLeft() {
        return null;
    }

    public Item popRight() {
        return null;
    }


    public void printArray() {

    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public void listPrint() {
        int h = head;
        int t = tail;
        int i = head;
        boolean f = false;
        if(n == 0){StdOut.println("Deque is empty"); return;}
        if (head < tail) {
            while (i <= tail) {
                StdOut.println("Item: " + a[i] + " " + i);
                i++;
            }
        } else {
            while (i < a.length) {
                StdOut.println("Item: " + a[i] + " " + i);
                i++;
            }
            i = 0;
            while (i < tail) {
                StdOut.println("Item: " + a[i] + " " + i);
                i++;
            }
        }
    }


    public static void main(String [] args){
        ADeque<Integer> rd = new ADeque();
        rd.addFirst(11);
        rd.addFirst(13);
        rd.addFirst(7);
        rd.addLast(5);
        rd.addLast(3);
        rd.addLast(2);
        rd.addLast(1);

        rd.listPrint();
        StdOut.println("--");
        rd.removeFirst();
        rd.removeFirst();
        rd.removeLast();
        rd.listPrint();

        StdOut.println(-4 & (16 - 1));
    }
}
