package past19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class L {
    int n, m;
    int[] x, y, c;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        x = new int[n + m];
        y = new int[n + m];
        c = new int[n + m];
        for (int i = 0; i < n + m; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        ArrayList<V> vs = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) for (int j = i + 1; j < n; j++){
            vs.add(new V(i, j, cost(i, j)));
        }

        double ans = 1e15;

        for (int i = 0; i < (1 << m); i++) {
            ArrayList<V> target = new ArrayList<>(vs);
//            debug(Integer.toBinaryString(i), target);
            for (int j = 0; j < m; j++) if (((i >> j) & 1) == 1) {
                for (int k = 0; k < n; k++)
                target.add(new V(k, n + j, cost(k, n + j)));
            }
            for (int j = 0; j < m; j++) if (((i >> j) & 1) == 1) {
                for (int k = 0; k < m; k++) if (((i >> k) & 1) == 1) {
                    target.add(new V(n + j, n + k, cost(n + j, n + k)));
                }
            }
            ans = Math.min(ans, solve(target));
        }
        System.out.println(ans);
    }

    double cost(int i, int j) {
        double d = Math.sqrt(1.0 * (x[i] - x[j]) * (x[i] - x[j]) + 1.0 * (y[i] - y[j]) * (y[i] - y[j]));
        d *= c[i] == c[j] ? 1 : 10;
        return d;
    }

    double solve(ArrayList<V> vs) {
        double ret = 0;
        UnionFind uf = new UnionFind(n + m);
//        debug(vs);

        Collections.sort(vs);
        for (V v : vs) {
//            debug(v, uf.same(v.i1, v.i2));
            if (uf.same(v.i1, v.i2)) continue;
            uf.unite(v.i1, v.i2);
            ret += v.cost;
        }
        return ret;
    }

    class V implements Comparable<V> {
        int i1, i2;
        double cost;
        V (int i1, int i2, double cost) {
            this.i1 = i1;
            this.i2 = i2;
            this.cost = cost;
        }


        @Override
        public int compareTo(V o) {
            return Double.compare(cost, o.cost);
        }

        @Override
        public String toString() {
            return "(" + i1 + ", " + i2 + ", " + cost + ")";
        }
    }

    class UnionFind {
        int[] parents, sizes;

        UnionFind(int n) {
            parents = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
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
        new L().run();
    }

}
