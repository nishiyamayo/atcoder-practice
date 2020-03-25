package agc043;

import past19.H;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class A {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public A() {
        this(System.in, System.out);
    }

    public A(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code

        int H = sc.nextInt(), W = sc.nextInt();
        boolean[][] map = new boolean[H][W];
        for (int h = 0; h < H; h++) {
            String s = sc.next();
            for (int w = 0; w < W; w++) {
                map[h][w] = s.charAt(w) == '#';
            }
        }

        // dp[h][w][f] := (w, h) の色を白にするためにflipしている: 1, していない:0時の最小回数
        int[][][] dp = new int[H + 1][W + 1][2];
        for (int[][] a: dp) for (int[] b : a) Arrays.fill(b, 1 << 30);
        dp[1][1][map[0][0] ? 1 : 0] = map[0][0] ? 1 : 0;

        for (int h = 1; h <= H; h++) {
            for (int w = 1; w <= W; w++) {
                if (w > 1) {
                    if (map[h - 1][w - 2] == map[h - 1][w - 1]) {
                        dp[h][w][0] = Math.min(dp[h][w][0], dp[h][w - 1][0]);
                        dp[h][w][1] = Math.min(dp[h][w][1], dp[h][w - 1][1]);
                    } else {
                        dp[h][w][0] = Math.min(dp[h][w][0], dp[h][w - 1][1]);
                        dp[h][w][1] = Math.min(dp[h][w][1], dp[h][w - 1][0] + 1);
                    }
                }
                if (h > 1) {
                    if (map[h - 2][w - 1] == map[h - 1][w - 1]) {
                        dp[h][w][0] = Math.min(dp[h][w][0], dp[h - 1][w][0]);
                        dp[h][w][1] = Math.min(dp[h][w][1], dp[h - 1][w][1]);
                    } else {
                        dp[h][w][0] = Math.min(dp[h][w][0], dp[h - 1][w][1]);
                        dp[h][w][1] = Math.min(dp[h][w][1], dp[h - 1][w][0] + 1);
                    }
                }
//                debug(w, h, dp[h][w][0], dp[h][w][1]);
            }
        }
        out.println(dp[H][W][map[H - 1][W - 1] ? 1 : 0]);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}