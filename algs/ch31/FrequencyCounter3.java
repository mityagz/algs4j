package algs.ch31;

import edu.princeton.cs.algs4.IndexMaxPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;
import java.nio.file.Files;

/**
 * Created by mitya on 11/3/16.
 */
public class FrequencyCounter3 {
    public static void main(String [] args) throws FileNotFoundException {
        File f = new File(args[0]);
        String line = null;
        if (!f.exists()) {
            StdOut.println(f.getName() + " don't exist");
            return;
        }

        ST<String, Integer> st = new BinarySearchST<String, Integer>(50);
        SequentialSearchST<String, Integer> stU = new SequentialSearchST<String, Integer>();

        InputStream in = null;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
            line = null;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (!st.contains(words[i])) {
                        st.put(words[i], 1);
                    } else {
                        st.put(words[i], st.get(words[i]) + 1);
                    }

                    if (!stU.contains(words[i])) {
                        stU.put(words[i], 1);
                    } else {
                        stU.put(words[i], stU.get(words[i]) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        ST<Integer, String> stRev = new BinarySearchST<Integer, String>(500);


        for (String word : st.keys()) {
            stRev.put(st.get(word), word);
        }

        String max = "";
        st.put(max, 0);

        while(!stRev.isEmpty()) {
            StdOut.println("Word : frequency " + stRev.max() + " " + stRev.get(stRev.max()));
            stRev.deleteMax();
        }
        /*
        for (String word : st.keys()) {
            StdOut.println("Word : frequency " + word + " " + st.get(word));
        }
        */


        StdOut.println("-------------------------------------------------------");

        for (String word : stU.keys()) {
            StdOut.println("Word : frequency " + word + " " + st.get(word));
            /*
            if (st.get(word) > st.get(max))
                max = word;
                */
        }

    }
}
