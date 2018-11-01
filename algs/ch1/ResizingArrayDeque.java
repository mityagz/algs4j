package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 1/14/16.
 */
public class ResizingArrayDeque<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;
    private int head;
    private int tail;
    private int capacity = 8;


    ResizingArrayDeque() {
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
        head = (head - 1) % capacity;
        if(head < 0){
            head = a.length - 1 + head;
        }else if(head == a.length){
            head = 0;
        }
        a[head = (head % capacity)] = x;
        //head = (head - 1) & (a.length - 1);
        if (head == tail) {
            resize(2 * a.length);
        }
        n++;
    }

    public void addLast(Item x) {
        if (x == null) {
            new NullPointerException();
        }
        a[tail] = x;
        if ((tail = (tail + 1) % capacity) == head) {
            resize(2 * a.length);
        }
        n++;
    }

    public Item removeFirst() {
        int h = head;
        Item result = a[h];
        if (result != null) {
            a[h] = null;
            head = (h + 1) % capacity;
            if(head < 0){
                head = a.length - 1 + head;
            }else if(head == a.length){
                head = 0;
            }
        }
        n--;
        return result;
    }

    public Item removeLast() {
        int t = (tail - 1) % capacity;
        Item result = a[t];
        if (result != null) {
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
        if (head <= tail) {
            while (i <= tail) {
                StdOut.println("Item: " + a[i] + " " + i);
                i++;
            }
        } else {
            while (i <= a.length) {
                StdOut.println("Item: " + a[i] + " " + i);
                i++;
            }
            i = 0;
            while (i <= tail) {
                StdOut.println("Item: " + a[i] + " " + i);
                i++;
            }
        }
    }


    public static void main(String [] args){
        ResizingArrayDeque<Integer> rd = new ResizingArrayDeque();


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
        rd.listPrint();
        StdOut.println(-4 & (16 - 1));
    }
}
