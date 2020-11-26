package past004;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class J {
    long MOD = (long) 1e9 + 7;
    long INF = 1L << 60;

    InputStream in = System.in;
    OutputStream out = System.out;

    int n, m;
    long[][] costs;
    String s;
    Edges[] g;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        n = sc.nextInt(); m = sc.nextInt();
        costs = new long[3][3];
        costs[0][1] = costs[1][0] = sc.nextInt();
        costs[0][2] = costs[2][0] = sc.nextInt();
        costs[1][2] = costs[2][1] = sc.nextInt();
        costs[0][0] = costs[1][1] = costs[2][2] = INF;
        s = sc.next();
        g = new Edges[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edges();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt();
            g[a].add(new Edge(b, c));
            g[b].add(new Edge(a, c));
        }

        out.println(dijkstra());

        out.flush();
    }

    long dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0));

        long[] d = new long[n];
        Arrays.fill(d, INF);
        d[0] = 0;

        boolean[] ws = new boolean[3];

        while (!q.isEmpty()) {
            Node cur = q.remove();
            if (d[cur.cur] != cur.cost) continue;
//            debug(cur.cur, cur.cost);

            for (Edge next : g[cur.cur]) {
                if (d[next.to] > cur.cost + next.cost) {
                    d[next.to] = cur.cost + next.cost;
                    q.add(new Node(next.to, cur.cost + next.cost));
                }
            }

            int c = s.charAt(cur.cur) - 'A';
            if (!ws[c]) {
                for (int i = 0; i < n; i++) {
                    int t = s.charAt(i) - 'A';
                    if (c != t) {
                        if (d[i] > cur.cost + costs[c][t]) {
                            d[i] = cur.cost + costs[c][t];
                            q.add(new Node(i, cur.cost + costs[c][t]));
                        }
                    }
                }
                ws[c] = true;
            }
        }
        return d[n - 1];
    }

    class Node implements Comparable<Node> {

        int cur;
        long cost;

        Node(int cur, long cost) {
            this.cur = cur;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(cost, o.cost);
        }
    }

    class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    class Edges extends ArrayList<Edge> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new J().run();
    }
}
