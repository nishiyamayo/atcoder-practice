package agc033;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {

    int H, W;
    int[][] b;
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    int INF = 1 << 28;

    void run() {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        b = new int[H + 2][W + 2];
        PriorityQueue<P> q = new PriorityQueue<>();

        for (int i = 1; i <= H; i++) {
            String s = sc.next();
            for (int j = 1; j <= W; j++) {
                if (s.charAt(j - 1) == '#') {
                    b[i][j] = 0;
                    q.add(new P(j, i, 0));
                } else {
                    b[i][j] = INF;
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            P cur = q.remove();
            if (b[cur.y][cur.x] != cur.c) continue;
            ans = Math.max(ans, cur.c);
            for (int i = 0; i < 4; i++) if (b[cur.y + dy[i]][cur.x + dx[i]] > cur.c + 1) {
                q.add(new P(cur.x + dx[i], cur.y + dy[i], cur.c + 1));
                b[cur.y + dy[i]][cur.x + dx[i]] = cur.c + 1;
            }
        }
//        debug(b);
        System.out.println(ans);
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

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
