package abc119;

import java.util.*;

public class D {
    int a, b, q;
    long[] ss , ts;

    void run() {

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        q = sc.nextInt();

        ss = new long[a];
        ts = new long[b];

        for (int i = 0; i < a; i++) {
            ss[i] = (sc.nextLong());
        }

        for (int i = 0; i < b; i++) {
            ts[i] = (sc.nextLong());
        }

        Arrays.sort(ss);
        Arrays.sort(ts);
        debug(ss);
        debug(ts);

        for (int i = 0; i < q; i++) {
            long x = sc.nextLong();
            int sl = Math.max(0, lowerBound(ss, x));
            int tl = Math.max(0, lowerBound(ts, x));
            int su = Math.min(a - 1, upperBound(ss, x));
            int tu = Math.min(b - 1, upperBound(ts, x));
            long ans = 1L<<60;
            ans = Math.min(ans, dist(x, ss[sl], ts[tl]));
            ans = Math.min(ans, dist(x, ts[tl], ss[sl]));
            ans = Math.min(ans, dist(x, ss[su], ts[tl]));
            ans = Math.min(ans, dist(x, ts[tl], ss[su]));
            ans = Math.min(ans, dist(x, ss[sl], ts[tu]));
            ans = Math.min(ans, dist(x, ts[tu], ss[sl]));
            ans = Math.min(ans, dist(x, ss[su], ts[tu]));
            ans = Math.min(ans, dist(x, ts[tu], ss[su]));
            System.out.println(ans);
        }
    }

    long dist(long a, long b, long c) {
        return Math.abs(a - b) + Math.abs(b - c);
    }

    int lowerBound(long[] a, long x) {
        int lb = -1, ub = a.length;
        while (ub - lb > 1) {
            int mid = (ub + lb) / 2;
            if (a[mid] >= x) {
                ub = mid;
            } else {
                lb = mid;
            }
        }
        return lb;
    }

    int upperBound(long[] a, long x) {
        int lb = -1, ub = a.length;
        while (ub - lb > 1) {
            int mid = (ub + lb) / 2;
            if (a[mid] <= x) {
                lb = mid;
            } else {
                ub = mid;
            }
        }
        return ub;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
