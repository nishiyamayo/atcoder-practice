package abc159;

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
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }

        long[] dp = new long[s + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = s - as[i]; j >= 0; j--) if (dp[j] >= 0) {
                if (dp[j + as[i]] < 0) dp[j + as[i]] = 0;
                if (j == 0) dp[j + as[i]] += i + 1;
                else {
                    dp[j + as[i]] = (dp[j + as[i]] + dp[j]) % MOD;
                }
            }
            if (dp[s] >= 0) {
                ans = (ans + (dp[s] * (n - i))) % MOD;
                dp[s] = 0;
            }
        }

        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}