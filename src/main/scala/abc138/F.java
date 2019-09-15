package abc138;

import java.util.Arrays;
import java.util.Scanner;

public class F {
    long MOD = (long)1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);

        long L = sc.nextLong(), R = sc.nextLong();

        debug(dev(L, R));


        debug();
        debug(count(L, R));
    }

    long dev(long L, long R) {

        long cnt = 0;
        for (long x = L; x <= R; x++) for (long y = x; y <= R; y++) {
            if ((y % x) == (x ^ y)) cnt++;
        }
        return cnt;
    }

    int DIGIT = 5;
    long count(long L, long R) {
        String l = Long.toBinaryString(L);
        String r = Long.toBinaryString(R);

        for (int i = l.length(); i <= DIGIT; i++) l = "0" + l;
        for (int i = r.length(); i <= DIGIT; i++) r = "0" + r;
        long[][][][] dp = new long[DIGIT + 1][2][2][2]; // i番目まで見て、確実にL以上かどうか 、確実にR以下かどうか、ビットを立てているかどうか

        dp[0][0][0][0] = 1;
        for (int i = 1; i <= DIGIT; i++) {
            debug(l.charAt(i), r.charAt(i));
            dp[i][0][0][0] = (dp[i][0][0][0] + dp[i - 1][0][0][0]) % MOD;
            dp[i][0][0][1] = (dp[i][0][0][1] + dp[i - 1][0][0][1]) % MOD;
            dp[i][0][1][1] = (dp[i][0][1][1] + dp[i - 1][0][1][1]) % MOD;
            dp[i][1][0][1] = (dp[i][1][0][1] + dp[i - 1][1][0][1]) % MOD;
            dp[i][1][1][1] = 3 * dp[i - 1][1][1][1] % MOD;
            if (l.charAt(i) == '0' && r.charAt(i) == '1') {
                // x: 1, y: 1
                dp[i][1][0][1] = (dp[i][1][0][1] + dp[i - 1][0][0][0] + dp[i - 1][0][0][1] + dp[i - 1][1][0][1]) % MOD;
                dp[i][1][1][1] = (dp[i][1][1][1] + dp[i - 1][0][1][1]) % MOD;
                // x: 0, y: 1
                dp[i][0][0][1] = (dp[i][0][0][1] + dp[i - 1][0][0][1]) % MOD;
                // x: 0, y: 0
                dp[i][0][1][1] = (dp[i][0][1][1] + dp[i - 1][0][1][1]) % MOD;
                dp[i][1][1][1] = (dp[i][1][1][1] + dp[i - 1][1][0][1]) % MOD;
            }
            if (l.charAt(i) == '1' && r.charAt(i) == '1') {
                // x: 1, y: 1
                dp[i][0][0][1] = (dp[i][0][0][1] + dp[i - 1][0][0][0] + dp[i - 1][0][0][1]) % MOD;
                // x: 0, y: 1
                dp[i][1][0][1] = (dp[i][1][0][1] + dp[i - 1][1][0][1]) % MOD;
                // x: 0, y: 0
            }
            if (l.charAt(i) == '0' && r.charAt(i) == '0') {
                // x: 1, y: 1
                dp[i][1][1][1] = (dp[i][1][1][1] + dp[i - 1][0][1][1]) % MOD;
                // x: 0, y: 1
                // x: 0, y: 0
                dp[i][0][0][1] = (dp[i][0][0][1] + dp[i - 1][0][0][1]) % MOD;
                dp[i][0][1][1] = (dp[i][0][1][1] + dp[i - 1][0][1][1]) % MOD;
            }
            if (l.charAt(i) == '1' && r.charAt(i) == '0') {
                // x: 1, y: 1
                // x: 0, y: 1
                // x: 0, y: 0
            }
            debug(dp[i]);
        }
        long ans = 0;
        for (int i = 0; i < 2; i++) for (int j = 0; j < 2; j++) {
            ans += dp[DIGIT][i][j][1];
        }
        return ans % MOD;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }

}
