package abc147;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(), W = sc.nextInt();

        int[][] a = new int[H + 1][W + 1], b = new int[H + 1][W + 1];
        for (int i = 1; i <= H; i++) for (int j = 1; j <= W; j++) {
            a[i][j] = sc.nextInt();
        }
        for (int i = 1; i <= H; i++) for (int j = 1; j <= W; j++) {
            b[i][j] = sc.nextInt();
        }

        boolean[][][] dp = new boolean[2][W + 1][160 * 80 + 1];

        dp[0][1][160 * 40] = true;
        int x = 0;
        for (int h = 1; h <= H; h++) {
            x = 1 - x;
            for (int w = 1; w <= W; w++) {
                Arrays.fill(dp[x][w], false);
//                HashSet<Integer> ok = new HashSet<>();
                for (int k = 0; k <= 12800; k++) {
                    if (dp[1 - x][w][k] || dp[x][w - 1][k]) {
//                        debug(dp[1 - x][w][k], dp[x][w - 1][k], x, h, w, k);
                        if (0 <= k + a[h][w] - b[h][w] && k + a[h][w] - b[h][w] <= 12800) {
                            dp[x][w][k + a[h][w] - b[h][w]] = true;
//                            ok.add(k + a[h][w] - b[h][w]);
                        }
                        if (0 <= k - a[h][w] + b[h][w] && k - a[h][w] + b[h][w] <= 12800) {
                            dp[x][w][k + b[h][w] - a[h][w]] = true;
//                            ok.add(k + b[h][w] - a[h][w]);
                        }
                    }
                }
//                debug(h, w, ok);
            }
        }

        int ans = 1 << 30;
        for (int d = 0; d <= 12800; d++) {
//            debug(dp[x][W][d], d);
            if (dp[x][W][d]) ans = Math.min(ans, Math.abs(d - 6400));
        }
        System.out.println(ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
