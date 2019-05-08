package iroha2019day2;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        UnionFind uf = new UnionFind(n);
        PriorityQueue<E> q = new PriorityQueue<>();
        TreeSet<Integer> ans = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            q.add(new E(a - 1, b - 1, c, i + 1));
        }

        while (!q.isEmpty()) {
            E cur = q.remove();
            if (!uf.same(cur.a, cur.b)) {
                uf.union(cur.a, cur.b);
                ans.add(cur.d);
            }
        }

        PrintWriter out = new PrintWriter(System.out);

        for (int x: ans) {
            out.println(x);
        }
        out.flush();
    }

    class E implements Comparable<E> {
        int a, b, c, d;
        E(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(E o) {
            return o.c - c;
        }
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

    public static void main(String[] args) {
        new D().run();
    }
}
