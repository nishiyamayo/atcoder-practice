package abc147;

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

        boolean[][][] dp = new boolean[2][W + 1][160 * 80];

        dp[0][1][6400] = true;
        int x = 0;
        for (int h = 1; h <= H; h++) {
            x = 1 - x;
            Arrays.fill(dp[x][0], false);
            for (int w = 1; w <= W; w++) {
                for (int k = 0; k < 160 * 80; k++) {
                    if (dp[1 - x][w][k] || dp[x][w - 1][k]) {
                        dp[x][w][k + a[h][w] - b[h][w]] = true;
                        dp[x][w][k + b[h][w] - a[h][w]] = true;
                    }
                }
            }
        }
        int ans = 1 << 30;
//        for (boolean v : dp[x][W]) ans = Math.min(ans, Math.abs(v));
        System.out.println(ans);
    }

    class VS extends HashSet<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
