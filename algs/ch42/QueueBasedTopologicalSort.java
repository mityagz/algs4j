package algs.ch42;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by mitya on 2/24/17.
 */
public class QueueBasedTopologicalSort {
    private Digraph G;
    private boolean[] marked;
    private Queue<Integer> sources;
    private Queue<Integer> sort;
    private int[] indegrees;
    private boolean hasTopologicalSort;

    public QueueBasedTopologicalSort(Digraph G) {
        this.G = G;
        indegrees = new int[G.V()];
        marked = new boolean[G.V()];
        sources = new Queue<Integer>();
        sort = new Queue<Integer>();
        hasTopologicalSort = true;

        for(int v = 0; v < G.V(); v++) {
            for(int w : G.adj(v)) {
                indegrees[w]++;
            }
        }

        for(int v = 0; v < G.V(); v++)
            if(indegrees[v] == 0)
                sources.enqueue(v);

        while (!sources.isEmpty()) {
            if(!hasTopologicalSort)
                break;
            int v = sources.dequeue();
            sort.enqueue(v);
            for(int w : G.adj(v)) {
                indegrees[w]--;
                if(indegrees[w] == 0)
                    sort.enqueue(w);
                else if(indegrees[w] < 0) {
                    hasTopologicalSort = false;
                    break;
                }

            }
        }
    }


    public boolean isHasTopologicalSort() {
        return hasTopologicalSort;
    }

    public Iterable<Integer> order() {
        return sort;
    }
}
