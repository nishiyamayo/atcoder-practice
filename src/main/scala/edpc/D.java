package edpc;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    long MAX = (long)1e15;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), w = sc.nextInt();
        long[] dp = new long[w + 1];
        int[] wn = new int[n];
        long[] vn = new long[n];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            wn[i] = sc.nextInt();
            vn[i] = sc.nextLong();
        }


        for(int j = 0; j < n; j++) for (int i = w; i >= 0; i--) if (dp[i] >= 0 && i + wn[j] <= w) {
            dp[i + wn[j]] = Math.max(dp[i + wn[j]], dp[i] + vn[j]);
        }

        long ans = 0;
        for (int i = 0; i <= w; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
