package algs.ch1;

import edu.princeton.cs.algs4.LinkedQueue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by mitya on 5/21/16.
 */
public class LUF<Item> {

    private int count;
    LinkedList<LinkedList<Integer>> startPointList;

    LUF(){
       startPointList  = new LinkedList<LinkedList<Integer>>();
    }

    public int count() {
        return count;
    }

    public LinkedList<Integer> find(int p) {
        boolean f = false;
        int e = 0;
        Iterator i = startPointList.iterator();
        while(i.hasNext()){
            LinkedList<Integer> currList = (LinkedList<Integer>)i.next();
                Iterator j = currList.iterator();
            while (j.hasNext()){
                e = (Integer)j.next();
                if(p == e){
                    f = true;
                }
            }
            if(f){
                return currList;
            }
        }

        return null;
    }

    public void union(int p, int q) {
        LinkedList<Integer> pRoot = find(p);
        LinkedList<Integer> qRoot = find(q);
        count++;
        if(pRoot == null && qRoot == null){
            LinkedList<Integer> c = new LinkedList<Integer>();
            c.add(p);
            c.add(q);
            startPointList.addLast(c);
            count--;
            return;
        }else if(pRoot == null && qRoot != null){
            count--;
            qRoot.addFirst(p);
        } else if(qRoot == null && pRoot != null){
            count--;
            pRoot.addFirst(q);
        }else{
            pRoot.addAll(qRoot);
            startPointList.remove(qRoot);
            count--;
        }

        if(pRoot == qRoot)
            return;

    }

    public boolean connected(int p, int q) {
        if(find(p) == find(q) && (find(p) != null && find(q) != null))
            return true;
        return false;
    }

    public void printId(){
        Iterator i = startPointList.iterator();
        while(i.hasNext()){
            LinkedList<Integer> currList = (LinkedList<Integer>)i.next();
                Iterator j = currList.iterator();
            while (j.hasNext()){
                StdOut.print((Integer)j.next() + " ");
            }
            StdOut.println();
        }
    }
}
