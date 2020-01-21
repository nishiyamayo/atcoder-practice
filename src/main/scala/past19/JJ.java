package past19;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JJ {
    int H, W;
    long INF = 1L << 60;

    void run() {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();

        long[][] board1 = new long[H + 2][W + 2];
        for (long[] a : board1) Arrays.fill(a, INF);
        for (int h = 1; h <= H; h++) for (int w = 1; w <= W; w++) {
            board1[h][w] = sc.nextInt();
        }

        long ans = 1L << 60;
        for (int h = 1; h <= H; h++) for (int w = 1; w <= W; w++) {
            ans = Math.min(ans, dijkstra(w, h, board1));
        }

        System.out.println(ans);
    }

    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    long dijkstra(int sx, int sy, long[][] board) {
        long[][] cost = new long[H + 2][W + 2];
        for (long[] a : cost) Arrays.fill(a, INF);

        cost[sy][sx] = 0;
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(sx, sy, 0));

        boolean isGoal = false;
        while (!q.isEmpty()) {
            Point cur = q.remove();
//            debug(cur.x, cur.y, cur.cost);

            if (cur.x <= 0 || cur.x >= W + 1 || cur.y <= 0 || cur.y >= H + 1) continue;

            for (int i = 0; i < 4; i++) if (cost[cur.y + dy[i]][cur.x + dx[i]] > cur.cost + board[cur.y + dy[i]][cur.x + dx[i]]) {
                q.add(new Point(cur.x + dx[i], cur.y + dy[i], cur.cost + board[cur.y + dy[i]][cur.x + dx[i]]));
                cost[cur.y + dy[i]][cur.x + dx[i]] = cur.cost + board[cur.y + dy[i]][cur.x + dx[i]];
            }
        }
//        debug(cost[1][W] + cost[H][1] + cost[H][W]);
//        for (long[] a: cost) debug(a);
        return board[sy][sx] + cost[1][W] + cost[H][1] + cost[H][W];
    }

    class Point implements Comparable<Point> {
        int x, y;
        long cost;
        Point(int x, int y, long cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return Long.compare(cost, o.cost);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ", " + cost + ")";
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new JJ().run();
    }

}
