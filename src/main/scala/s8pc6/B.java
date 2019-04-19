package s8pc6;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class B {
    int n;
    long[] a, b;
    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new long[n];
        b = new long[n];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            ans += b[i] - a[i];
        }

        long st = triSearch(x -> {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.abs(x - a[i]);
            }
            return sum;
        });

        long ed = triSearch(x -> {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.abs(x - b[i]);
            }
            return sum;
        });

        debug(st, ed);

        for (int i = 0; i < n; i++) {
            ans += Math.abs(st - a[i]);
            ans += Math.abs(ed - b[i]);
        }
        System.out.println(ans);
    }

    long triSearch(Function<Long, Long> f) {
        long l = 0, r = (long)1e9;

        while (r - l > 2) {
            long d = (r - l) / 3;
            long lm = l + d;
            long rm = l + d * 2;

            long ls = f.apply(lm);
            long rs = f.apply(rm);
            if (ls > rs) {
                l = lm;
            } else {
                r = rm;
            }
            debug(l, r, lm, rm, ls, rs, f.toString());
        }
        long r1 = f.apply(l);
        long r2 = f.apply(l + 1);
        long r3 = f.apply(r);
        if (r1 < r2 && r1 < r3) {
            return l;
        } else if (r2 < r3) {
            return l + 1;
        } else {
            return r;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[]  args) {
        new B().run();
    }
}
