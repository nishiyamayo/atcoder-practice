package tenkaitchi2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class D {

    long MOD = 998244353;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }

        long[][] dp1 = new long[2][sum + 1];
        long[][] dp2 = new long[2][sum + 1];
        dp1[0][0] = dp2[0][0] = 1;

        int x = 1;

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp1[x], 0);
            Arrays.fill(dp2[x], 0);
            for (int j = sum; j >= 0; j--) {
                if (j >= a[i])
                    dp1[x][j] = (dp1[x][j] + dp1[1 - x][j - a[i]]) % MOD;
                dp1[x][j] = (dp1[x][j] + 2 * dp1[1 - x][j]) % MOD;
                if (j >= a[i])
                    dp2[x][j] = (dp2[x][j] + dp2[1 - x][j - a[i]]) % MOD;
                dp2[x][j] = (dp2[x][j] + dp2[1 - x][j]) % MOD;
            }
//            debug(dp1[x]);
//            debug(dp2[x]);
            x = 1 - x;
        }

        long ans = 1;

        for (int i = 0; i < n; i++) ans = (ans * 3) % MOD;
        for (int i = (sum + 1) / 2; i <= sum; i++) {
            ans = (ans - 3 * dp1[1 - x][i] + 3 * MOD) % MOD;
        }

        if (sum % 2 == 0) ans = (ans + 3 * dp2[1 - x][sum / 2]) % MOD;

        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
