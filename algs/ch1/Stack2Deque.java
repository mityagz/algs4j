package algs.ch1;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mitya on 3/12/16.
 */
public class Stack2Deque<Item> implements Iterable {
    Stack<Item> s0;
    Stack<Item> s1;
    Stack<Item> s2;
    Item r;

    Stack2Deque(){
        s0 = new Stack<Item>();
        s1 = new Stack<Item>();
        s2 = new Stack<Item>();
    }

    public int size(){
        return s0.size() + s1.size();
    }

    public boolean isEmpty(){
        if(s0.isEmpty() && s1.isEmpty()) {
            return true;
        }
        return false;
    }

    public void pushLeft(Item item){
        s0.push(item);
    }

    public void pushRight(Item item){
        s1.push(item);
    }

    public Item popLeft(){
        if(!s0.isEmpty()){
            return s0.pop();
        }else {
            if(!s1.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                r = s2.pop();
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
                return r;
            }else{
                //throw new NoSuchElementException();
                return null;
            }
        }
    }

    public Item popRight(){
        if(!s1.isEmpty()) {
            return s1.pop();
        }else {
            if(!s0.isEmpty()){
                while(!s0.isEmpty()){
                    s2.push(s0.pop());
                }
                r = s2.pop();
                while(!s2.isEmpty()){
                    s0.push(s2.pop());
                }
                return r;
            }else{
                //throw new NoSuchElementException();
                return null;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public static void main(String [] args){
        Stack2Deque<Integer> sd = new Stack2Deque<Integer>();
        sd.pushLeft(10);
        sd.pushLeft(13);
        sd.pushRight(77);
        sd.pushRight(18);
        StdOut.println(sd.popRight());
        StdOut.println(sd.popRight());
        StdOut.println(sd.popRight());
        StdOut.println(sd.popRight());
    }
}
