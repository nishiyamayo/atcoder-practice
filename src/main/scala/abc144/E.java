package abc144;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] a = new long[n], f = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            f[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(f);

        PriorityQueue<P> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(new P(a[i], f[n - i - 1]));
        }
        q.add(new P(0, 0));

        debug(q);

        P cur = q.remove();
        long ans = 0;

        while (!q.isEmpty() && k > 0) {
            P next = q.remove();

            long d = cur.value() - next.value();
            long mult = Math.min(k, d / cur.f + 1);

            debug(cur, next, d, mult, k);

            cur.a -= mult;
            k -= mult;

            if (cur.a > 0) {
                q.add(cur);
            }
            debug(q, next);
            cur = next;
        }
        q.add(cur);

        debug(q);

        for (P p : q) {
            ans += p.value();
        }

        System.out.println(ans);
    }

    class P implements Comparable<P> {
        long a, f;
        P(long a, long f) {
            this.a = a;
            this.f = f;
        }

        long value() {
            return a * f;
        }

        @Override
        public int compareTo(P o) {
            return Long.compare(o.a * o.f, a * f);
        }

        @Override
        public String toString() {
            return "(" + a + ", " + f + ")";
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
