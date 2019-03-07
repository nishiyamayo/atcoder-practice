package arc002;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    int n, m, q;
    UnionFind uf;
    int[][] es;
    int[][] qs;
    int[] ans;

    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        uf = new UnionFind(n);
        es = new int[m][2];
        qs = new int[q][3];
        ans = new int[q];

        for (int i = 0; i < m; i++) {
            es[m][0] = sc.nextInt() - 1;
            es[m][1] = sc.nextInt() - 1;
        }
        for (int i = 0; i < q; i++) {

        }
    }

    class UnionFind {
        private int n, t;
        private int[] parent, rank, time;
        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            this.time = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public void union(int x, int y) {
            t++;
            int xr = find(x, t);
            int yr = find(y, t);

            if (xr > yr) {
                parent[yr] = xr;
            } else if (xr < yr) {
                parent[xr] = yr;
            } else {
                parent[yr] = xr;
                rank[yr]++;
            }

        }

        public int find(int x, int t) {
            if (x != parent[x]) {
//                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean same(int x, int y) {
  //          return find(x) == find(y);
            return true;
        }
    }

    public static void main(String[] args) {
        new D().run();
    }
}
