package abc074;

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
        PriorityQueue<Node> q = new PriorityQueue<>();
        int n = sc.nextInt();
        long[][] A = new long[n][n], B = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = B[i][j] = sc.nextInt();
                q.add(new Node(i, j, A[i][j]));
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    B[i][j] = Math.min(B[i][j], B[i][k] + B[k][j]);
                }
            }
        }

        boolean f = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] > B[i][j]) {
                    f = false;
                }  else {
                    boolean ok = true;
                    for (int k = 0; k < n; k++) {
                        if (i == k || j == k) continue;
                        if (B[i][k] + B[k][j] == B[i][j]) ok = false;
                    }
                    if (ok) ans += A[i][j];
                }
            }
        }

        if (!f) {
            out.println(-1);
        } else {
            out.println(ans / 2);
        }

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


    class Node implements Comparable<Node> {
        int x, y;
        long weight;
        Node(int x, int y, long weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(weight, o.weight);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}