package vprocon.con07;

import java.util.Arrays;
import java.util.Scanner;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        int k = sc.nextInt();

        long[][] dp = new long[2][k + 1];
        dp[0][0] = 0;
        int x = 0;
        int cnt = 0;
        boolean end = false;
        for (;!end; cnt++) {
            x = 1 - x;
            dp[x][0] = dp[1 - x][0];
            for (int i = 1; i <= k; i++) {
                dp[x][i] = Math.max(dp[1 - x][i] + Math.min(dp[1 - x][i], (n - dp[1 - x][i]) / 2), dp[x][i - 1] + 1);
                if (dp[x][i] >= n) end = true;
            }
        }
        System.out.println(cnt);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
