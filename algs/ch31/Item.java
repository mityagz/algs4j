package algs.ch31;

/**
 * Created by mitya on 10/30/16.
 */
public class Item<Key extends Comparable<Key>, Value>  implements Comparable {
    private Key key;
    private Value val;

    Item() {

    }

    Item(Key key, Value val) {
        this.key = key;
        this.val = val;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return val;
    }

    public void putValue(Value val) {
        this.val = val;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
