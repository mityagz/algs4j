package algs.ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//import java.util.Stack;

/**
 * Created by mitya on 12/19/15.
 */
public class Note {

    /*
        first
        last

        fist <-> last

        ...        implements Iterable

        Iterator Item iterator(){
            return RIterator;
         }



        private class RIterator implements Iterator {
                private Node current = first;

                public boolean hasNext() {
                    if(current != null){
                        return true;
                    }
                }

                public Item next(){
                      Item item  = current.item;
                      current = current.next;
                      return item;
                }
        }

     */

    /*
        Array Stack String

     */

    Note(){
        Stack<String>[] als = (Stack<String> []) new Stack [10];
    }
}
