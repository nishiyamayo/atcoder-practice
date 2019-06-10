package abc129;

import java.util.Arrays;
import java.util.Scanner;

public class E {

    long MOD = (long)1e9 + 7;

    // (0, 0), (1, 0), (0, 1)
    // (0, 0), (1, 0), (0, 1)
    // (0, 0)
    //

    // 110110

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n  = s.length();

        long[] dp1 = new long[n];
        long[] dp2 = new long[n];

        dp1[0] = 1;
        dp2[0] = 2;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                dp1[i] = (3 * dp1[i - 1] + dp2[i - 1]) % MOD;
                dp2[i] = 2 * dp2[i - 1] % MOD;
            } else {
                dp1[i] = 3 * dp1[i - 1] % MOD;
                dp2[i] = dp2[i - 1];
            }
        }

        System.out.println((dp1[n - 1] + dp2[n - 1]) % MOD);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
