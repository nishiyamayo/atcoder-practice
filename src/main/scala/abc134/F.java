package abc134;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class F {

    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[][][] dp = new long[N + 1][N + 1][K + 1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= K; k++) {
                    if (0 > k - 2 * j || k - 2 * j > K ) continue;

                    dp[i][j][k] = (2 * j + 1) * dp[i - 1][j][k - 2 * j];
                    if (j < N) dp[i][j][k] += (j + 1) * (j + 1) * dp[i - 1][j + 1][k - 2 * j];
                    if (j > 0) dp[i][j][k] += dp[i - 1][j - 1][k - 2 * j];
                    dp[i][j][k] %= MOD;
                }
            }
//            debug(dp[i]);
        }
        System.out.println(dp[N][0][K]);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
