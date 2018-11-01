package algs.ch42;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 2/10/17.
 */
public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;
    private int E;
    private Bag<Integer>[] adj;
    int indegree[];

    Digraph(int V) {
        this.V = V;
        this.E = 0;
        indegree = new int[V];

        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        //indegree = new int[V];

        in.readLine();

        /*
        while(in.hasNextLine()) {
            String[] a = in.readLine().split(" ");
            //StdOut.println(a[0]);
            int v = Integer.parseInt(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = Integer.parseInt(a[i]);
                addEdge(v, w);
            }
        }
        */

        for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }

    }

    public Digraph(Digraph that) {
        this(that.V());
        E = that.E();
        for (int v = 0; v < V; v++)
            this.indegree[v] = that.indegree(v);

        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
            for(int w : this.adj(i))
                adj[i].add(w);
        }
    }

    public int V() { return V; }

    public int E() { return  E;}

    public void addEdge(int v, int w) {
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public boolean hasEdge(int v, int w) {
        for(int x : adj(v))
            if(x == w)
                return true;
        return false;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph r = new Digraph(V);
        for(int v = 0; v < V; v++) {
            for(int w : adj(v)) {
                r.addEdge(w, v);
            }
        }
        return r;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public int indegree(int v) {
        return indegree[v];
    }

    public int outdegree(int v) {
        return adj[v].size();
    }

    public static void main(String[] args) {
        Digraph graph = new Digraph(new In(args[0]));
        Digraph graph2 = new Digraph(graph);
        graph2.addEdge(0, graph2.V() - 1);
        StdOut.println(graph);
        StdOut.println("\n" + graph2);
        StdOut.println(graph2.hasEdge(4, 3));
        StdOut.println(graph2.hasEdge(7, 9));
    }
}
