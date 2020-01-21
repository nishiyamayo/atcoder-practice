package past19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class J {
    int H, W;
    long INF = 1L << 60;

    void run() {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();

        long[][] board1 = new long[H + 2][W + 2], board2 = new long[H + 2][W + 2], board3 = new long[H + 2][W + 2];
        for (long[] a : board1) Arrays.fill(a, INF);
        for (long[] a : board2) Arrays.fill(a, INF);
        for (long[] a : board3) Arrays.fill(a, INF);
        for (int h = 1; h <= H; h++) for (int w = 1; w <= W; w++) {
            board1[h][w] = board2[h][w] = board3[h][w] = sc.nextInt();
        }

        long ans1 = dijkstra(1, H, W, H, board1);
        ans1 += dijkstra(W, H, W, 1, board1);
        long ans2 = dijkstra(1, H, W, 1, board2);
        ans2 += dijkstra(1, H, W, H, board2);
        long ans3 = dijkstra(W, H, W, 1, board3);
        ans3 += dijkstra(1, H, W, H, board3);
        System.out.println(Math.min(ans1, Math.min(ans2, ans3)));
    }

    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    long dijkstra(int sx, int sy, int gx, int gy, long[][] board) {
//        debug("start", sx, sy);
//        for (long[] x: board1) debug(x);
        long[][] cost = new long[H + 2][W + 2];
        for (long[] a : cost) Arrays.fill(a, INF);

        Dir[][] dir = new Dir[H + 2][W + 2];
        for (int h = 0; h < H + 2; h++) for (int w = 0; w < W + 2; w++) {
            dir[h][w] = new Dir();
        }

            cost[sy][sx] = 0;
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(sx, sy, 0));

        boolean isGoal = false;
        while (!q.isEmpty()) {
            Point cur = q.remove();
//            debug(cur.x, cur.y, cur.cost);
            if (isGoal && cur.cost > cost[gy][gx]) break;
            if (gx == cur.x && gy == cur.y) {
                isGoal = true;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if (cost[cur.y + dy[i]][cur.x + dx[i]] > cost[cur.y][cur.x] + board[cur.y + dy[i]][cur.x + dx[i]]) {
                    dir[cur.y + dy[i]][cur.x + dx[i]].clear();
                    dir[cur.y + dy[i]][cur.x + dx[i]].add(new Point(cur.x, cur.y, 0));
                    cost[cur.y + dy[i]][cur.x + dx[i]] = cur.cost + board[cur.y + dy[i]][cur.x + dx[i]];
                    q.add(new Point(cur.x + dx[i], cur.y + dy[i], cur.cost + board[cur.y + dy[i]][cur.x + dx[i]]));
                } else if (cost[cur.y + dy[i]][cur.x + dx[i]] == cost[cur.y][cur.x] + board[cur.y + dy[i]][cur.x + dx[i]]) {
                    dir[cur.y + dy[i]][cur.x + dx[i]].add(new Point(cur.x, cur.y, 0));
                }
            }
        }
        constractRoute(sx, sy, gx, gy, dir, board, new boolean[H + 2][W + 2]);
        return cost[gy][gx];
    }

    void constractRoute(int sx, int sy, int gx, int gy, Dir[][] dir, long[][] board, boolean[][] visited) {
        board[gy][gx] = 0;
        visited[gy][gx] = true;
        if (sx == gx && sy == gy) return;

        for (Point p : dir[gy][gx]) if (!visited[p.y][p.x]) {
            constractRoute(sx, sy, p.x, p.y, dir, board, visited);
        }
    }

    class Dir extends ArrayList<Point> {}

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
        new J().run();
    }

}
