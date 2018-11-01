package algs.ch41;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by mitya on 1/6/17.
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private int V;
    private int E;
    private Bag<Integer> [] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Integer>();
    }

    /*
    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
    */

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        in.readLine();
        while(in.hasNextLine()) {
            String[] a = in.readLine().split(" ");
            int v = Integer.parseInt(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = Integer.parseInt(a[i]);
                //adj[v].add(w);
                //adj[w].add(v);
                addEdge(v, w);
            }
        }
    }

    public Graph(Graph that) {
        this(that.V());
        E = that.E();
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
            for(int w : this.adj(i))
                adj[i].add(w);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public boolean hasEdge(int v, int w) {
        for(int x : adj(v))
            if(x == w)
                return true;
        return false;
    }

    public int V() { return  V; }
    public int E() { return  E; }

    public Iterable<Integer> adj(int v) {
        return adj[v];
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

    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        Graph graph2 = new Graph(graph);
        graph2.addEdge(0, graph2.V() - 1);
        StdOut.println(graph);
        StdOut.println("\n" + graph2);
        StdOut.println(graph2.hasEdge(4, 3));
        StdOut.println(graph2.hasEdge(7, 9));
    }
}
