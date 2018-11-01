package algs.ch54;

import edu.princeton.cs.algs4.*;

/**
 * Created by mitya on 7/22/17.
 */
public class NFA18 {
    private char [] re;
    private Digraph G;
    private int M;
    public NFA18(String regexp) { // create nfa for regex
        Stack<Integer> ops = new Stack<Integer>();
        //re = regexp.toCharArray();
        re = preprocess(regexp);
        M = re.length;
        G = new Digraph(M + 1);
        for(int i = 0; i < M; i++) {
            int lp = i;
            if(re[i] == '(' || re[i] == '|')
                ops.push(i);
            else if(re[i] == ')') {
                int or = ops.pop();
                Bag<Integer> ors = new Bag<Integer>();
                while (re[or] == '|') {
                    //G.addEdge(lp, or + 1);
                    ors.add(or);
                    G.addEdge(or, i);
                    or = ops.pop();
                }
                lp = or;
                for (int v : ors)
                    G.addEdge(lp, v + 1);
            }
            if(i < M - 1 && re[i + 1] == '*') {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if(re[i] == '(' || re[i] == '*' || re[i] == ')')
                G.addEdge(i, i + 1);
        }
    }

    private char [] preprocess(String regexp) {
        int N = regexp.length();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < N; i++) {
            if (regexp.charAt(i) == '+') {
                Stack<Character> copy1 = new Stack<Character>();
                Stack<Character> copy2 = new Stack<Character>();
                int parN = 0;
                char curr = stack.pop();
                copy1.push(curr);
                copy2.push(curr);
                if(curr == ')') parN++;
                while (parN != 0) {
                    curr = stack.pop();
                    stack.push(curr);
                    stack.push(curr);
                    if(curr == ')') parN++;
                    else if (curr == ')') parN--;
                }
                while (!copy1.isEmpty())
                    stack.push(copy1.pop());
                while (copy2.isEmpty())
                    stack.push(copy1.pop());
                stack.push('*');
            } else {
                stack.push(regexp.charAt(i));
            }
        }

        char [] result = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public boolean recognizes(String txt) {
        Bag<Integer> pc = new Bag<Integer>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for(int v = 0; v < G.V(); v++)
            if (dfs.marked(v))
                pc.add(v);

        for(int v : pc)
            StdOut.println(v);

        StdOut.println(G.toString());

        for(int i = 0; i < txt.length(); i++) { // calculate nfs state for txt[i + 1]
            Bag<Integer> match = new Bag<Integer>();
            for(int v : pc)
                if(v < M)
                    if(re[v] == txt.charAt(i) || re[v] == '.')
                        match.add(v + 1);
            pc = new Bag<Integer>();
            dfs = new DirectedDFS(G, match);
            for(int v = 0; v < G.V(); v++)
                if(dfs.marked(v)) pc.add(v);
        }

        StdOut.println("-----------------------------------------");
        //
        for(int v : pc)
            StdOut.println(v);

        StdOut.println("M: " + M);
        for(int v : pc) if (v == M) return true;
        return false;
    }
}
