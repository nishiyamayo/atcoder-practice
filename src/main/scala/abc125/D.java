package abc125;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

        long[][][] dp = new long[2][n + 1][2];
        dp[0][0][1] = -(1L << 60);
        int x = 1;
        for (int i = 1; i < n; i++) {
            dp[x][i][0] = Math.max(dp[1 - x][i - 1][0] + a[i], dp[1 - x][i - 1][1] - a[i]);
            dp[x][i][1] = Math.max(dp[1 - x][i - 1][0] - a[i], dp[1 - x][i - 1][1] + a[i]);
//            debug(dp[x][i]);
            x = 1 - x;
        }
        x = 1 - x;
        long ans = Math.max(dp[x][n - 1][0] + a[n], dp[x][n - 1][1] - a[n]);
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
