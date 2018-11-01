package algs.ch31;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 11/1/16.
 */
public class FrequencyCounter2 {
    public static void main(String [] args) {
        int minLen = Integer.parseInt(args[0]);
        Integer last0 = null, last1 = null, last = null;
        boolean f0 = false, f1 = false;
        int cnt = 0;

        //SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        //BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(10);
        //STBase<String, Integer> st = new ArrayST<String, Integer>(10);
        //ST<String, Integer> st = new OrderedSequentialSearchST<String, Integer>();
        //BinarySearchST2<String, Integer> st = new BinarySearchST2<String, Integer>(10);
        STBase<Integer, Integer> st = new HeuristicArrayST<Integer, Integer>(10);
        while (!StdIn.isEmpty()) {
            Integer word = StdIn.readInt();
            //if (word.length() < minLen) continue;
            ;
            if (!st.contains(word)) {
                st.put(word, 1);
                last0 = word;
                f0 = false; f1 = true;
                cnt++;
            }
            else {
                st.put(word, st.get(word) + 1);
                last1 = word;
                f0 = true; f1 = false;
                cnt++;
            }
        }

        /*
        StdOut.println(st.max());
        st.deleteMax();
        StdOut.println(st.max());
        */

        // for test HeuristicArrayST
        for (Integer word : st.keys()) {
            StdOut.println(word + " : " + st.get(word));
        }

        //StdOut.println(st.get("thingnothingstartles"));

        // !for test HeuristicArrayST

        //st.delete("business");
        Integer max = 0;
        st.put(max, 0);
        for (Integer word : st.keys()) {
            StdOut.println(word);
            if (st.get(word) > st.get(max))
                max = word;
        }

        if(!f0 && f1) {
            last = last0;
        }
        else {
            last = last1;
        }
            StdOut.println("Key: " + max + " Value: " + st.get(max));
            StdOut.println("Last word: " + last + " Processed words: " + cnt);

    }
}
