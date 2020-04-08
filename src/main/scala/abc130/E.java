package abc130;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public E() {
        this(System.in, System.out);
    }

    public E(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt();
        int[] s = new int[n], t = new int[m];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            t[i] = sc.nextInt();
        }

        long[][] dp = new long[n + 1][m + 1];
        long[][] sum = new long[n + 1][m + 1];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i] == t[j]) {
                    dp[i + 1][j + 1] = (sum[i][j] + 1) % MOD;
                }
                sum[i + 1][j + 1] = (MOD + sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + dp[i + 1][j + 1]) % MOD;
//                debug(i, j);
//                debug(dp[i + 1]);
//                debug(sum[i + 1]);
            }
        }

        out.println((sum[n][m] + 1) % MOD);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}