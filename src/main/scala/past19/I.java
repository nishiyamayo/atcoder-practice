package past19;

import java.util.Arrays;
import java.util.Scanner;

public class I {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] items = new int[m];
        int[] costs = new int[m];
        for (int i = 0; i < m; i++) {
            String s = sc.next();
            costs[i] = sc.nextInt();
            for (int j = 0; j < n; j++) items[i] |= s.charAt(j) == 'Y' ? (1 << j) : 0;
        }

        long[] dp = new long[1 << n];
        Arrays.fill(dp, 1L << 60);
        dp[0] = 0;
        int len = 1 << n;
        for (int i = 0; i < m; i++) {
            for (int j = (1 << n) - 1; j >= 0; j--) {
                if ((j | items[i]) < len) {
                    dp[j | items[i]] = Math.min(dp[j | items[i]], dp[j] + costs[i]);
                }
            }
        }
        System.out.println(dp[(1 << n) - 1] != (1L << 60) ? dp[(1 << n) - 1] : -1);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new I().run();
    }

}
