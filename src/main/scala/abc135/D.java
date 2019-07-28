package abc135;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    long MOD = (long)1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = " " + sc.next();
        int n = s.length() - 1;
        int[][] dp = new int[n + 1][13];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i) == '?') {
                for (int j = 0; j < 13; j++) {
                    for (int k = 0; k < 10; k++) {
                        int r = (j * 10 + k) % 13;
                        dp[i][r] += dp[i - 1][j];
                        dp[i][r] %= MOD;
                    }
                }
            } else {
                int digit = s.charAt(i) - '0';
                for (int j = 0; j < 13; j++) {
                    int r = (j * 10 + digit) % 13;
                    dp[i][r] += dp[i - 1][j];
                    dp[i][r] %= MOD;
                }
            }
//            debug(dp[rev]);
        }

        System.out.println(dp[n][5]);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
