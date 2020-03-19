package arc097;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt() - 1, i);
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            uf.unite(x, y);
        }
        int cnt = 0;
        // write your code
        for (int i = 0; i < n; i++) {
            cnt += uf.same(i, map.get(i)) ? 1 : 0;
        }
        System.out.println(cnt);
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