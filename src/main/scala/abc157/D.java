package abc157;

import abc156.E;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        S[] s = new S[n];
        int[] sub = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = new S();
        }
        UnionFind fr = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            fr.unite(a, b);
            s[a].add(b);
            s[b].add(a);
            sub[a]++;
            sub[b]++;
        }
        for (int i = 0; i < k; i++) {
            int c = sc.nextInt() - 1, d = sc.nextInt() - 1;
            if (fr.same(c, d)) {
                sub[c]++;
                sub[d]++;
            }
        }

        PrintWriter out = new PrintWriter(System.out);

        out.print(fr.size(0) - sub[0] - 1);
        for (int i = 1; i < n; i++) {
            out.print(" " + (fr.size(i) - sub[i] - 1));
        }
        out.println();
        out.flush();


    }

    class S extends HashSet<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
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

    public static void main(String[] args) {
        new D().run();
    }

}
