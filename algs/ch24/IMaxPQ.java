package algs.ch24;

/**
 * Created by mitya on 8/27/16.
 */
public interface IMaxPQ<Item extends Comparable> {
    void insert(Item item);
    Item max();
    Item delMax();
    boolean isEmpty();
    int size();
}
