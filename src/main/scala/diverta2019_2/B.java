package diverta2019_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        P[] ps = new P[n];
        HashSet<Long> hash = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ps[i] = new P(sc.nextLong(), sc.nextLong());
            hash.add(ps[i].toLong());
        }

        Arrays.sort(ps);

        int ans = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long p = ps[j].x - ps[i].x;
                long q = ps[j].y - ps[i].y;
                int cnt = n;
                for (int k = j; k < n; k++) {
                    long dp = ps[k].x - p;
                    long dq = ps[k].y - q;
                    if (hash.contains(new P(dp, dq).toLong())) {
                        cnt -= 1;
                    }
                }
                ans = Math.min(ans, cnt);
            }
        }
        System.out.println(ans);
    }

    class P implements Comparable<P> {

        long x, y;
        P(long x, long y) {
            this.x = x;
            this.y = y;
        }

        long toLong() {
            return x * (long) (1e9 + 1) + y;
        }

        @Override
        public int compareTo(P o) {
            if (x != o.x) {
                return (x - o.x) > 0 ? 1 : -1;
            }
            return (y - o.y) > 0 ? 1 : -1;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
