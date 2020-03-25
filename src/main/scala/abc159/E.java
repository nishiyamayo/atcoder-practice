package abc159;

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

    int h, w;
    int k;
    boolean[][] board;
    int[][] map;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        h = sc.nextInt();
        w = sc.nextInt();
        k = sc.nextInt();
        board = new boolean[h][w];
        map = new int[h + 1][w + 1];


        for (int i = 0; i < h; i++) {
            String s = sc.next();
            for (int j = 0; j < w; j++) {
                board[i][j] = s.charAt(j) == '1';
                map[i + 1][j + 1] += (board[i][j] ? 1 : 0) - map[i][j + 1] - map[i + 1][j] + map[i][j];
            }
        }

        int ans = 1 << 30;
        for (int i = 0; i < (1 << (h - 1)); i++) {
            int from = 0;
            int cnt = Integer.bitCount(i);
            from = ok(i, from);
            if (from < 0) continue;
            while (from < w) {
//                debug("", from);
                cnt++;
                from++;
                from = ok(i, from);
            }
//            debug(Integer.toBinaryString(i), cnt);
            ans = Math.min(ans, cnt);
        }

        out.println(ans);
        out.flush();
    }

    int ok(int S, int from) {
        int sp = Integer.bitCount(S) + 1;
        int[] sum = new int[sp];
        int start = from;
        while (start < w) {
            int st = 0;
            for (int j = 0; j < h; j++) {
                sum[st] += board[j][start] ? 1 : 0;
                if (((S >> j) & 1) == 1) {
                    st++;
                }
            }
//            debug("", sum, start);
            for (int i = 0; i < sp; i++) {
                if (sum[i] > k) return start != from ? start - 1 : -1;
            }
            start++;
        }

        return start;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}