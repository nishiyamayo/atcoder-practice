package abc176;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D
{
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int H, W;
    boolean[][] board;
    int sx, sy, gx, gy;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        H = sc.nextInt(); W = sc.nextInt();
        board = new boolean[H + 10][W + 10];
        sy = sc.nextInt() + 3; sx = sc.nextInt() + 3;
        gy = sc.nextInt() + 3; gx = sc.nextInt() + 3;

        for (int i = 4; i < H + 4; i++) {
            String s = sc.next();
            for (int j = 4; j < W + 4; j++) {
                board[i][j] = s.charAt(j - 4) == '.';
            }
        }

        debug(sx, sy, gx, gy);

        out.println(dijkstra());

        out.flush();
    }

    int dijkstra() {
        int[][] d = new int[H + 10][W + 10];
        for (int[] a : d) Arrays.fill(a, 1 << 28);

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(sx, sy, 0));
        d[sy][sx] = 0;


        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            Pair cur = q.remove();
            if (d[cur.y][cur.x] != cur.c) continue;

            if (cur.x == gx && cur.y == gy) return cur.c;

            for (int i = 0; i < 4; i++) {
                if (board[cur.y + dy[i]][cur.x + dx[i]] && d[cur.y + dy[i]][cur.x + dx[i]] > cur.c) {
                    q.add(new Pair(cur.x + dx[i], cur.y + dy[i], cur.c));
                    d[cur.y + dy[i]][cur.x + dx[i]] = cur.c;
                }
            }

            for (int h = -2; h < 3; h++) {
                for (int w = -2; w < 3; w++) {
                    if (board[cur.y + h][cur.x + w] && d[cur.y + h][cur.x + w] > cur.c + 1) {
                        q.add(new Pair(cur.x + w, cur.y + h, cur.c + 1));
                        d[cur.y + h][cur.x + w] = cur.c + 1;
                    }
                }
            }
        }
        return -1;
    }

    class Pair implements Comparable<Pair> {
        int x, y, c;
        Pair(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            return c - o.c;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}