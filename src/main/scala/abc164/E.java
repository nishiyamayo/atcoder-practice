package abc164;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public E() {
        this(System.in, System.out);
    }

    public E(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int n, m, s;
    Edge[] g;
    int[] C;
    long[] D;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextInt();
        g = new Edge[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1, a = sc.nextInt(), b = sc.nextInt();
            g[u].add(new Node(v, a, b));
            g[v].add(new Node(u, a, b));
        }

        C = new int[n];
        D = new long[n];
        for (int i = 0; i < n; i++) {
            C[i] = sc.nextInt();
            D[i] = sc.nextInt();
        }

        long[][] d = dijkstra();

        for (int i = 1; i < n; i++) {
            long min = INF;
            for (long v : d[i]) {
                min = Math.min(min, v);
            }
            out.println(min);
        }

        out.flush();
    }

    long INF = 1L << 60;
    int MAX = 2500;

    long[][] dijkstra() {
        long[][] d = new long[n][MAX + 1];
        for (long[] a : d)
            Arrays.fill(a, INF);

        PriorityQueue<Value> q = new PriorityQueue<>();

        int s = Math.min(MAX, this.s);
        for (int i = 0; s + i * C[0] <= MAX; i++) {
            d[0][s + i * C[0]] = i * D[0];
            q.add(new Value(0, i * D[0], s + i * C[0]));
        }
        HashSet<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Value cur = q.remove();
            if (cur.v != d[cur.c][cur.s]) continue;
            visited.add(cur.c);

            // 両替の遷移
            if (cur.s + C[cur.c] <= MAX && d[cur.c][cur.s + C[cur.c]] > cur.v + D[cur.c]) {
                d[cur.c][cur.s + C[cur.c]] = cur.v + D[cur.c];
                q.add(new Value(cur.c, cur.v + D[cur.c], cur.s + C[cur.c]));
            }

            for (Node next : g[cur.c]) {

                    if (cur.s < next.a) continue;
                if (d[next.to][cur.s - next.a] > cur.v + next.b) {
                    d[next.to][cur.s - next.a] = cur.v + next.b;
                    q.add(new Value(next.to, cur.v + next.b, cur.s - next.a));
                }
            }
            if (visited.size() == n) break;
        }

        return d;
    }

    class Value implements Comparable<Value> {
        int c;
        long v;
        int s;

        Value(int c, long v, int s) {
            this.c = c;
            this.v = v;
            this.s = s;
        }

        @Override
        public int compareTo(Value o) {
            if (v != o.v)
                return Long.compare(v, o.v);
            return Long.compare(s, o.s);
        }
    }


    class Edge extends ArrayList<Node> {
    }

    class Node {
        int to, a;
        long b;

        Node(int to, int a, long b) {
            this.to = to;
            this.a = a;
            this.b = b;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}