package abc014;

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

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        E[] g = new E[n];
        for (int i = 0; i < n; i++) {
            g[i] = new E();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        LCA lca = new LCA(n, g);
        lca.build(0);
        int[] d = new int[n];
        dfs(0, -1, 0, d, g);

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            int cp = lca.query(a, b);
            out.println(d[a] - d[cp] + d[b] - d[cp] + 1);
        }

        out.flush();
    }

    void dfs(int cur, int par, int dist, int[] d, E[] g) {
        d[cur] = dist;

        for (int next : g[cur]) {
            if (next == par) continue;
            dfs(next, cur, dist + 1, d, g);
        }
    }


    class LCA {
        int n;
        int[][] table;
        int[] dep;
        E[] g;
        int[] glen;
        int LOG;
        LCA(int n, E[] g) {
            int x = n;
            this.n = n;
            LOG = 0;
            while (x > 0) {
                x /= 2;
                LOG++;
            }

            table = new int[LOG][n];
            dep = new int[n];
            this.g = g;
            glen = new int[n];
            for (int i = 0; i < n; i++) {
                glen[i] = g[i].size();
            }
        }

        void dfs(int idx, int par, int d) {
    //            debug(idx, par, d);
            table[0][idx] = par;
            dep[idx] = d;
            for (int next : g[idx]) {
                if (next != par) dfs(next, idx, d + 1);
            }
        }

        void build(int p) {
            dfs(p, -1, 0);
            for (int k = 0; k + 1 < LOG; k++) {
                for (int i = 0; i < n; i++) {
                    if (table[k][i] == -1) table[k + 1][i] = -1;
                    else table[k + 1][i] = table[k][table[k][i]];
                }
            }
        }

        int query(int u, int v) {
            if (dep[u] > dep[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            for (int i = LOG - 1; i >= 0; i--) {
                if ((((dep[v] - dep[u]) >> i) & 1) == 1) {
                    v = table[i][v];
                }
            }
            if (u == v) return u;
    //            debug("then", u, v);
            for (int i = LOG - 1; i >= 0; i--) {
                if (table[i][u] != table[i][v]) {
                    v = table[i][v];
                    u = table[i][u];
                }
            }
            return table[0][u];
        }
    }

    class E extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}