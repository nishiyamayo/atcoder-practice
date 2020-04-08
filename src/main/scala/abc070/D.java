package abc070;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int n;
    Edge[] g;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        g = new Edge[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt();
            g[a].add(new Node(b, c));
            g[b].add(new Node(a, c));
        }

        int q = sc.nextInt(), k = sc.nextInt() - 1;
        long[] ds = new long[n];
        dfs(-1, k, 0, ds);

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
            out.println(ds[x] + ds[y]);
        }

        out.flush();
    }

    void dfs(int par, int cur, long d, long[] ds) {
        ds[cur] = d;
        for (Node next : g[cur]) {
            if (next.to == par) continue;
            dfs(cur, next.to, d + next.cost, ds);
        }
    }

    class Edge extends ArrayList<Node> {}

    class Node {
        int to;
        long cost;
        Node(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}