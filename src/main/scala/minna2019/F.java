package minna2019;

import java.util.Arrays;
import java.util.Scanner;

public class F {

    long MOD = 998244353;

    void run() {
        Scanner sc = new Scanner(System.in);
        String l = sc.next();
        int n = l.length();
        int[] rs = new int[n];
        int[] bs = new int[n];
        for (int i = 0; i < n; i++) {
            switch (l.charAt(i)) {
                case '0':
                    rs[i] = 2;
                    bs[i] = 0;
                    break;
                case '1':
                    rs[i] = 1;
                    bs[i] = 1;
                    break;
                case '2':
                    rs[i] = 0;
                    bs[i] = 2;
                    break;
            }
        }
        for (int i = 1; i < n; i++) {
            rs[i] += rs[i - 1];
            bs[i] += bs[i - 1];
        }

//        debug("rbs", rs, bs);


        long[][] dp = new long[2 * n + 1][rs[n - 1] + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= 2 * n; i++) {
            int reach = Math.min(i - 1, n - 1);
            if (bs[reach] >= i) {
                dp[i][0] = dp[i - 1][0];
            }
            for (int j = 1;j <= Math.min(i, rs[reach]); j++) if (i - j <= bs[reach]) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
            }
            for (int j = 1;j <= Math.min(i, rs[reach]); j++) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
            }
//            debug(dp[i]);
        }
        System.out.println(dp[2 * n][rs[n - 1]]);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
