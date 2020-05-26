package past002;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;
import java.util.function.BiFunction;

public class I {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public I() {
        this(System.in, System.out);
    }

    public I(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        int[] ps = new int[n + 1];
        ps[0] = 1;
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] * 2;
        }
        SegmentTree st = new SegmentTree(ps[n], Math::max, - (1 << 28));
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < ps[n]; i++) {
            int a = sc.nextInt();
            st.update(i, a);
            m.put(a, i);

        }

        int[] ans = new int[ps[n]];
        Arrays.fill(ans, 1);
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < ps[n] / ps[i]; j++) {
                int t = (int) st.query(j * ps[i], (j + 1) * ps[i]);
                int idx = m.get(t);
                if (ans[idx] == 1)
                    ans[idx] = i + 1;
            }
        }

        for (int i = 0; i < ps[n]; i++) {

            out.println(ans[i]);
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

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new I().run();
    }
}