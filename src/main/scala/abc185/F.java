package abc185;

import java.io.*;

import java.util.*;
import java.util.function.BiFunction;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(this.in));

        PrintWriter out = new PrintWriter(this.out);

        String[] sp = br.readLine().split(" ");
        int n = Integer.parseInt(sp[0]), q = Integer.parseInt(sp[1]);
        SegmentTree st = new SegmentTree(n, (x, y) -> x ^ y, 0);
        sp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(sp[i]);
            st.update(i, a);
        }

        for (int i = 0; i < q; i++) {
            sp = br.readLine().split(" ");
            int t = Integer.parseInt(sp[0]), x = Integer.parseInt(sp[1]), y = Integer.parseInt(sp[2]);
            if (t == 1) {
                x--;
                long v = st.query(x, x + 1);
                st.update(x, v ^ y);
            } else {
                x--;
                y--;
                out.println(st.query(x, y + 1));
            }
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

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        try {
            new F().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
