package past19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class K {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        E[] g = new E[n];
        for (int i = 0; i < n; i++) {
            g[i] = new E();
        }

        int parent = -1;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt() - 1;
            if (p < 0) {
                parent = i;
            } else {
                g[p].add(i);
            }
        }
        LCA lca = new LCA(n, g);
        lca.build(parent);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            int cmn = lca.query(a, b);
            if (cmn == b) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
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
        new K().run();
    }

}
