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

        long score = 0;
        long time = 0;
        int i = 0;
        while (score <= target) {
            debug(score, target, time, ps[i].b, ps[i].l, ps[i].u);
            if (score + (long) ps[i].u * x > target + (long) (ps[i].u - ps[i].l) * ps[i].b) {
                long t;
                for (t = 0; score + (long) ps[i].u * t < target + (long) (ps[i].u - ps[i].l) * ps[i].b; t++) {}
                score += (long) ps[i].u * t;
                target += (long) (ps[i].u - ps[i].l) * ps[i].b;
                time += t;
                break;
            } else {
                score += (long) ps[i].u * x;
                time += x;
                target += (long) (ps[i].u - ps[i].l) * ps[i].b;
            }
            i++;
        }

        debug(score, target);

        System.out.println(time);
    }

    public static int lowerBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    class P implements Comparable<P> {

        int b, l, u;
        long d;
        P(int b, int l, int u) {
            this.b = b;
            this.l = l;
            this.u = u;
            d = (x - b) * u;
        }

        @Override
        public int compareTo(P o) {

            if (d != o.d) {
                return o.d - d > 0 ? 1 : -1;
            }
            return (o.u - o.l) - (u - l);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
