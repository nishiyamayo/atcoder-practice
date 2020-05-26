package abc061;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;
    long INF = 1L << 60;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt();
        Edge[] es = new Edge[m];
        for (int i = 0; i < m; i++) {
            es[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1, -sc.nextInt());
        }

        Optional<Long> ans = bellmanFord(n, es, 0, n - 1);

        out.println(ans.map(x -> "" + (-x)).orElse("inf"));

        out.flush();
    }

    Optional<Long> bellmanFord(int n, Edge[] es, int src, int dst) {
        boolean[] updated = new boolean[n];

        long[] d = new long[n];

        Arrays.fill(d, INF);
        d[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge e : es) {
                if (d[e.t] > d[e.f] + e.c) {
                    d[e.t] = d[e.f] + e.c;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (Edge e : es) {
                if (d[e.t] > d[e.f] + e.c) {
                    d[e.t] = d[e.f] + e.c;
                    updated[e.t] = true;
                }
                if (updated[e.f]) {
                    updated[e.t] = true;
                }
            }
        }

        if (updated[dst])
            return Optional.empty();
        return Optional.of(d[dst]);
    }



    class Edge {
        int f, t;
        long c;
        Edge(int f, int t, long c) {
            this.f = f;
            this.t = t;
            this.c = c;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}