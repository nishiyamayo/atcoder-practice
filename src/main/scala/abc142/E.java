package abc142;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    int n, m;
    int[] a;
    int[] b;
    int[] c;
    long[] dp;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        a = new int[m];
        b = new int[m];
        c = new int[m];
        dp = new long[1 << n];


        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            for (int j = 0; j < b[i]; j++) {
                int cc = sc.nextInt() - 1;
                c[i] |= 1 << cc;
            }
        }

        long INF = (1L << 50);

        Arrays.fill(dp, (1L << 50));
        dp[0] = 0;

        for (int j = 0; j < 1 << n; j++) {
            for (int i = 0; i < m; i++) {
                int next = j | c[i];
                dp[next] = Math.min(dp[next], dp[j] + a[i]);
            }
        }
        System.out.println(dp[(1 << n) - 1] == INF ? -1 : dp[(1 << n) - 1]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}