package edpc;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    long MAX = (long)1e15;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] ar = new long[n + 2];
        long[] dp = new long[3];

        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextLong();
        }

        dp[1] = dp[2] = MAX;
        dp[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            int idx = i % 3;
            int n1  = (idx + 1) % 3;
            int n2  = (idx + 2) % 3;
            dp[n1]  = Math.min(dp[n1], dp[idx] + Math.abs(ar[i] - ar[i + 1]));
            dp[n2]  = Math.min(dp[n2], dp[idx] + Math.abs(ar[i] - ar[i + 2]));
            dp[idx] = MAX;
        }
        System.out.println(dp[(n - 1) % 3]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
