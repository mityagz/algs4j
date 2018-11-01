package algs.ch51;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by mitya on 5/6/17.
 */
public class Quick3StringLinkedList {
    private static int ii = 0;
    private static void exch(LinkedList<String> a, Node i, Node j) {
        a.exch(i, j);
    }

    private static int charAt(String s, int d) {
        if(d < s.length())
            return s.charAt(d);
        else return -1;
    }

    public static void sort(LinkedList<String> a) {
        sort(a, a.getHead(), a.getTail(), 0);
    }

    /*
    private static void sort(String [] a, int lo, int hi, int d) {
        if(hi <= lo) return;
        int lt = lo;
        int gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if(t < v) exch(a, lt++, i++);
            else if(t > v) exch(a, i, gt--);
            else i++;
        }

        sort(a,lo, lt - 1, d);
        if(v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }
    */

    private static void sort(LinkedList<String> a, Node<String> lo, Node<String> hi, int d) {
        if(lo == hi) return;
        Node<String> lt = new Node<String>(); lt = lo;
        Node<String> gt = new Node<String>(); gt = hi;
        int v = charAt(lo.getData(), d);
        Node<String> i = lo.next;
        Node<String> tn;
        while (!i.equals(gt)) {
            int t = charAt(i.getData(), d);
            if (t < v) {
                exch(a, lt, i);
                if(lt.equals(lo)) lo = i;
                tn = i;
                i = lt;
                lt = tn;
                lt = lt.next;
                i = i.next;
            } else if (t > v) {
                exch(a, i, gt);
                if (gt.equals(hi)) hi = gt;
                tn = i;
                i = gt;
                gt = tn;
                gt = gt.prev;
            } else {
                i = i.next;
            }

            //StdOut.println("v: " + v + " t:" + t + " lt: " + lt.getData() + " i:" + i.getData() + " gt:" + gt.getData() + " d:" + d);
            //StdOut.println("v: " + v + " t:" + t + " lt: " + lt.getData() + " i:" + i.getData() + " i.prev: " + i.prev.getData() +  " i.next: " + i.next.getData() + " gt:" + gt.getData() + " d:" + d);
                Iterator<String> is = a.iterator();
                is = a.iterator();
                while (is.hasNext()) {
                    StdOut.println(is.next());
                }

            StdOut.println("-----------------");

        }

        /*
        Iterator<String> is = a.iterator();
        is = a.iterator();
        while (is.hasNext()) {
            StdOut.println(is.next());
        }
        */

        sort(a, lo, lt.prev, d);
        if(v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt.next, hi, d);

    }

    public static void main(String [] args) {
        int i = 0;
        LinkedList<String> ll = new LinkedList<String>();
        String [] s = new String[Integer.parseInt(args[0])];
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            ll.add(name);
        }


        Iterator<String> is = ll.iterator();
        while (is.hasNext()) {
            StdOut.println(is.next());
        }


        StdOut.println("---");
        StdOut.println("HeadTail: " + ll.getHead().data + " " + ll.getTail().data);

        sort(ll);

        /*

        ll.exch(ll.getHead(), ll.getTail());
        ll.exch(ll.getHead().next, ll.getTail().prev);
        ll.exch(ll.getHead().next.next, ll.getTail().prev.prev);

        /*
        StdOut.println("---");
        is = ll.iterator();
        while (is.hasNext()) {
            StdOut.println(is.next());
        }

        StdOut.println("---");
        StdOut.println("HeadTail: " + ll.getHead().data + " " + ll.getTail().data);

        StdOut.println("---");
         StdOut.println("HeadTail: " + ll.getHead().data + " " + ll.getTail().data);
        ll.exch(ll.getHead().next, ll.getTail().prev);


        */

        is = ll.iterator();
        while (is.hasNext()) {
            StdOut.println(is.next());
        }

        StdOut.println("---");
        StdOut.println("HeadTail: " + ll.getHead().data + " " + ll.getTail().data);
    }
}
