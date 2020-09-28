package abc177;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt();
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < m; i++) {
            uf.unite(sc.nextInt(), sc.nextInt());
        }

        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, uf.size(i));
        }

        out.println(ans);

        out.flush();
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