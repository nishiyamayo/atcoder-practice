package past002;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class K {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public K() {
        this(System.in, System.out);
    }

    public K(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        String s = sc.next();
        int[] cs = new int[n];
        int[] ds = new int[n];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ds[i] = sc.nextInt();
        }

        long[][] dp = new long[2][n + 1];
        int x = 0;
        Arrays.fill(dp[0], 1L << 60);
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            x = 1 - x;
            char c = s.charAt(i);
            Arrays.fill(dp[x], 1L << 60);
            for (int j = 0; j <= n; j++) {
                if (c == '(') {
                    // そのまま追加
                    if (j < n - 1)
                        dp[x][j + 1] = Math.min(dp[x][j + 1], dp[1 - x][j]);
                    // 反転
                    if (j > 0)
                        dp[x][j - 1] = Math.min(dp[x][j - 1], dp[1 - x][j] + cs[i]);
                    // 削除
                    dp[x][j] = Math.min(dp[x][j], dp[1 - x][j] + ds[i]);
                } else {
                    // そのまま追加
                    if (j > 0)
                        dp[x][j - 1] = Math.min(dp[x][j - 1], dp[1 - x][j]);
                    // 反転
                    if (j < n - 1)
                        dp[x][j + 1] = Math.min(dp[x][j + 1], dp[1 - x][j] + cs[i]);
                    // 削除
                    dp[x][j] = Math.min(dp[x][j], dp[1 - x][j] + ds[i]);
                }
            }
//            debug(dp[x]);
        }

        out.println(dp[x][0]);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new K().run();
    }
}