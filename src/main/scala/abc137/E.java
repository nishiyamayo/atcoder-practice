package abc137;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {

    long INF = 1 << 28;

    Edges[] g, rg;
    Edges[] r;
    int n;
    int p;

    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        p = sc.nextInt();
        g = new Edges[n];
        rg = new Edges[n];

        for (int i = 0; i < n; i++) {
            g[i] = new Edges();
            rg[i] = new Edges();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt();
            g[a].add(new Edge(b, c));
            rg[b].add(new Edge(a, c));
        }
    }

    void build()

    ArrayList<Integer> order = new ArrayList<>();
    void dfs(int idx, boolean[] visited) {
        visited[idx] = true;
        for (Edge e: g[idx]) if (!visited[e.to]) {
            dfs(e.to, visited);
        }
        order.add(idx);
    }

    int[] comp;
    void rdfs(int idx, int cnt) {
        if (comp[idx] != -1) return;
        comp[idx] = cnt;
        for (Edge e: rg[idx]) rdfs(e.to, cnt);
    }


    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    class Edges extends ArrayList<Edge> {}

    class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    class P {
        int cur, cnt;
        long cost;
        P(int cur, int cnt, long cost) {
            this.cur = cur;
            this.cnt = cnt;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        new E().run();
    }
}
