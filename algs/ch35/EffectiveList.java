package algs.ch35;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by mitya on 1/3/17.
 */
public class EffectiveList<Item extends Comparable<Item>> implements Iterable<Item> {
    private RedBlackBST<Double, Item> order;
    private RedBlackBST<Item, Double> items;

    EffectiveList() {
        order = new RedBlackBST<Double, Item>();
        items = new RedBlackBST<Item, Double>();
    }

    public void addFront(Item item) {
        if(isEmpty()) {
            order.put(0.0, item);
            items.put(item, 0.0);
        } else {
            Double k = order.min() - 1;
            order.put(k, item);
            items.put(item, k);
        }
    }

    public void addBack(Item item) {
        if(isEmpty()) {
            order.put(0.0, item);
            items.put(item, 0.0);
        } else {
            Double k = order.max() + 1;
            order.put(k, item);
            items.put(item, k);
        }
    }

    public Item deleteFront() {
        Double k = order.min();
        Item item = order.get(k);
        order.delete(k);
        items.delete(item);
        return item;
    }

    public Item deleteBack() {
        Double k = order.max();
        Item item = order.get(k);
        order.delete(k);
        items.delete(item);
        return item;
    }

    public void delete(Item item) {
        Double k = items.get(item);
        if(k == null) return;
        order.delete(k);
        items.delete(item);
    }

    public void add(int i, Item item) {
        Double k = (order.select(i - 1) + order.select(i)) / 2;
        items.put(item, k);
        order.put(k, item);
    }

    public Item delete(int i) {
        Double k = order.select(i);
        if(k == null) return null;
        Item item = order.get(k);
        items.delete(item);
        order.delete(k);
        return item;
    }

    public boolean contain(Item item) {
        return items.contains(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        EffectiveList<Integer> list = new EffectiveList<Integer>();
        int n = StdIn.readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        StdOut.println(Arrays.toString(a));
        for (int i = 0; i < n; ++i) {
            list.addBack(a[i]);
        }

        list.add(1, 100);
        list.add(1, 200);
        list.add(1, 300);

        list.delete(9);
        list.delete(new Integer(2));
        while (!list.isEmpty())
            StdOut.print(list.deleteFront() + " ");
    }
}
