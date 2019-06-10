package agc034;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    long x;
    int n;
    P[] ps;

    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextLong();
        ps = new P[n];

        long target = 0;

        for (int i = 0; i < n; i++) {
            ps[i] = new P(sc.nextInt(), sc.nextInt(), sc.nextInt());
            target += (long) ps[i].b * ps[i].l;
        }

        Arrays.sort(ps);
        debug(ps);
        System.out.println(binarySearch());
    }

    public long binarySearch() {
        long l = 0;
        long r = x * n;

        while (l < r) {
            long c = (l + r) / 2;
            if (win(c)) {
                r = c;
            } else {
                l = c + 1;
            }
        }
        return l;
    }

    public boolean win(long time) {
        long score = 0;
        long target = 0;

        int cnt = (int) (time / x);
        for (int i = 0; i < cnt; i++) {
            score += x * ps[i].u;
            target += (long) ps[i].b * ps[i].u;
        }

        long remind = time - cnt * x;
        int p = -1;
        long max = - (1L << 30);
        for (int i = cnt; i < n; i++) {
            target += (long) ps[i].b * ps[i].l;
            if (max < remind * ps[i].u - (long) ps[i].b * (ps[i].u - ps[i].l)) {
                p = i;
                max = remind * ps[i].u - (long) ps[i].b * (ps[i].u - ps[i].l);
            }
        }
        debug(time, cnt, target, score, max);
        return score + max >= target;
    }

    class P implements Comparable<P> {

        int b, l, u;
        long d;
        P(int b, int l, int u) {
            this.b = b;
            this.l = l;
            this.u = u;
            d = (x - b) * u - b * l;
        }

        @Override
        public int compareTo(P o) {

            if (d != o.d) {
                return o.d - d > 0 ? 1 : -1;
            }
            return (o.u - u);
        }

        @Override
        public String toString() {
            return String.format("{%d, %d, %d, %d}", b, l, u, d);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
