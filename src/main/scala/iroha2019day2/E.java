package iroha2019day2;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        long MOD = (long)1e9 + 7;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        // 0: null, 1: B, 2: A
        long[][][][] dp = new long[n + m + 1][3][3][2];
        dp[0][0][0][0] = 1;
        for (int i = 1; i <= n + m; i++) {
            for (int p = 0; p < 3; p++) for (int pp = 0; pp < 3; pp++) {
                dp[i][1][p][0] = (dp[i][1][p][0] + dp[i - 1][p][pp][0]) % MOD;
            }

        }
    }
}
