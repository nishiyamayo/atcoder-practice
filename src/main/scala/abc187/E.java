package abc187;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(this.in));
        PrintWriter out = new PrintWriter(this.out);

        int n = Integer.parseInt(br.readLine());
        Edge[] g = new Edge[n];
        int[] A = new int[n], B = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] sp = br.readLine().split(" ");
            int a = Integer.parseInt(sp[0]) - 1, b = Integer.parseInt(sp[1]) - 1;
            g[a].add(b);
            g[b].add(a);
            A[i] = a;
            B[i] = b;
        }

        LCA lca = new LCA(n, g);
        lca.build(0);

        int q = Integer.parseInt(br.readLine());
        long[] memo = new long[n];

        for (int i = 0; i < q; i++) {
            String[] sp = br.readLine().split(" ");
            int t = Integer.parseInt(sp[0]), e = Integer.parseInt(sp[1]) - 1, x = Integer.parseInt(sp[2]);
            int c = lca.query(A[e], B[e]);
//            debug(t, e, A[e], B[e], c, x);
            if (t == 1) {
                if (A[e] == 0 && c == 0) {
                    memo[0] += x;
                    memo[B[e]] -= x;
                } else if (B[e] == 0 && c == 0) {
                    memo[A[e]] += x;
                } else if (c == 0) {
                    memo[0] += x;
                    memo[B[e]] -= x;
                } else if (B[e] == c) {
                    memo[A[e]] += x;
                } else {
                    memo[0] += x;
                    memo[B[e]] -= x;
                }
            } else {

                if (B[e] == 0 && c == 0) {
                    memo[0] += x;
                    memo[A[e]] -= x;
                } else if (A[e] == 0 && c == 0) {
                    memo[B[e]] += x;
                } else if (c == 0) {
                    memo[0] += x;
                    memo[A[e]] -= x;
                } else if (A[e] == c) {
                    memo[B[e]] += x;
                } else {
                    memo[0] += x;
                    memo[A[e]] -= x;
                }
            }
//            debug(memo);
        }

        lca.solve(0, -1, 0, memo);
        for (long v : memo) {
            out.println(v);
        }

        out.flush();
    }

    class LCA {
        int n;
        int[][] table;
        int[] dep;
        Edge[] g;
        int[] glen;
        int LOG;
        LCA(int n, Edge[] g) {
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

        void solve(int idx, int par, long sum, long[] memo) {
            memo[idx] += sum;
            for (int next : g[idx]) {
                if (next != par) solve(next, idx, memo[idx], memo);
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

    class Edge extends ArrayList<Integer> {}


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        try {
            new E().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
