package algs.ch1;

import java.util.Iterator;

/**
 * Created by mitya on 12/26/15.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item []) new Object [1];
    private int n;

    public void resize(int max){
        Item [] t = (Item []) new Object [max];
        for(int i = 0; i < n; i++){
            t[i] = a[i];
        }
        a = t;
    }

    public boolean isEmpty(){
        if(n == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return n;
    }

    public void push(Item item){
        if(n == a.length){
            resize(2 * a.length);
        }
        a[n++] = item;
    }

    public Item pop(){
        Item item = a[--n];
        if(n > 0 && n == a.length/4){
                resize(a.length/2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = n;
        @Override
        public boolean hasNext() {
            if(i > 0){
                return true;
            }
            return false;
        }

        @Override
        public Item next() {
            //Item item = (Item) a[--i];
            return a[--i];
        }

        public void remove(){

        }
    }
}
