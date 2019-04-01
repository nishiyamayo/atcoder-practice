package exawizards2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DD {

    long MOD = (long)1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int X = sc.nextInt();

        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.sort(a, Comparator.reverseOrder());
        long[][] dp = new long[2][X + 1];
        dp[0][X] = 1;
        int sw = 0;
        for (int i = 0; i < n; i++) {
            sw = 1 - sw;
            Arrays.fill(dp[sw], 0);
            for (int x = 0; x <= X; x++) if (dp[1 - sw][x] > 0) {
                dp[sw][x % a[i]] = (dp[sw][x % a[i]] + dp[1 - sw][x]) % MOD;
                dp[sw][x] = (dp[sw][x] + dp[1 - sw][x] * (n - i - 1)) % MOD;
            }
//            debug(dp[sw]);
        }

        long sum = 0;
        for (int x = 0; x <= X; x++) {
            sum += dp[sw][x] * x;
            sum %= MOD;
        }
        System.out.println(sum);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new DD().run();
    }
}
