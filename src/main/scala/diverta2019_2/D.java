package diverta2019_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D {

    int n;
    long ga, sa, ba;
    long gb, sb, bb;
    ArrayList<P> pab = new ArrayList<>();
    ArrayList<P> pba = new ArrayList<>();

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ga = sc.nextLong();
        sa = sc.nextLong();
        ba = sc.nextLong();
        gb = sc.nextLong();
        sb = sc.nextLong();
        bb = sc.nextLong();

        if (ga < gb) {
            pab.add(new P(ga, gb));
        } else {
            pba.add(new P(ga, gb));
        }

        if (sa < sb) {
            pab.add(new P(sa, sb));
        } else {
            pba.add(new P(sa, sb));
        }

        if (ba < bb) {
            pab.add(new P(ba, bb));
        } else {
            pba.add(new P(ba, bb));
        }

        if (pab.size() == 3) {
            long max = n;
            max = getMax(max, ga, gb, sa, sb, ba, bb);

            System.out.println(max);
        } else if (pab.size() == 2) {
            long max = getMax(n, pab.get(0).a, pab.get(0).b, pab.get(1).a, pab.get(1).b);

            System.out.println(max + (max / pba.get(0).b) * (pba.get(0).a - pba.get(0).b));
        } else if (pab.size() == 1) {
            long max = n + (n / pab.get(0).a) * (pab.get(0).b - pab.get(0).a);

            System.out.println(getMax(max, pba.get(0).b, pba.get(0).a, pba.get(1).b, pba.get(1).a));
        } else {
            long max = n;
            max = getMax(max, gb, ga, sb, sa, bb, ba);

            System.out.println(max);
        }
    }

    private long getMax(long max, long a1, long b1, long a2, long b2) {
        long ret = max;
        for (long c1 = 0; c1 <= max; c1++) {
            long c2 = max - c1;
            long d1 = c1 + (c1 / a1) * (b1 - a1);
            long d2 = c2 + (c2 / a2) * (b2 - a2);
            ret = Math.max(ret, d1 + d2);
        }
        return ret;
    }

    private long getMax(long max, long gb, long ga, long sb, long sa, long bb, long ba) {
        for (long gcnt = 0; gcnt <= n; gcnt++) for (long scnt = 0; scnt <= n - gcnt; scnt++) {
            long bcnt = n - gcnt - scnt;
            long gd = gcnt  + (gcnt / gb) * (ga - gb);
            long sd = scnt  + (scnt / sb) * (sa - sb);
            long bd = bcnt  + (bcnt / bb) * (ba - bb);
            max = Math.max(max, gd + sd + bd);
        }
        return max;
    }

    class P implements Comparable<P> {
        long a, b, d;
        P(long a, long b) {
            this.a = a;
            this.b = b;
            d = b - a;
        }

        @Override
        public int compareTo(P o) {
            return (o.d - d) > 0 ? 1 : -1;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
