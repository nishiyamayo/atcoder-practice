package abc138;

import java.util.Arrays;
import java.util.Scanner;

public class FF {
    long MOD = (long)1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);

        long L = sc.nextLong(), R = sc.nextLong();
        System.out.println(count(L, R));
    }

    long dev(long L, long R) {

        long cnt = 0;
        for (long x = L; x <= R; x++) for (long y = x; y <= R; y++) {
            if ((y % x) == (x ^ y)) cnt++;
        }
        return cnt;
    }

    int DIGIT = 60;
    long count(long L, long R) {
        String l = Long.toBinaryString(L);
        String r = Long.toBinaryString(R);

        for (int i = l.length(); i <= DIGIT; i++) l = "0" + l;
        for (int i = r.length(); i <= DIGIT; i++) r = "0" + r;
        long[][][][] dp = new long[DIGIT + 1][2][2][2]; // i番目まで見て、確実にL以上かどうか 、確実にR以下かどうか、ビットを立てているかどうか

        dp[0][0][0][0] = 1;
        for (int i = 1; i <= DIGIT; i++) {
            int ln = 1 - l.charAt(i) + '0', rn = r.charAt(i) - '0';

            for (int X = 0; X < 2; X++) for (int Y = 0; Y < 2; Y++) for (int Z = 0; Z < 2; Z++) {
                // x: 1, y: 1
                if ((Y | rn) == 1)
                    dp[i][X | ln][Y][1] += dp[i - 1][X][Y][Z];
                // x: 0, y: 0
                if ((X | ln) == 1)
                    dp[i][X][Y | rn][Z] += dp[i - 1][X][Y][Z];
                // x: 0, y: 1
                if (((Y | rn) == 1) && ((X | ln) == 1) && Z == 1)
                    dp[i][X][Y][Z] += dp[i - 1][X][Y][Z];
                dp[i][X | ln][Y][1] %= MOD;
                dp[i][X][Y][Z] %= MOD;
                dp[i][X][Y | rn][Z] %= MOD;
            }
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
        new FF().run();
    }

}
