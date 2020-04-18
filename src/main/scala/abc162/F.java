package abc162;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public F() {
        this(System.in, System.out);
    }

    public F(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        // write your code
        int n = sc.nextInt();
        long[] as = new long[n];

        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }

        // dp[n][c][b] := i個目まで見て、2連続で使わないことがc回あり、直前の数を使和ない: b = 0, 使ったb = 1 時の最大値
        long[][][] dp = new long[n + 1][3][2];
        for (long[][] a : dp) for (long[] b : a) Arrays.fill(b, -(1L << 60));
        dp[1][1][0] = 0;
        dp[1][0][1] = as[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1][0][0] = dp[i][0][1];
            dp[i + 1][0][1] = dp[i][0][0] + as[i];
            dp[i + 1][1][0] = Math.max(dp[i][0][0], dp[i][1][1]);
            dp[i + 1][1][1] = dp[i][1][0] + as[i];
            dp[i + 1][2][0] = Math.max(dp[i][1][0], dp[i][2][1]);
            dp[i + 1][2][1] = dp[i][2][0] + as[i];
//            debug(dp[i + 1]);
        }

        long ans = -(1L << 50);
        if (n % 2 == 0) {
            ans = Math.max(dp[n][0][0], dp[n][1][1]);
        } else {
            ans = Math.max(dp[n][2][1], dp[n][1][0]);
//            ans = Math.max(dp[n][1][0], ans);
        }
        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}