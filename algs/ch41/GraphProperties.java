package algs.ch41;

import edu.princeton.cs.algs4.Queue;

/**
 * Created by mitya on 1/21/17.
 */
public class GraphProperties {
    private Graph G;
    private int diameter;
    private int radius = Integer.MAX_VALUE;
    private int center;
    private int[] eccentricities;
    private int girth = Integer.MAX_VALUE;
    private boolean marked[];
    private int[] distTo;
    private int[] edgeTo;

    GraphProperties(Graph G) {
        this.G = G;
        eccentricities = new int[G.V()];
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];

        for(int i = 0; i < G.V(); i++) {
            BreadFirstPaths paths = new BreadFirstPaths(G, i);
            eccentricities[i] = paths.maxDist();
            if(eccentricities[i] > diameter)
                diameter = eccentricities[i];
            if(eccentricities[i] < radius) {
                radius = eccentricities[i];
                center = i;
            }

            for (int j = 0; j < G.V(); j++) {
                marked[j] = false;
                distTo[j] = 0;
                edgeTo[j] = 0;
            }

            distTo[i] = 0;
            bfs(i);
        }
    }

    private void bfs(int s) {
        Queue<Integer> q = new Queue();
        q.enqueue(s);
        marked[s] = true;
        distTo[s] = 0;
        while (!q.isEmpty()) {
            int v = q.dequeue();
                for(int w : G.adj(v)) {
                    if (!marked[w]) {
                        q.enqueue(w);
                        marked[w] = true;
                        edgeTo[w] = v;
                        distTo[w] = distTo[v] + 1;
                    } else {
                        if(w != edgeTo[v] && distTo[v] + distTo[w] + 1 < girth)
                            girth = distTo[v] + distTo[w] + 1;
                    /* else
                        if(w != edgeTo[v] && distTo[v] + distTo[w] + 1 < girth)
                            girth = distTo[v] + distTo[w] + 1;
                            */
                    }
                }
        }
    }

    int eccentricity(int v) {
        return eccentricities[v];
    }

    int diameter() {
        return diameter;
    }

    int radius() {
        return radius;
    }

    int center() {
        return center;
    }

    int girth() { return  girth; }
}
