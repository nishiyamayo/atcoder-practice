package past002;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class O {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public O() {
        this(System.in, System.out);
    }

    public O(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int n, m;
    Edge[] es;


    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        m = sc.nextInt();
        es = new Edge[m];
        PriorityQueue<Edge> q = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            es[i] = new Edge(i, sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
            q.add(es[i]);
        }

        UnionFind uf = new UnionFind(n);
        E[] tree = new E[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new E();
        }

        long cost = 0;
        HashSet<Integer> use = new HashSet<>();

        while (!q.isEmpty()) {
            Edge e = q.remove();
            if (!uf.same(e.a, e.b)) {
                uf.unite(e.a, e.b);
                tree[e.a].add(new P(e.b, e.c));
                tree[e.b].add(new P(e.a, e.c));
                cost += e.c;
                use.add(e.idx);
            }
        }

        LCA lca = new LCA(n, tree);
        lca.build(0);
        for (int i = 0; i < m; i++) {
            if (use.contains(i)) {
                out.println(cost);
            } else {
//                debug(lca.queryC(es[i].a, es[i].b));
                out.println(cost + es[i].c - lca.queryC(es[i].a, es[i].b));
            }
        }

        out.flush();
    }

    public class UnionFind {
        int[] parents, sizes;

        UnionFind(int n) {
            parents = new int[n];
            sizes = new int[n];
            for(int i = 0; i < n; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parents[x]) return x;
            return parents[x] = find(parents[x]);
        }

        public void unite(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            if (sizes[x] < sizes[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parents[y] = x;
            sizes[x] += sizes[y];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }

        public int size(int x) {
            return sizes[find(x)];
        }
    }


    class Edge implements Comparable<Edge> {
        int idx;
        int a, b;
        long c;
        Edge(int idx, int a, int b, long c) {
            this.idx = idx;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(c, o.c);
        }
    }

    class LCA {
        int n;
        int[][] table;
        long[][] maxC;
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
            maxC = new long[LOG][n];
            dep = new int[n];
            this.g = g;
            glen = new int[n];
            for (int i = 0; i < n; i++) {
                glen[i] = g[i].size();
            }
        }

        void dfs(int idx, int par, int d, long c) {
//            debug(idx, par, d);
            table[0][idx] = par;
            maxC[0][idx] = c;
            dep[idx] = d;
            for (P next : g[idx]) {
                if (next.t != par) {
                    dfs(next.t, idx, d + 1, next.c);
                }
            }
        }

        void build(int p) {
            dfs(p, -1, 0, 0);

            for (int k = 0; k + 1 < LOG; k++) {
                for (int i = 0; i < n; i++) {
                    if (table[k][i] == -1) {
                        table[k + 1][i] = -1;
                        maxC[k + 1][i] = -1;
                    }
                    else {
                        table[k + 1][i] = table[k][table[k][i]];
//                        debug(k + 1, i, maxC[k + 1][i], maxC[k][i], maxC[k][table[k][i]], table[k][i]);
                        maxC[k + 1][i] = Math.max(maxC[k + 1][i], Math.max(maxC[k][i], maxC[k][table[k][i]]));
                        if (table[k + 1][i] < 0) maxC[k + 1][i] = -1;
                    }
                }
            }
            for(int[] a: table) debug(a);
            for(long[] a: maxC) debug(a);
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

        long queryC(int u, int v) {
//            for(long[] a : maxC) debug(a);
            if (dep[u] > dep[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            long ret = 0;
            for (int i = LOG - 1; i >= 0; i--) {
                if ((((dep[v] - dep[u]) >> i) & 1) == 1) {
                    ret = Math.max(ret, maxC[i][v]);
                    v = table[i][v];
                }
            }
//            debug("then", u, v, ret);
            if (u == v) return ret;
            for (int i = LOG - 1; i >= 0; i--) {
                if (table[i][u] != table[i][v]) {
                    ret = Math.max(ret, Math.max(maxC[i][v], maxC[i][u]));
                    v = table[i][v];
                    u = table[i][u];
//                    debug(i, v, u);
                }
            }
//            debug(u, v);
//            if (u != v)
            return Math.max(ret, Math.max(maxC[0][v], maxC[0][u]));
        }

    }

    class P {
        int t;
        long c;
        P(int t, long c) {
            this.t = t;
            this.c = c;
        }
    }

    class E extends ArrayList<P> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new O().run();
    }
}