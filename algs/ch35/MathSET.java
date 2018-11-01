package algs.ch35;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;

/**
 * Created by mitya on 12/25/16.
 */
public class MathSET<Key> {
    private Key[] universe;
    private boolean[] set;
    private HashMap<Key, Integer> map;
    private int n;
    private int maxn;

    public MathSET(Key[] universe) {
        this.universe = universe;
        maxn = universe.length;
        set = new boolean[maxn];
        map = new HashMap<Key, Integer>();
        for (int i = 0; i < maxn; i++) {
            map.put(universe[i], i);
        }
    }

    private MathSET(Key[] universe, HashMap<Key, Integer> map) {
        this.universe = universe;
        this.map = map;
        maxn = universe.length;
        set = new boolean[maxn];
    }

    public void add(Key key) {
        Integer i = map.get(key);
        if(i != null && set[i] == false) {
            set[i] = true;
            n++;
        }
    }

    public MathSET<Key> complement() {
        MathSET<Key> r = new MathSET<Key>(universe, map);
        for(int i = 0; i < set.length; i++) {
            if(set[i] == false)
                r.set[i] = true;
        }
        return r;
    }

    public void union(MathSET<Key> a) {
        for(Key k : a.map.keySet()) {
            if(a.contains(k) && !contains(k)) {
                add(k);
            }
        }
    }

    public void intersection(MathSET<Key> a) {
        for(Key k : map.keySet()) {
            if(!a.contains(k) && contains(k)) {
                delete(k);
            }
        }
    }

    public void key(Key key) {

    }

    public boolean contains(Key key) {
        Integer i = map.get(key);
        if(i != null && set[i]) {
            return true;
        }
        return false;
    }

    public void delete(Key key) {
        Integer i = map.get(key);
        if(i != null && set[i]) {
            set[i] = false;
            n--;
        }
    }

    public boolean isEmpty() {
        if (n == 0)
            return true;
        else return false;
    }

    public int size() {
        return n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Key key : map.keySet()) {
            if(contains(key))
                sb.append(key + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        String[] universe = new String[N];
        for (int i = 0; i < N; ++i) {
            universe[i] = StdIn.readString();
        }

        MathSET<String> set1 = new MathSET<String>(universe);
        MathSET<String> set2 = new MathSET<String>(universe);

        for (int i = 0; i < N / 2; ++i) {
            set1.add(universe[StdRandom.uniform(N)]);
        }

        for (int i = 0; i < N / 2; ++i) {
            set2.add(universe[StdRandom.uniform(N)]);
        }
        StdOut.println(set1);
        StdOut.println(set2);
        set1.union(set2);
        StdOut.println("Union: " + set1);
        set1.intersection(set2);
        StdOut.println("Intersection: " + set1);
        MathSET<String> set3 = set2.complement();
        StdOut.println("Complement: " + set3);
        /*
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            //set1.delete(s);
            StdOut.println(set1);
        }
        */
    }
}
