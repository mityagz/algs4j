package algs.ch32;

/**
 * Created by mitya on 11/6/16.
 */

public interface ST<Key extends Comparable<Key>, Value> extends STBase<Key, Value>{

    public int rank(Key key);

    public int rank2(Key key, int lo, int hi);

    public Key min();

    public Key max();

    public Key floor(Key key);

    public Key ceiling(Key key);

    public Key select(int k);

    public void deleteMin();

    public void deleteMax();

    public int size(Key lo, Key hi);

    public Iterable<Key> keys(Key lo, Key hi);

}

