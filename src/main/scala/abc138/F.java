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

    long count(long L, long R) {
        if (R == 0) return 0;

        String l = Long.toBinaryString(L);
        String r = Long.toBinaryString(R);
        int lenR = r.length(), lenL = l.length();
        long[][] dp = new long[lenR + 1][4];
        dp[0][0] = 1;
        dp[1][1] = 1;

        int offset = lenR - lenL;

        // 0: 0でギリ, 1: 1でギリ, 2: 0でギリじゃない, 3: 1でギリじゃない, 4: null
        for (int i = 2; i <= lenR; i++) {
            int dig = i - 1;
            if (r.charAt(dig) == '0') {
                dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
                dp[i][1] = 0;
                dp[i][2] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
                dp[i][3] = (2 * (dp[i - 1][2] + dp[i - 1][3])) % MOD;
            } else {
                dp[i][0] = 0;
                dp[i][1] = 2 * (dp[i - 1][0] + dp[i - 1][1]) % MOD;
                dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % MOD;
                dp[i][3] = (2 * (dp[i - 1][2] + dp[i - 1][3])) % MOD;
            }
            if (offset > i - 1) {
                dp[i][3] = (dp[i][3] + 1) % MOD;
            } else {
                debug(i, offset, i - 1 - offset);
                if (l.charAt(i - offset - 1) == '0')
                    dp[i][3] = (dp[i][3] + 1) % MOD;
            }
            debug(dp[i]);
        }
        return (dp[lenR][0] + dp[lenR][1] + dp[lenR][2] + dp[lenR][3]) % MOD;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }

}
