package algs.ch1;

//import sun.org.mozilla.javascript.internal.ast.ErrorNode;

import java.util.Iterator;

/**
 * Created by mitya on 12/26/15.
 */
public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int n;
    private int cntOp = 0;
    private class Node {
        Item item;
        Node next;
    }

    Stack(){

    }

    Stack(Stack s){
        int ns = s.size();
        Item  item;
        Stack r = this;
        Stack t = new Stack();
        while(!s.isEmpty()){
            item = (Item)s.pop();
            t.push(item);
        }
        while (!t.isEmpty()){
            item = (Item)t.pop();
            r.push(item);
            s.push(item);
        }
    }

    public void concatenate(Stack<Item> s){
        Stack t = new Stack<Item>();
        while(!s.isEmpty()){
            t.push(s.pop());
        }

        while(!t.isEmpty()){
            this.push((Item)t.pop());
        }

        t = null;

        /*
        for(Node x = first; x.next != null; x = x.next){

        }
        */
    }

    public boolean isEmpty(){
        if(first == null){
            return true;
        }
        return false;
    }

    public int size(){
        return n;
    }

    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
        cntOp++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        --n;
        cntOp++;
        return item;
    }

    public Item peek(){
        Item item = first.item;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;
        private int cnt = cntOp;

        @Override
        public boolean hasNext() {
            if(cnt != cntOp){ throw new IllegalArgumentException("Pop or Push op invoke");}
            if(current != null){
                return true;
            }
            return false;
        }

        @Override
        public Item next() {
            if(cnt != cntOp){ throw new IllegalArgumentException("Pop or Push op invoke");}
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove(){

        }
    }
}
