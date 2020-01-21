package gym102152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class L {
    int N, M, H, W;
    int[][] board;

    void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String[] s = stdin.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        H = Integer.parseInt(s[2]);
        W = Integer.parseInt(s[3]);
        cnt = new int[N + 2][M + 2];
        board = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            s = stdin.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        // 解を二分探索。(l, r]の範囲を絞る
        int l = 0, r = N * M;

        while (l + 1 < r) {
            int c = (l + r) / 2;
            if (ok(c)) {
                r = c;
            } else {
                l = c;
            }
        }
        System.out.println(r);
    }

    int[][] cnt;

    boolean ok(int x) {
        for (int[] a : cnt) Arrays.fill(a, 0);

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++) {
                if (board[i][j] > x) continue;
                int lux = Math.max(1, j - W + 1);
                int luy = Math.max(1, i - H + 1);

                // (j, i)の数字board[i][j] ( < x) が含まれる長方形（の左上のマス）をカウントアップしたい
                // いもす法を活用して (lux, luy) と (j + 1, i + 1) に +1 、(lux, i + 1) と (j + 1. luy)
                // に -1 して判定直前に累積和を取ることで O(NM) で計算可能にする
                cnt[luy][lux]++;
                cnt[luy][j + 1]--;
                cnt[i + 1][lux]--;
                cnt[i + 1][j + 1]++;
            }

        int max = 0;
        // 最後に累積和をとって判定
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++) {
                cnt[i][j] += cnt[i - 1][j] + cnt[i][j - 1] - cnt[i - 1][j - 1];
                max = Math.max(max, cnt[i][j]);
            }

        return max > H * W / 2;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        try {
            new L().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
