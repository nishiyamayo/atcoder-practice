package iroha2019day1;

import java.util.Arrays;
import java.util.Scanner;

public class G {

    long INF = 1L << 60;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        long[] as = new long[n];
        for (int i = 0; i < n; i++) as[i] = sc.nextInt();

        long[][][] dp = new long[2][m + 1][k];
        for (int i = 0; i < m; i++) Arrays.fill(dp[0][i], -INF);
        dp[0][0][0] = 0;

        int x = 0;
        for (int i = 0; i < n; i++) {
            x = 1 - x;
            for (int t = 0; t <= m; t++) Arrays.fill(dp[x][t], -INF);
            for (int j = 0; j < m; j++) for (int h = 0; h < k; h++) {
                dp[x][j + 1][0] = Math.max(dp[x][j + 1][0], dp[1 - x][j][h] + as[i]);
            }
            for (int j = 0; j <= m; j++) for (int h = 0; h < k - 1; h++){
                dp[x][j][h + 1] = Math.max(dp[x][j][h + 1], dp[1 - x][j][h]);
            }
//            debug(dp[x]);
        }
        long ans = -1;
        for (int i = 0; i <= m; i++) for (int j = 0; j < k; j++) {
            ans = Math.max(ans, dp[x][i][j]);
        }

        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new G().run();
    }
}
