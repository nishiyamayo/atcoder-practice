package abc170;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;
    int INF = 1 << 28;

    InputStream in;
    OutputStream out;

    public F() {
        this(System.in, System.out);
    }

    public F(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int h, w, k;
    int[][] board;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        h = sc.nextInt();
        w = sc.nextInt();
        k = sc.nextInt();
        int sy = sc.nextInt(), sx = sc.nextInt(), gy = sc.nextInt(), gx = sc.nextInt();
        board = new int[h + 2][w + 2];
        for (int[] a : board) Arrays.fill(a, -1);

        for (int i = 1; i <= h; i++) {
            String s = sc.next();
            for (int j = 1; j <= w; j++) {
                board[i][j] = s.charAt(j - 1) == '@' ? -1 : INF;
            }
        }

        out.println(dijkstra(sx, sy, gx, gy));


        out.flush();
    }

    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    long dijkstra(int sx, int sy, int gx, int gy) {
        long[][][] d = new long[h + 2][w + 2][4];
        for (long[][] a : d) for (long[] b : a) Arrays.fill(b, -1);
        for (int i = 1; i <= h; i++)
            for (int j = 1; j <= w; j++) {
                d[i][j][0] = d[i][j][1] = d[i][j][2] = d[i][j][3] = board[i][j];
            }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(sx, sy, 0, 0));
        q.add(new Node(sx, sy, 1, 0));
        q.add(new Node(sx, sy, 2, 0));
        q.add(new Node(sx, sy, 3, 0));
        d[sy][sx][0] = d[sy][sx][1] = d[sy][sx][2] = d[sy][sx][3] = 0;

        while (!q.isEmpty()) {
            Node cur = q.remove();
//            debug(cur.x, cur.y, cur.d, cur.cnt);
            if (cur.x == gx && cur.y == gy) {
                return (cur.cnt + k - 1) / k;
            }
            if (d[cur.y][cur.x][cur.d] != cur.cnt) continue;

            for (int i = 0; i < 4; i++) {
                if (i == cur.d) {
                    if (d[cur.y + dy[i]][cur.x + dx[i]][i] > cur.cnt + 1) {
                        d[cur.y + dy[i]][cur.x + dx[i]][i] = cur.cnt + 1;
                        q.add(new Node(cur.x + dx[i], cur.y + dy[i], i, cur.cnt + 1));
                    }
                } else {
                    long nxCnt = (cur.cnt + k - 1) / k * k;
                    if (d[cur.y + dy[i]][cur.x + dx[i]][i] > nxCnt + 1) {
                        d[cur.y + dy[i]][cur.x + dx[i]][i] = nxCnt + 1;
                        q.add(new Node(cur.x + dx[i], cur.y + dy[i], i, nxCnt + 1));
                    }
                }
            }
        }
        return -1;
    }

    class Node implements Comparable<Node> {
        int x, y, d;
        long cnt;

        Node(int x, int y, int cnt) {
            this(x, y, -1, cnt);
        }

        Node(int x, int y, int d, long cnt) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.cnt = cnt;

        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(cnt, o.cnt);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}