package abc129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C {

    long MOD = (long)1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[] ng = new int[m];
        for (int i = 0; i < m; i++) {
            ng[i] = sc.nextInt();
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;

        int p;
        if (m != 0) {
            dp[1] = ng[0] == 1 ? 0 : 1;
            p = ng[0] == 1 ? 1 : 0;
        } else {
            dp[1] = 1;
            p = 0;
        }

        for (int i = 2; i <= n; i++) {
            if (p < m && ng[p] == i) {
                p++;
                continue;
            }
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
//        debug(dp);
        System.out.println(dp[n]);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
