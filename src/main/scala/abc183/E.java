package abc183;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int H = sc.nextInt(), W = sc.nextInt();

        long[][] dp = new long[H + 1][W + 1];
        long[][][] sum = new long[H + 1][W + 1][3];

        String[] S = new String[H + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= W; i++) {
            sb.append('#');
        }
        S[0] = sb.toString();
        for (int i = 1; i <= H; i++) {
            S[i] = "#" + sc.next();
        }
        dp[1][1] = 1;

        for (int h = 1; h <= H; h++) {
            for (int w = 1; w <= W; w++) {
                if (S[h].charAt(w) == '#') continue;
                if (h == w && h == 1) continue;
                dp[h][w] = dp[h - 1][w] + dp[h][w - 1] + dp[h - 1][w - 1];
                dp[h][w] += sum[h - 1][w - 1][0] + sum[h - 1][w][1] + sum[h][w - 1][2];
                dp[h][w] %= MOD;

                sum[h][w][0] = sum[h - 1][w - 1][0] + (S[h - 1].charAt(w - 1) == '.' ? dp[h - 1][w - 1] : 0);
                sum[h][w][1] = sum[h - 1][w][1] + (S[h - 1].charAt(w) == '.' ? dp[h - 1][w] : 0);
                sum[h][w][2] = sum[h][w - 1][2] + (S[h].charAt(w - 1) == '.' ? dp[h][w - 1] : 0);
                sum[h][w][0] %= MOD;
                sum[h][w][1] %= MOD;
                sum[h][w][2] %= MOD;

                debug(h, w, dp[h][w], sum[h][w]);
            }
        }

        out.println(dp[H][W]);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
