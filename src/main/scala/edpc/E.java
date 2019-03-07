package edpc;

import java.util.Arrays;
import java.util.Scanner;

public class E {

    long MAX = (long)1e15;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), w = sc.nextInt();
        int len = 1000 * n;
        long[] dp = new long[len + 1];
        long[] wn = new long[n];
        int[] vn = new int[n];

        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            wn[i] = sc.nextLong();
            vn[i] = sc.nextInt();
        }


        for(int j = 0; j < n; j++) for (int i = len; i >= 0; i--) if (dp[i] + wn[j] <= w && i + vn[j] <= len) {
            dp[i + vn[j]] = Math.min(dp[i + vn[j]], dp[i] + wn[j]);
        }

        long ans = 0;
        for (int i = len;; i--) if (dp[i] != MAX) {
            System.out.println(i);
            break;
        }
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
