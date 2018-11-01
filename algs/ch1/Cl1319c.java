package algs.ch1;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/2/16.
 */
public class Cl1319c<Item> {
    private int n;
    private Node first;
    private class Node<Item> {
        Item item;
        Node next;
    }

    public void removeLast(){
        Node prev = null;
        for(Node x = first; x.next != null; x = x.next){
           prev = x;
        }
        prev.next = null;
    }

    public void delete(int k){
        int i = 1;
        Node prev = null;
        for(Node x = first; x.next != null; x = x.next){
            if(i + 1 == k){
                prev = x;
                break;
            }
           i++;
        }
        prev.next = prev.next.next;
    }

    public boolean find(Item key){
        for(Node x = first; x != null; x = x.next){
            if(x.item == key)
            return true;
        }
        return false;
    }

    public Node getNode(Item key){
        for(Node x = first; x != null; x = x.next){
            if(x.item == key)
            return x;
        }
        return null;
    }

    public Node getFirst(){
        return first;
    }

    public void listPrint(){
        StdOut.println(first);
        for(Node x = first; x != null; x = x.next){
            StdOut.println("Item: " + x.item);
        }
    }

    public void removeAfter(Node x){
        if(x != null && x.next != null){
             x.next = x.next.next;
        }
    }

    public Node newNode(Item i){
        Node x = new Node();
        x.item = i;
        return x;
    }

    public void insertAfter(Node x, Node y){
        if( x != null && y != null){
            //Node t_next = x.next;
            y.next = x.next;
            x.next = y;
        }
    }

    Cl1319c(){
        Node<Integer> x = new Node<Integer>();
        first = x;
        first.item = 0;
        int i = 1;
        while(i < 10){
            x.next = new Node();
            x.next.item = i;
            x = x.next;
            i++;
        }
    }

    public void remove(Item k){
        Node prev = null;
        if(first.item == k){
            first = first.next;
        }
        for(Node x = first; x != null; x = x.next) {
            if(x.next != null && x.next.item == k){
                x.next = x.next.next;
            }
        }
    }


    public Item max(Node f){
        Integer max = 0;
        Integer t = 0;
        for(Node x = f; x != null; x = x.next){
            t = (Integer)(x.item);
            if(t > max)
                max = t;
        }
        return (Item)max;
    }

    //Integer max = 0;
    public Item maxr(Node x, Integer max){
        Integer t;
        t = (Integer)x.item;
        if(t > max)
            max = t;
        if(x.next == null){
            return (Item)max;
        }
        return maxr(x.next, max);
    }

    public static void main(String [] args){
        Cl1319c f = new Cl1319c();
        f.listPrint();
        f.removeLast();
        f.listPrint();
        f.delete(5);
        f.listPrint();
        StdOut.println("Key: " + f.find(9));
        StdOut.println(f.getNode(8));
        f.removeAfter(f.getNode(2));
        f.listPrint();
        f.insertAfter(f.getNode(5), f.newNode(777));
        f.listPrint();
        f.remove(0);
        f.remove(7);
        f.remove(8);
        f.listPrint();
        StdOut.println("Max: " + f.maxr(f.getFirst(), 0));
    }
}
