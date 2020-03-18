package abc152;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class F {
    int n, m;
    E[] g;
    int[][] uv;

    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        g = new E[n];
        for (int i = 0; i < n; i++) g[i] = new E();
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(new P(b, i));
            g[b].add(new P(a, i));
        }
        m = sc.nextInt();
        uv = new int[m][2];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            uv[i][0] = u;
            uv[i][1] = v;
        }

        long[] pows = new long[n + 1];
        pows[0] = 1;
        for (int i = 1; i <= n; i++) {
            pows[i] = pows[i - 1] * 2;
        }


        LCA lca = new LCA(n, g);
        lca.build(0);
        debug(lca.ar);
        long ans = 0;
        for (int i = 0; i < (1 << m); i++) {
            long cov = 0;
            long code = (Integer.bitCount(i) & 1) == 1 ? -1 : 1;
            for (int j = 0; j < m; j++) if (((i >> j) & 1) == 1) {
//                debug(uv[j][0], uv[j][1], Long.toBinaryString(extract(lca, uv[j][0], uv[j][1])));
                cov |= extract(lca, uv[j][0], uv[j][1]);
            }
            ans += code * pows[n - 1 - Long.bitCount(cov)];
        }
        System.out.println(ans);
    }

    long extract(LCA lca, int u, int v) {
        int t = lca.query(u, v);
        long cov = lca.ar[u] ^ lca.ar[t];
        cov ^= lca.ar[v] ^ lca.ar[t];
//        debug(Long.toBinaryString(Math.max(lca.ar[u], lca.ar[t]) - Math.min(lca.ar[u], lca.ar[t])), Long.toBinaryString(Math.max(lca.ar[v], lca.ar[t]) - Math.min(lca.ar[v], lca.ar[t])));
        return cov;
    }

    class LCA {
        int n;
        int[][] table;
        int[] dep;
        E[] g;
        int[] glen;
        int LOG;
        long[] ar;
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
            ar = new long[n];
        }

        void dfs(int idx, int par, int d) {
//            debug(idx, par, d);
            table[0][idx] = par;
            dep[idx] = d;
            for (P next : g[idx]) {
                if (next.to != par) dfs(next.to, idx, d + 1);
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
            dfsEdge(p, -1, 0);
        }

        void dfsEdge(int idx, int par, long ce) {
            debug("", idx);
            ar[idx] = ce;
            for (P next : g[idx]) {
                if (next.to != par) {
                    dfsEdge(next.to, idx, ce  | (1L << (next.idx - 1)));
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

    class E extends ArrayList<P> {}

    class P {
        int to, idx;
        P(int to, int idx) {
            this.to = to;
            this.idx = idx;
        }
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }

}
