package abc153;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class F {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt(), a = sc.nextInt();
        PriorityQueue<P> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.add(new P(sc.nextInt(), sc.nextInt(), 0));
        }

        long dm = 0;
        long ans = 0;
        while (!q.isEmpty()) {
            P cur = q.remove();
//            debug(dm, ans, cur.x, cur.h, cur.t);
            switch (cur.t) {
                case 0:
                    cur.h -= dm;
                    if (cur.h < 0) break;
                    long k = (cur.h + a - 1) / a;
                    ans += k;
                    dm += k * a;
                    q.add(new P(cur.x + 2 * d, -k * a,1));
                    break;
                case 1:
                    dm += cur.h;
            }
        }

        System.out.println(ans);
    }

    class P implements Comparable<P> {
        long x, h;
        int t;
        P(long x, long h, int t) {
            this.x = x;
            this.h = h;
            this.t = t;
        }

        @Override
        public int compareTo(P o) {
            if (x != o.x) {
                return Long.compare(x, o.x);
            }
            return t - o.t;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }

}
