package abc122;

import java.util.*;

public class D {

    long MOD = (long)1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][][][] dp = new long[n + 1][5][5][5];
        // 0: null, 1: A, 2: G, 3: C, 4: T
        dp[0][0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int a = 0; a <= 4; a++) for (int b = 0; b <= 4; b++) for (int c = 0; c <= 4; c++) for (int d = 1; d <= 4; d++) {
                if (d == 3 && c == 2 && b == 1) continue;
                if (d == 3 && c == 1 && b == 2) continue;
                if (d == 2 && c == 3 && b == 1) continue;
                if (d == 3 && c == 2 && b == 4 && a == 1) continue;
                if (d == 3 && c == 4 && b == 2 && a == 1) continue;
                if (d == 3 && c == 2 && b == 2 && a == 1) continue;
                dp[i][d][c][b] += dp[i - 1][c][b][a];
                dp[i][d][c][b] %= MOD;
            }
        }
        long ans = 0;
        for (int a = 0; a <= 4; a++) for (int b = 0; b <= 4; b++) for (int c = 0; c <= 4; c++) {
            ans += dp[n][c][b][a];
            ans %= MOD;
        }

        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
