package algs.ch32;

/**
 * Created by mitya on 11/6/16.
 */

public interface STBase<Key, Value> {
    public Value get(Key key);

    public void put(Key key, Value val);

    public boolean contains(Key key);

    public int size();

    public boolean isEmpty();

    public void delete(Key key);

    public Iterable<Key> keys();
}

