package joi2017;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(), W = sc.nextInt();
        long[][] A = new long[H + 2][W + 2];
        long[][] visited = new long[H + 2][W + 2];

        for (long[] a: A) Arrays.fill(a, 1L << 40);
        for (int i = 1; i <= H; i++) for (int j = 1; j <= W; j++) {
            A[i][j] = sc.nextInt();
            visited[i][j] = 1L << 60;
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(1, 1, 0));
        visited[1][1] = 0;

        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            Pair cur = q.remove();
            debug(cur.x, cur.y, cur.c);

            if (cur.y == H && cur.x == W) {
                System.out.println(cur.c);
                break;
            }

            for (int i = 0; i < 4; i ++) {
                long cost = (2 * (Math.abs(1 - cur.x - dx[i]) + Math.abs(1 - cur.y - dy[i]) - 1) + 1) * A[cur.y + dy[i]][cur.x + dx[i]];
                if (visited[cur.y + dy[i]][cur.x + dx[i]] > cur.c + cost) {
                    visited[cur.y + dy[i]][cur.x + dx[i]] = cur.c + cost;
                    q.add(new Pair(cur.x + dx[i], cur.y + dy[i], cur.c + cost));
                }
            }
        }

    }

    class Pair implements Comparable<Pair> {
        int x, y;
        long c;
        Pair(int x, int y, long c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(c, o.c);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
