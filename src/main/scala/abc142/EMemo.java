package abc142;

import java.util.Arrays;
import java.util.Scanner;

public class EMemo {
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

        memo = new long[1 << 12];
        Arrays.fill(memo, -1);

        long ans = solve(0);
        System.out.println(ans == INF ? -1 : ans);
    }

    long INF = 1L << 60;

    long[] memo;
    // 状態Sを満たす最小のコストを返す。
    long solve(int S) {

        if (memo[S] > -1) {
            return memo[S];
        }
        if ((1 << n) - 1 == S) {
            return memo[S] = 0;
        }

        long min = INF;
        for (int i = 0; i < m; i++) {
            if ((S | c[i]) == S) {
                continue;
            }
            min = Math.min(min, solve(S | c[i]) + a[i]);
        }

        return memo[S] = min;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new EMemo().run();
    }

}
