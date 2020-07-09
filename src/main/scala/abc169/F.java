package abc169;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = 998244353;

    InputStream in;
    OutputStream out;

    public F() {
        this(System.in, System.out);
    }

    public F(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), s = sc.nextInt();
        int[] as = new int[n];

        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }

        long[] dp = new long[s + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = s; j >= 0; j--) {
                if (j - as[i] >= 0) {
                    dp[j] = 2 * dp[j] + dp[j - as[i]];
                } else {
                    dp[j] = 2 * dp[j];
                }
                dp[j] %= MOD;
            }
        }

        out.println(dp[s]);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}