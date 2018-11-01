package algs.ch51;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by mitya on 4/30/17.
 */
public class QueueMSD {
    private static int R;
    public static void sort(String [] a) {
        R = 256;
        int N = a.length;
        Queue<String> queue = new Queue<String>();
        for(int i = 0; i < N; i++) {
            queue.enqueue(a[i]);
        }

        queue = sort(queue, 0);
        int i = 0;
        while (queue!= null && !queue.isEmpty())
            a[i++] = queue.dequeue();
    }

    private static Queue<String> sort(Queue<String> queue, int d) {
        if(queue == null || queue.size() <= 1)
            return queue;

        Queue<String> [] queues = new Queue[R + 1];

        while (!queue.isEmpty()) {
            String s = queue.dequeue();
            int v = charAt(s, d);
            if(queues[v + 1] == null)
                queues[v + 1] = new Queue<String>();
            queues[v + 1].enqueue(s);
        }

        Queue<String> result = new Queue<String>();
        while(queues[0] != null && !queues[0].isEmpty() )
            result.enqueue(queues[0].dequeue());


        for(int i = 0; i < R; i++) {
            queue = sort(queues[i], d + 1);
            while (queue != null && !queue.isEmpty())
                result.enqueue(queue.dequeue());
        }

        return result;
    }

    private static int charAt(String s, int d) {
        if(d < s.length()) return s.charAt(d);
        return -1;
    }

    public static void main(String [] args) {
        In in = new In("/home/mitya/IdeaProjects/Sedgewick/out/production/Sedgewick/shells.txt");
        int N = 14;
        String[] a = new String[N];
        for (int i = 0; i < N; ++i) {
            a[i] = in.readString();
        }

        StdRandom.shuffle(a);
        sort(a);
        StdOut.println(Arrays.toString(a));
    }
}
