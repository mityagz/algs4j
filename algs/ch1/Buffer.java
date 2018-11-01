package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/30/16.
 */
public class Buffer<Item> {
    private Stack<Item> r;
    private Stack<Item> l;

    Buffer(){
        r = new Stack<Item>();
        l = new Stack<Item>();
    }

    public void insert(Item item){
        l.push(item);
    }

    public Item delete(){
        if(!l.isEmpty()) {
            return l.pop();
        }else{
            return r.pop();
        }
    }

    public void left(int k){
        for(int i = 0; i < k; i++){
            r.push(l.pop());
        }
    }

    public void right(int k){
        for(int i = 0; i < k; i++){
            l.push(r.pop());
        }
    }

    public int size(){
        return l.size() + r.size();
    }


    public static void main(String [] args){
        Buffer b = new Buffer<Character>();

        b.insert('a');
        b.insert('b');
        b.insert('c');
        b.insert('d');
        b.insert('e');
        b.insert('f');

        b.left(3);
        StdOut.println(b.delete());
        StdOut.println(b.delete());
        StdOut.println(b.delete());
        b.right(3);
        StdOut.println(b.delete());
        StdOut.println(b.delete());
        StdOut.println(b.delete());
    }
}
