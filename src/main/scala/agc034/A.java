package agc034;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt() - 1, d = sc.nextInt() - 1;
        String s = sc.next();

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n - 2; i++) if (s.charAt(i) != '#' && s.charAt(i + 2) != '#') {
            uf.union(i, i + 2);
        }
        for (int i = 0; i < n - 1; i++) if (s.charAt(i) != '#' && s.charAt(i + 1) != '#') {
            uf.union(i, i + 1);
        }

        boolean ok = false;
        if (uf.same(a, c) && uf.same(b, d)) {
            if (c > d) {
                for (int i = b - 1; i < Math.min(d, n - 2); i++) {
                    if (s.charAt(i) != '#' && s.charAt(i + 1) != '#' && s.charAt(i + 2) != '#') {
                        ok = true;
                    }
                }
            }
            else {
                ok = true;
            }
        }
        System.out.println(ok ? "Yes": "No");
    }

    class UnionFind {
        private int n;
        private int[] parent, rank;

        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n];
            this.rank = new int[n];
            Arrays.fill(rank, 1);
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public void union(int x, int y) {
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
        new A().run();
    }
}
