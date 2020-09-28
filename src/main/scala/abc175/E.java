package abc175;

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
        int R = sc.nextInt(), C = sc.nextInt(), K = sc.nextInt();
        int[][] board = new int[R + 1][C + 1];
        for (int i = 0; i < K; i++) {
            board[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        long[][][] dp = new long[R + 1][C + 1][4];

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                dp[r][c][0] = max(dp[r - 1][c]);
                dp[r][c][0] = max(dp[r][c][0], dp[r][c - 1][0]);
                dp[r][c][1] = max(dp[r - 1][c]) + board[r][c];
                dp[r][c][1] = max(dp[r][c][1], dp[r][c - 1][1], dp[r][c - 1][0] + board[r][c]);
                dp[r][c][2] = max(dp[r][c - 1][2], dp[r][c - 1][1] + board[r][c]);
                dp[r][c][3] = max(dp[r][c - 1][3], dp[r][c - 1][2] + board[r][c]);
            }
        }

        out.println(max(dp[R][C]));

        out.flush();
    }

    long max(long...vals) {
        long max = 0;
        for (long v : vals) {
            max = Math.max(max, v);
        }
        return max;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}