package past003;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class H {
    long MOD = (long) 1e9 + 7;
    long INF = 1L << 60;

    InputStream in;
    OutputStream out;

    public H() {
        this(System.in, System.out);
    }

    public H(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), l = sc.nextInt();
        boolean[] xs = new boolean[l + 1];
        for (int i = 0; i < n; i++) {
            xs[sc.nextInt()] = true;
        }
        int t1 = sc.nextInt(), t2 = sc.nextInt(), t3 = sc.nextInt();

        long[] dp = new long[l + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < l; i++) {
            if (xs[i]) dp[i] += t3;
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + t1);
            if (i + 2 <= l) {
                dp[i + 2] = Math.min(dp[i + 2], dp[i] + t2 + t1);
            } else {
                dp[l] = Math.min(dp[l], dp[i] + t1 / 2 + t2 / 2);
            }
            if (i + 4 <= l) {
                dp[i + 4] = Math.min(dp[i + 4], dp[i] + t2 * 3 + t1);
            } else {
                int dx = l - i + 1;
                dp[l] = Math.min(dp[l], dp[i] + t1 / 2 + t2 * (dx / 2) + t2 / 2);
            }
        }
        out.println(dp[l]);


        out.flush();
    }

    class Point {
        int x;
        long t;

        Point(int x, long t) {

        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new H().run();
    }
}