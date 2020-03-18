package abc104;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt(), g = sc.nextInt();
        int[] ps = new int[d], cs = new int[d];

        for (int i = 0; i < d; i++) {
            ps[i] = sc.nextInt();
            cs[i] = sc.nextInt();
        }

        int L = 100 * 10;
        long[] dp = new long[L + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < d; i++) {
            for (int j = L; j >= 0; j--) {
                if (dp[j] >= 0) {
                    for (int k = 1; k < ps[i]; k++) {
                        dp[j + k] = Math.max(dp[j + k], dp[j] + k * (i + 1) * 100);
                    }
                    dp[j + ps[i]] = Math.max(dp[j + ps[i]], dp[j] + ps[i] * (i + 1) * 100 + cs[i]);
                }
            }
        }
//        debug(dp);
        for (int i = 1; i <= L; i++) {
            if (dp[i] >= g) {
                System.out.println(i);
                return;
            }
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }

}
