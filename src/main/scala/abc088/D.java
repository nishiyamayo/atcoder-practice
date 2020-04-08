package abc088;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
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

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int h = sc.nextInt(), w = sc.nextInt();
        boolean[][] map = new boolean[h + 2][w + 2];

        int bs = 0;
        for (int i = 1; i <= h; i++) {
            String s = sc.next();
            for (int j = 1; j <= w; j++) {
                map[i][j] = s.charAt(j - 1) == '.';
                if (!map[i][j]) bs++;
            }
        }

        int[][] d = new int[h + 2][w + 2];

        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        if (!map[1][1] || !map[h][w]) {
            out.println(-1);
        } else {
            for (int[] a : d) Arrays.fill(a, 1 << 28);
            d[1][1] = 0;
            PriorityQueue<P> q = new PriorityQueue<>();
            q.add(new P(1, 1, 0));

            boolean goal = false;
            while (!q.isEmpty()) {
                P cur = q.remove();
                if (d[cur.y][cur.x] != cur.c) continue;
                if (cur.y == h && cur.x == w) {
                    out.println(w * h - bs - cur.c - 1);
                    goal = true;
                }

                for (int i = 0; i < 4; i++)
                    if (map[cur.y + dy[i]][cur.x + dx[i]]) {
                        if (d[cur.y + dy[i]][cur.x + dx[i]] > cur.c + 1) {
                            q.add(new P(cur.x + dx[i], cur.y + dy[i], cur.c + 1));
                            d[cur.y + dy[i]][cur.x + dx[i]] = cur.c + 1;
                        }
                    }
            }
            if (!goal) {
                out.println(-1);
            }
        }

        out.flush();
    }

    class P implements Comparable<P> {
        int x, y, c;

        P(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(P o) {
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