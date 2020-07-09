package past003;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class M {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public M() {
        this(System.in, System.out);
    }

    public M(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int n, k;
    Edge[] g;
    int[] t;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        int m = sc.nextInt();
        g = new Edge[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }

        int s = sc.nextInt() - 1;
        k = sc.nextInt() + 1;
        t = new int[n];
        t[0] = s;
        for (int i = 1; i < k; i++) {
            t[i] = sc.nextInt() - 1;
        }

        bfs();

        mem = new int[1 << k][k];
        out.println(solve(1, 0));

        out.flush();
    }

    int INF = 1 << 28;
    int[][] mem;
    int solve(int S, int idx) {
        if (S == (1 << k) - 1) {
            return 0;
        }

        if (mem[S][idx] > 0) return mem[S][idx];

        int min = INF;
        for (int i = 0; i < k; i++) {
            if (((S >> i) & 1) == 0) {
                min = Math.min(min, solve(S | (1 << i), i) + dirs[idx][i]);
            }
        }

        return mem[S][idx] = min;
    }

    int[][] dirs;

    void bfs() {
        dirs = new int[k][k];

        for (int i = 0; i < k; i++) {
            int s = t[i];
            int[] d = new int[n];
            Arrays.fill(d, n);
            LinkedList<Integer> q = new LinkedList<>();
            q.addLast(s);
            d[s] = 0;
            while (!q.isEmpty()) {
                int cur = q.removeFirst();

                for (int next : g[cur]) {
                    if (d[next] > d[cur] + 1) {
                        d[next] = d[cur] + 1;
                        q.addLast(next);
                    }
                }
            }
            for (int j = 0; j < k; j++) {
                dirs[i][j] = d[t[j]];
            }
        }
    }

    class Edge extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new M().run();
    }
}