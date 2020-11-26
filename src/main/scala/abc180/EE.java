package abc180;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class EE {
    long MOD = (long) 1e9 + 7;
    long INF = 1L << 60;

    InputStream in = System.in;
    OutputStream out = System.out;
    int n;
    int[] x, y, z;
    long[][] dp;
    long[][] ds;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        z = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            z[i] = sc.nextInt();
        }

        ds = new long[n][n];

        for (int f = 0; f < n; f++) {
            for (int t = 0; t < n; t++) {
                ds[f][t] = Math.abs(x[f] - x[t]) + Math.abs(y[f] - y[t]) + Math.max(0, z[t] - z[f]);
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ds[i][j] = Math.min(ds[i][j], ds[i][k] + ds[k][j]);
                }
            }
        }

        dp = new long[1 << n][n];
        for (long[] a : dp) Arrays.fill(a, INF);

        dp[1][0] = 0;

        for (int S = 1; S < (1 << n); S++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    if (((S >> to) & 1) == 1) continue;
                    dp[S | (1 << to)][to] = Math.min(dp[S | (1 << to)][to], dp[S][from] + ds[from][to]);
                }
            }
        }

        long ans = INF;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[(1 << n) - 1][i] + ds[i][0]);
        }
        out.println(ans);
        // out.println(rec(1, 0));
        out.flush();
    }

    long rec(int S, int v) {

        if (dp[S][v] >= 0) return dp[S][v];
        if (S == (1 << n) - 1) {
            return dp[S][v] = ds[v][0];
        }

        long ret = 1L << 60;
        for (int i = 0; i < n; i++) {
            if (((S >> i) & 1) == 1) continue;
            ret = Math.min(ret, rec(S | (1 << i), i) + ds[v][i]);
        }

        return dp[S][v] = ret;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new EE().run();
    }
}
