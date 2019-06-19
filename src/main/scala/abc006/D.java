package abc006;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        int[][] dp = new int[2][n + 1];
        int x = 0, ans = 0;
        for (ans = 1;; ans++) {
            x = 1 - x;
            boolean ok = false;
            dp[x][ans - 1] = n + 1;
            for (int i = ans; i <= n; i++) {
                if (dp[1 - x][i] < a[i] && dp[x][i - 1] > a[i]) {
                    dp[x][i] = a[i];
                    ok = true;
                } else {
                    dp[x][i] = dp[x][i - 1];
                }
            }
//            debug(dp[x]);
            if (!ok) break;
        }

        System.out.println(n - (ans - 1));

    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
