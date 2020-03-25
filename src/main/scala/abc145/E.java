package abc145;

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
        int n = sc.nextInt(), t = sc.nextInt();
        int[] as = new int[n], bs = new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            as[i] = a;
            bs[i] = b;
        }

        long[][] dp1 = new long[n][t], dp2 = new long[n][t];
        for (int i = as[0]; i < t; i++) {
            dp1[0][i] = bs[0];
        }
        for (int i = as[n - 1]; i < t; i++) {
            dp2[n - 1][i] = bs[n - 1];
        }

        for (int i = 1; i < n; i++) {
            int i1 = i, i2 = n - i - 1;
            for (int j = t - 1; j >= 0; j--) {
                if (j + as[i1] < t) {
                    dp1[i1][j + as[i1]] = Math.max(dp1[i1][j + as[i1]], dp1[i1 - 1][j] + bs[i1]);
                }
                if (j + as[i2] < t) {
                    dp2[i2][j + as[i2]] = Math.max(dp2[i2][j + as[i2]], dp2[i2 + 1][j] + bs[i2]);
                }
                dp1[i1][j] = Math.max(dp1[i1][j], dp1[i1 - 1][j]);
                dp2[i2][j] = Math.max(dp2[i2][j], dp2[i2 + 1][j]);
            }
//            debug(dp1[i1]);
//            debug(dp2[i2]);
        }

        long ans = Math.max(bs[0] + dp2[1][t - 1], dp1[n - 2][t - 1] + bs[n - 1]);
//        debug(ans);
        for (int i = 1; i < n - 1; i++)
            for (int j = 0; j < t; j++) {
                ans = Math.max(ans, dp1[i - 1][j] + dp2[i + 1][t - j - 1] + bs[i]);
            }
        out.println(ans);
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}