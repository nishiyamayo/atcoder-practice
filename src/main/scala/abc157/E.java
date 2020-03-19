package abc157;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
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
        int n = sc.nextInt();
        String s = sc.next();
        int q = sc.nextInt();

        SegmentTree[] sg = new SegmentTree[26];
        for (int i = 0; i < 26; i++) {
            sg[i] = new SegmentTree(n, Long::sum, 0);
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            a[i] = c;
            sg[c].update(i, 1);
        }

        PrintWriter out = new PrintWriter(this.out);

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();

            if (t == 1) {
                int iq = sc.nextInt() - 1;
                int c = sc.next().charAt(0) - 'a';
                if (a[iq] == c) continue;
                sg[c].update(iq, 1);
                sg[a[iq]].update(iq, 0);
                a[iq] = c;
            } else {
                int lq = sc.nextInt() - 1, rq = sc.nextInt();
                int cnt = 0;
                for (int j = 0; j < 26; j++) {
                    cnt += sg[j].query(lq, rq) > 0 ? 1 : 0;
                }
                out.println(cnt);
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
        new E().run();
    }
}