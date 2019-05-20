package abc126;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1, y = sc.nextInt() - 1, z = sc.nextInt();
            uf.union(x, y);
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(uf.find(i));
        }
        System.out.println(set.size());
    }

    class UnionFind {
        private int n, t;
        private int[] parent, rank;

        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public void union(int x, int y) {
            t++;
            int xr = find(x);
            int yr = find(y);

            if (xr > yr) {
                parent[yr] = xr;
            } else if (xr < yr) {
                parent[xr] = yr;
            } else {
                parent[yr] = xr;
                rank[yr]++;
            }

        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean same(int x, int y) {
            return find(x) == find(y);
        }

    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new abc126.E().run();
    }
}
