package abc190;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int n = sc.nextInt(), m = sc.nextInt();
        Edge[] g = new Edge[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        k = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < k; i++) {
            c[i] = sc.nextInt() - 1;
        }

        ds = new int[k + 1][k + 1];
        for (int i = 0; i < k; i++) {
            int[] d = bfs(c[i], n, g);
            for (int j = 0; j < k; j++) {
                ds[i][j] = d[c[j]];
            }
        }
        for (int i = 0; i < k; i++) {
            ds[k][i] = ds[i][k] = 1;
        }

        memo = new int[1 << (k + 1)][k + 1];
        for (int[] a : memo) Arrays.fill(a, -1);
        int ret = solve(1 << k, k);

        out.println(ret == 1 << 28 ? -1 : ret);

        out.flush();
    }

    int k;
    int[][] ds;
    int[][] memo;
    int solve(int S, int to) {
        if (memo[S][to] >= 0) return memo[S][to];
        if (S == (1 << (k + 1)) - 1) {
            return memo[S][to] = 0;
        }

        int ret = 1 << 28;
        for (int i = 0; i < k; i++) {
            if (((S >> i) & 1) == 0) {
                if (ds[to][i] < 0) continue;
                ret = Math.min(ret, solve(S | (1 << i), i) + ds[to][i]);
            }
        }

        return memo[S][to] = ret;
    }

    int[] bfs(int s, int n, Edge[] g) {
        int[] ds = new int[n];
        Arrays.fill(ds, -1);
        ds[s] = 0;
        LinkedList<Pair> q = new LinkedList<>();
        q.addFirst(new Pair(s, 0));
        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();
            for (int nx : g[cur.nx]) {
                if (ds[nx] >= 0) continue;
                q.addLast(new Pair(nx, cur.c + 1));
                ds[nx] = cur.c + 1;
            }
        }

        return ds;
    }

    class Pair {
        int nx, c;
        Pair(int nx, int c) {
            this.nx = nx;
            this.c = c;
        }
    }

    class Edge extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
