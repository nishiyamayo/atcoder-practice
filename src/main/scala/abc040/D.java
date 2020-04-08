package abc040;

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
        PriorityQueue<P> que = new PriorityQueue<>();
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), y = sc.nextInt();
            que.add(new P(i, a, b, y));
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int v = sc.nextInt(), w = sc.nextInt();
            que.add(new P(i, v, w));
        }

        int[] ans = new int[q];
        UnionFind uf = new UnionFind(n + 10);
        while (!que.isEmpty()) {
            P cur = que.remove();

            if (cur.s < 0) {
                ans[cur.idx] = uf.size(cur.f);
            } else {
                uf.unite(cur.f, cur.s);
            }
        }

        for (int a : ans) {
            out.println(a);
        }

        out.flush();
    }

    class P implements Comparable<P>{
        int idx;
        int f, s;
        int y;
        P(int idx, int f, int s, int y) {
            this.idx = idx;
            this.f = f;
            this.s = s;
            this.y = y;
        }

        P(int idx, int f, int y) {
            this.idx = idx;
            this.f = f;
            this.s = -1;
            this.y =  y;
        }


        @Override
        public int compareTo(P o) {
            if (y != o.y)
                return o.y - y;
            if (s > 0) {
                return 1;
            } else {
                return -1;
            }
        }
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

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}