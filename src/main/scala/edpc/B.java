package edpc;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    long MAX = (long)1e15;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] ar = new long[n + k + 10];
        long[] dp = new long[k + 1];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextLong();
        }

        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            int idx = i % (k + 1);
            for (int j = 1; j <= k; j++) {
                int next  = (idx + j) % (k + 1);
                dp[next]  = Math.min(dp[next], dp[idx] + Math.abs(ar[i] - ar[i + j]));
            }
            dp[idx] = MAX;
        }
//        debug(dp);
        System.out.println(dp[(n - 1) % (k + 1)]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
