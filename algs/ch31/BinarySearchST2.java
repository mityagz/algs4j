package algs.ch31;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;


/**
 * Created by mitya on 10/30/16.
 */
public class BinarySearchST2<Key extends Comparable<Key>, Value> implements ST<Key, Value>{
    private Item [] items;
    private int n;
    public BinarySearchST2(int capacity) {
        items =  (new Item [capacity]);
    }

    public void resize (int capacity) {
        Item [] tItems = new Item[capacity];
        for(int i = 0; i < items.length; i++) {
            tItems[i] = items[i];
        }
        items = tItems;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        if(size() == 0)
            return true;
        return false;
    }

    public int rank(Key key) {
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int c = key.compareTo((Key) items[mid].getKey());
            if (c < 0) hi = mid - 1;
            else if (c > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public int rank2(Key key, int lo, int hi) {
        if(hi < lo) return lo;
        int mid = lo + (hi - lo) / 2;
        int c = key.compareTo((Key) items[mid].getKey());
        if(c < 0) rank2(key, lo, mid - 1);
        else if(c > 0) rank2(key, mid + 1, hi);
        else return mid;
        return 0;
    }

    public Value get(Key key) {
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < n && key.compareTo((Key) items[i].getKey()) == 0) return (Value)items[i].getValue();
        else return null;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if(i < n && key.compareTo((Key) items[i].getKey()) == 0) {
            items[i].putValue(val);
            return;
        }
        // code for array size change
        if(items.length == n) resize(items.length * 2);
        for(int j = n; j > i; j--) {
            items[j] = items[j - 1];
        }
        items[i] = new Item(key, val);
        n++;
    }

    public void delete(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        int i = rank(key);
        if(i == n || key.compareTo(key) != 0)
            return;

        for(int j = i; j < n - 1; j++) {
            items[j] = items[j + 1];
        }

        n--;
        items[n] = null;
        // code for array size change
        if(n > 0 && n == items.length / 4) resize(items.length / 2);
    }

    public boolean contains(Key key) {
        if (key == null) throw new NullPointerException("argument to contains() is null");
        if(get(key) != null)
            return true;
        return false;
    }

    public Key min() {
        return (Key) items[0].getKey();
    }

    public Key max() {
        return (Key) items[n - 1].getKey();
    }

    public Key floor(Key key) {
        if (key == null) throw new NullPointerException("argument to floor() is null");
        int i = rank(key);
        if(i < n && items[i].getKey().compareTo(key) == 0)
            return (Key) items[i].getKey();
        if(i - 1 >= 0)
            return (Key) items[i - 1].getKey();
        else return null;
    }

    public Key ceiling(Key key) {
        if (key == null) throw new NullPointerException("argument to ceiling() is null");
        int i = rank(key);
        if (i == n) return null;
        else
        return (Key) items[i].getKey();
    }

    public Key select(int k) {
        if (k < 0 || k >= n) return null;
        return (Key) items[k].getKey();
    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }

    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
    }

    public int size(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("first argument to size() is null");
        if (hi == null) throw new NullPointerException("second argument to size() is null");
        if(lo.compareTo(hi) > 0) return 0;
        int i0 = rank(lo), i1 = rank(hi);
        if(contains(hi)) return i1 - i0 + 1;
        else
        return  i1 - i0;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new NullPointerException("first argument to keys() is null");
        if (hi == null) throw new NullPointerException("second argument to keys() is null");
        Queue<Key> q = new Queue<Key>();
        if (lo.compareTo(hi) > 0) return q;
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue((Key) items[i].getKey());
        }
        if(contains(hi))
            q.enqueue((Key) items[rank(hi)].getKey());
        return q;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private boolean check() {
        return isSorted() && rankCheck();
    }

    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (items[i].compareTo(items[i-1]) < 0) return false;
        return true;
    }

    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (items[i].compareTo(select(rank((Key) items[i].getKey()))) != 0) return false;
        return true;
    }


    public static void main(String[] args) {
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(10);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
