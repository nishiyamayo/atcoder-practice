package abc170;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;
import java.util.function.BiFunction;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public E() {
        this(System.in, System.out);
    }

    public E(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), q = sc.nextInt();
        int m = 2 * 100000;
//        int m = 10;
        Edge[] g = new Edge[m];
        for (int i = 0; i < m; i++) {
            g[i] = new Edge();
        }

        SegmentTree st = new SegmentTree(m);

        Pair[] childlen = new Pair[n];
        for (int i = 0; i < n; i++) {
            childlen[i] = new Pair(sc.nextInt(), sc.nextInt() - 1);
            int cnt = g[childlen[i].belong].getOrDefault(childlen[i].rate, 0);
            g[childlen[i].belong].put(childlen[i].rate, cnt + 1);
            st.update(childlen[i].belong, g[childlen[i].belong].lastKey());
        }

//        debug(g);
//        debug(st.arr);

        for (int i = 0; i < q; i++) {
            int c = sc.nextInt() - 1, d = sc.nextInt() - 1;
            int cnt = g[childlen[c].belong].get(childlen[c].rate);
            if (cnt == 1) {
                g[childlen[c].belong].remove(childlen[c].rate);
            } else {
                g[childlen[c].belong].put(childlen[c].rate, cnt - 1);
            }
            if (!g[childlen[c].belong].isEmpty()) {
                st.update(childlen[c].belong, g[childlen[c].belong].lastKey());
            } else {
                st.update(childlen[c].belong, st.unity);
            }

            childlen[c].belong = d;
            cnt = g[childlen[c].belong].getOrDefault(childlen[c].rate, 0);
            g[childlen[c].belong].put(childlen[c].rate, cnt + 1);
            st.update(childlen[c].belong, g[childlen[c].belong].lastKey());
            out.println(st.query(0, m));
        }



        out.flush();
    }

    public class SegmentTree {
        int n;
        long[] arr;
        BiFunction<Long, Long, Long> fn;
        long unity;

        SegmentTree(int n, BiFunction<Long, Long, Long> fn, long unity) {
            this.n = 1;
            while(this.n < n) {
                this.n *= 2;
            }
            arr = new long[2 * this.n - 1];
            Arrays.fill(arr, unity);
            this.fn = fn;
            this.unity = unity;
        }

        SegmentTree(int n) {
            this(n, Math::min, 1L << 60);
        }

        void update(int i, long x) {
            int k = this.n + i - 1;
            this.arr[k] = x;

            while (k > 0) {
                k = (k - 1) / 2;
                this.arr[k] = this.fn.apply(this.arr[2 * k + 1], this.arr[2 * k + 2]);
            }
        }

        long query(int l, int r) {
            return this.inneQuery(l, r, 0, 0, this.n);
        }

        private long inneQuery(int l, int r, int k, int il, int ir) {
            if (ir <= l || r <= il) {
                return this.unity;
            } else if(l <= il && ir <= r) {
                return this.arr[k];
            }

            long vl = this.inneQuery(l, r, k * 2 + 1, il, (il + ir) / 2);
            long vr = this.inneQuery(l, r, k * 2 + 2, (il + ir) / 2, ir);
            return this.fn.apply(vl, vr);
        }
    }

    class Pair {
        int rate, belong;
        Pair(int rate, int belong) {
            this.rate = rate;
            this.belong = belong;
        }
    }

    class Edge extends TreeMap<Integer, Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}