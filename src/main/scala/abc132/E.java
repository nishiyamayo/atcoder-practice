package abc132;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {

    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Edges[] g = new Edges[n];

        for (int i = 0; i < n; i++) g[i] = new Edges();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            g[u].add(v);
        }

        int s = sc.nextInt() - 1, t = sc.nextInt() - 1;
        System.out.println(dijkstra(g, s, t, n));
    }

    int INF = 1 << 28;
    int dijkstra(Edges[] g, int s, int t, int n) {
        int[][] d = new int[n][3];
        for (int i = 0; i < n; i++) Arrays.fill(d[i], INF);
        PriorityQueue<Node> q = new PriorityQueue<>();

        q.add(new Node(s, 2));
        d[s][2] = 2;
        while (!q.isEmpty()) {
            Node cur = q.remove();
//            debug(cur.idx, cur.c);
            if (d[cur.idx][cur.c % 3] != cur.c) continue;
            if (cur.idx == t && cur.c % 3 == 2) return cur.c / 3;

            for (int next: g[cur.idx]) if (d[next][(cur.c + 1) % 3] > cur.c + 1) {
                q.add(new Node(next, cur.c + 1));
                d[next][(cur.c + 1) % 3] = cur.c + 1;
            }

        }
        return -1;
    }

    class Node implements Comparable<Node> {
        int idx, c;

        Node(int idx, int c) {
            this.idx = idx;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return c - o.c;
        }
    }

    class Edges extends ArrayList<Integer> {}

    class Edge {
        int t, c;
        Edge(int t, int c) {
            this.t = t;
            this.c = c;
        }
    }

    static void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
