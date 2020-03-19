package abc038;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;
import java.util.function.BiFunction;

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
        int N = sc.nextInt();
        Node[] ns = new Node[N];

        for (int i = 0; i < N; i++) {
            ns[i] = new Node(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(ns);

        int[] dp = new int[N];
        SegmentTree st = new SegmentTree(100010, Math::max, 0);
        dp[0] = 1;
        st.update(ns[0].h, 1);

        int ans = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = (int) st.query(0, ns[i].h) + 1;
            st.update(ns[i].h, dp[i]);
            ans = Math.max(ans, dp[i]);
        }

        out.println(ans);

        out.flush();
    }

    public class SegmentTree {
        int n;
        long[] arr;
        BiFunction<Long, Long, Long> fn;
        long unity;

        SegmentTree(int n, BiFunction<Long, Long, Long> fn, long unity) {
            this.n = 1;
            while (this.n < n) {
                this.n *= 2;
            }
            arr = new long[2 * this.n - 1];
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
            } else if (l <= il && ir <= r) {
                return this.arr[k];
            }

            long vl = this.inneQuery(l, r, k * 2 + 1, il, (il + ir) / 2);
            long vr = this.inneQuery(l, r, k * 2 + 2, (il + ir) / 2, ir);
            return this.fn.apply(vl, vr);
        }
    }

    class Node implements Comparable<Node> {
        int w, h;

        Node(int w, int h) {
            this.w = w;
            this.h = h;
        }


        @Override
        public int compareTo(Node o) {
            if (w != o.w) {
                return w - o.w;
            }
            return o.h - h;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}