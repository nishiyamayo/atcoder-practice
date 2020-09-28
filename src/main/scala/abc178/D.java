package abc178;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int s = sc.nextInt();
        int l = (s + 2) / 3;
        long[][] dp = new long[l + 1][s + 1];
        long[][] sum = new long[l + 1][s + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= s; i++) {
            sum[0][i] = 1;
        }

//        debug(dp[0]);
//        debug(sum[0]);

        long ans = 0;
        for (int i = 1; i <= l; i++) {
            for (int j = 3 * i; j <= s; j++) {
                dp[i][j] = (sum[i - 1][j - 3]) % MOD;
                sum[i][j] = (sum[i][j - 1] + dp[i][j]) % MOD;
            }
//            debug(i, dp[i]);
//            debug(i, sum[i]);
            ans = (ans + dp[i][s]) % MOD;
        }

        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}