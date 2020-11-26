package abc183;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);
        int n = sc.nextInt(), q = sc.nextInt();
        UnionFind uf = new UnionFind(n + 1);

        int[] c = new int[n];
        ClassMap[] maps = new ClassMap[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt() - 1;
            maps[i] = new ClassMap();
            maps[i].put(c[i], 1);
        }

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt(), f = sc.nextInt() - 1, s = sc.nextInt() - 1;
            if (t == 1) {
                f = uf.find(f);
                s = uf.find(s);
                if (uf.same(f, s)) continue;
                uf.unite(f, s);
                int idx = uf.find(f);
                if (idx != f) {
                    for (Map.Entry<Integer, Integer> entry: maps[f].entrySet()) {
                        maps[idx].put(entry.getKey(), maps[idx].getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                    maps[f].clear();
                }
                if (idx != s) {
                    for (Map.Entry<Integer, Integer> entry: maps[s].entrySet()) {
                        maps[idx].put(entry.getKey(), maps[idx].getOrDefault(entry.getKey(), 0) + entry.getValue());
                    }
                    maps[s].clear();
                }
            } else {
//                debug(maps);
                int idx = uf.find(f);
                out.println(maps[idx].getOrDefault(s, 0));
            }
        }

        out.flush();
    }

    public class ClassMap extends HashMap<Integer, Integer> {}

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
        new F().run();
    }
}
