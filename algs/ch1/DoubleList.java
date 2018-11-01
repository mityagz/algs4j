package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 1/7/16.
 */
public class DoubleList<Item> implements Iterable<Item> {

    private DoubleNode first;
    private DoubleNode last;
    private int n;

    private static class DoubleNode<Item>{
        Item item;
        DoubleNode prev;
        DoubleNode next;
    }


    DoubleList(){
        first = last = null;
        n = 0;
    }

    public int size(){
        return  n;
    }

    public boolean isEmpty(){
        if(n == 0){
            return true;
        }
        return false;
    }

    public void listPrint(){
        //StdOut.println("First: " + first + " Last: " + last);
        for(DoubleNode x = first; x != null; x = x.next){
            StdOut.println("Item: " + x.item + " " + x);
        }
    }

    public void listPrintr(){
        //StdOut.println("First: " + first + " Last: " + last);
        for(DoubleNode x = last; x != null; x = x.prev){
            StdOut.println("Item: " + x.item);
        }
    }

    public static void insertBegin(DoubleList l, DoubleNode node){
            DoubleNode oldFirst = l.first;
            DoubleNode first = node;
            l.first = first;
            if(oldFirst == null) {
                l.last = first;
                first.prev = null;
                first.next = null;
            }else{
                oldFirst.prev = first;
                first.next = oldFirst;
                first.prev = null;
            }
            l.n++;
    }

    public static void insertEnd(DoubleList l, DoubleNode node){
            DoubleNode oldLast = l.last;
            DoubleNode last = node;
            l.last = last;
            if(oldLast == null) {
                l.first = last;
                last.prev = null;
                last.next = null;
            }else{
                oldLast.next = last;
                last.prev = oldLast;
                last.next = null;
            }
            l.n++;
    }

    public static DoubleNode removeBegin(DoubleList l){
        if(l.n == 0) return null;
        DoubleNode oldFirst = l.first;
        DoubleNode node = l.first;
        if(l.n == 1){
            l.first = l.last = null;
        }else {
            l.first = oldFirst.next;
            l.first.prev = null;
        }
        l.n--;
        return node;
    }

    public static DoubleNode removeEnd(DoubleList l){
        if(l.n == 0) return null;
        DoubleNode oldLast = l.last;
        DoubleNode node = l.last;
        if(l.n == 1){
            l.first = l.last = null;
        }else {
            l.last = oldLast.prev;
            l.last.next = null;
        }
        l.n--;
        return node;
    }

    public DoubleNode getNodeByItem (DoubleList l, Item item){
        for(Object i : l ){
            DoubleNode dn = (DoubleNode) i;
            if(dn.item == item){
                return dn;
            }
        }
            return null;
    }

    public DoubleNode getNodeByInOrder (DoubleList l, Item item){
        for(Object i : this ){
            DoubleNode dn = (DoubleNode) i;
            if(dn.item == item){
                return dn;
            }
        }
            return null;
    }

    public static void insertBefore(DoubleList l, DoubleNode bnode, DoubleNode node){
        for(Object dn : l){
            DoubleNode n = (DoubleNode) dn;
            if(n.equals(bnode)){
                StdOut.println("insertBefore for: " + dn);
                if(bnode.prev == null){
                    node.next = bnode;
                    node.prev = null;
                    bnode.prev = node;
                    l.first = node;
                }else{
                    node.next = bnode;
                    node.prev = bnode.prev;
                    bnode.prev.next = node;
                    bnode.prev = node;
                }
                l.n++;
            }
        }
    }

    public static void insertAfter(DoubleList l, DoubleNode bnode, DoubleNode node){
        for(Object dn : l){
            DoubleNode n = (DoubleNode) dn;
            if(n.equals(bnode)){
                StdOut.println("insertAfter for: " + dn);
                if(bnode.next == null){
                    node.prev = bnode;
                    node.next = null;
                    bnode.next = node;
                    l.last = node;
                }else{
                    node.prev = bnode;
                    node.next = bnode.next;
                    bnode.next.prev = node;
                    bnode.next = node;
                }
                l.n++;
            }
        }
    }

    public static DoubleNode remove(DoubleList l, DoubleNode node){
        for(Object dn : l){
            DoubleNode n = (DoubleNode) dn;
            if(dn.equals(node)){
                StdOut.println("remove for: " + dn);
                if(node.prev == null && node.next == null){
                    l.first = l.last = null;
                }else if(node.prev == null){
                    l.first = node.next;
                    node.next.prev = null;
                }else if(node.next == null){
                    l.last = node.prev;
                    node.prev.next = null;
                }else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                l.n--;
            }
        }
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DoubleListIterator();
    }

    // Iterator class
    private class DoubleListIterator implements Iterator {

        private DoubleNode current = first;

        @Override
        public boolean hasNext() {
            if(current != null){
                return true;
            }
            return false;
        }

        @Override
        public DoubleNode<Item> next() {
            DoubleNode<Item> item = (DoubleNode)current;
            current = current.next;
            return item;
        }

        public void remove() {}
    }

    public static void main(String [] args){
        DoubleList<Integer> dl = new DoubleList<Integer>();


        DoubleNode dn2 = new DoubleNode();
        dn2.item = 2;
        insertEnd(dl, dn2);

        DoubleNode dn0 = new DoubleNode();
        dn0.item = 0;
        insertBegin(dl, dn0);

        DoubleNode dn1 = new DoubleNode();
        dn1.item = 1;
        insertBegin(dl, dn1);

        //removeBegin(dl);
        //removeBegin(dl);
        //removeBegin(dl);
        //removeEnd(dl);

        dl.listPrint();
        //dl.listPrintr();
        StdOut.println(dl.getNodeByItem(dl, 2));
        remove(dl, dl.getNodeByItem(dl, 1));

        dl.listPrint();

        DoubleNode dn3 = new DoubleNode();
        dn3.item = 21;
        insertEnd(dl, dn3);

        dl.listPrint();


        DoubleNode dn4 = new DoubleNode();
        dn4.item = 27;
        insertBefore(dl, dl.getNodeByItem(dl, 21), dn4);

        dl.listPrint();
        //dl.listPrintr();

        DoubleNode dn5 = new DoubleNode();
        dn5.item = 29;
        insertAfter(dl, dl.getNodeByItem(dl, 2), dn5);

        dl.listPrint();
    }
}
