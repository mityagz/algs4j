package algs;

import java.util.Arrays;

import edu.princeton.cs.algs4.*;


/**
 * Created by mitya on 11/21/15.
 */
public class BinarySearch {
    public static int indexOf(int [] a, int key,  Counter cnt){
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]){
                hi = mid -1;
            }
            else if(key > a[mid]){
                lo = mid + 1;
            }
            else return mid;
            cnt.increment();
        }
        return -1;
    }

    public static int rank(int key, int [] a, Counter cnt){
        return indexOf(a, key, cnt);
    }

    public static int rank_recursive(int key, int [] a, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        if(lo > hi) return -1;
        if(key < a[mid]) return rank_recursive(key, a, lo, mid - 1 );
        else if(key > a[mid]) return rank_recursive(key, a, mid + 1, hi);
        else return mid;
    }

    public static int rank_recursive2(int key, int [] a, int lo, int hi, int deep){
        deep++;
        int mid = lo + (hi - lo) / 2;

        /*
        StdOut.printf("%" + deep + "d %d\n-------------------\n", deep, key);
        StdOut.printf("%" + deep + "d %d\n", lo, a[lo]);
        StdOut.printf("%" + deep + "d %d\n", mid, a[mid]);
        StdOut.printf("%" + deep + "d %d\n\n", hi, a[hi]);
        */

        if(lo > hi) return -1;
        if(key < a[mid]) return rank_recursive2(key, a, lo,mid - 1, deep);
        else if(key > a[mid]) return rank_recursive2(key, a, mid + 1, hi, deep);
        else return mid;
    }

    public static int rank_count(int key, int [] a){
        return rank_recursive(key, a, 0, a.length) - 1;
    }


    public static int [] uniqsort(int [] a){
        int tail = a.length;
        for(int i = 0; i < tail; i++){
            if((i+1) < tail)
            if(a[i] == a[i+1]){
                for(int j = i; j <= tail; j++){
                    if((j + 1) < tail) {
                        a[j] = a[j + 1];
                    }
                }
                i--;
                tail--;
            }
        }

        return Arrays.copyOf(a, tail);
    }

    public static void main(String args []){
        In in = new In(args[0]);
        int [] whitelist = in.readAllInts();
        Counter cnt = new Counter("cnt");


        // sorting and remove dup from array
        Arrays.sort(whitelist);
        whitelist = uniqsort(whitelist);

        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();

            // non recursive variant
            if(rank(key, whitelist, cnt) < 0) {
                StdOut.println(key);
            }


            // recursive variant
            int lo = 0;
            int hi = whitelist.length - 1;
            if(args.length == 2){
                if(Integer.parseInt(args[1]) < 0){
                    if(rank_recursive2(key, whitelist, lo, hi, 0) < 0){
                        StdOut.println(key);
                    }
                }else{
                    if(rank_recursive2(key, whitelist, lo, hi, 0) > 0){
                        StdOut.println(key);
                    }
                }

            }else {
                if (rank_recursive2(key, whitelist, lo, hi, 0) < 0) {
                    StdOut.println(key);
                }
            }
        }
        StdOut.println("Key cnt: " + cnt.tally());
        StdOut.println(rank_count(23, whitelist));
    }
}
