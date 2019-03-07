package abc120;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    int n, m;
    int[][] es;

    void run() {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        es = new int[m][2];
        for (int i = 0; i < m; i++) {
            es[i][0] = sc.nextInt() - 1;
            es[i][1] = sc.nextInt() - 1;
        }

        long[] ans = new long[m];
        UnionFind uf = new UnionFind(n);
        ans[m - 1] = 1L * n * (n - 1) / 2;
        for (int i = m - 1; i >= 1; i--) {
            if (uf.same(es[i][0], es[i][1])) {
                ans[i - 1] = ans[i];
            } else {
                int sx = uf.size(es[i][0]);
                int sy = uf.size(es[i][1]);
                uf.union(es[i][0], es[i][1]);
                ans[i - 1] = ans[i] - sx * sy;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }

    }

    class UnionFind {
        private int n, t;
        private int[] parent, rank, size;

        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            this.size = new int[n];
            Arrays.fill(rank, 1);
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public void union(int x, int y) {
            t++;
            int xr = find(x);
            int yr = find(y);

            if (xr > yr) {
                parent[yr] = xr;
                size[yr] += size[xr];
                size[xr] = size[yr];
            } else if (xr < yr) {
                parent[xr] = yr;
                size[xr] += size[yr];
                size[yr] = size[xr];
            } else {
                parent[yr] = xr;
                rank[yr]++;
                size[xr] += size[yr];
                size[yr] = size[xr];
            }

        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int size(int x) {
            return size[find(x)];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }

    }



    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
