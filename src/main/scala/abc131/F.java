package abc131;

import java.util.*;

public class F {

    int N = 2 * 100000;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];

        UnionFind uf = new UnionFind(N);

        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt() - 1;
            ys[i] = sc.nextInt() - 1 + N / 2;
            uf.union(xs[i], ys[i]);
        }

        HashMap<Integer, Integer> xc = new HashMap<>();
        HashMap<Integer, Integer> yc = new HashMap<>();

        for (int i = 0; i < N / 2; i++) {
            xc.put(uf.find(i), xc.getOrDefault(uf.find(i), 0) + 1);
            yc.put(uf.find(i + N / 2), yc.getOrDefault(uf.find(i + N / 2), 0) + 1);
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += 1L * xc.getOrDefault(i, 0) * yc.getOrDefault(i, 0);
        }
        System.out.println(ans - n);
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
        new F().run();
    }
}
