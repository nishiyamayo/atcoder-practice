package abc007;

import abc005.D;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);

        int Y = sc.nextInt(), X = sc.nextInt();
        int sy = sc.nextInt(), sx = sc.nextInt();
        int gy = sc.nextInt(), gx = sc.nextInt();

        boolean[][] board = new boolean[Y + 2][X + 2];
        for (int i = 0; i < Y; i++) {
            board[i][0] = board[i][X - 1] = true;
        }

        Arrays.fill(board[0], true);
        Arrays.fill(board[Y - 1], true);


        for (int y = 1; y <= Y; y++) {
            String l = sc.next();
            for (int x = 1; x <= X; x++) {
                board[y][x] = l.charAt(x - 1) == '#';
            }
        }

        PriorityQueue<P> q = new PriorityQueue<>();
        q.add(new P(sx, sy, 0));
        board[sy][sx] = true;

        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            P cur = q.remove();
//            debug(cur.x, cur.y);

            if (cur.x == gx && cur.y == gy) {
                System.out.println(cur.c);
                return;
            }

            for (int i = 0; i < 4; i++) if (!board[cur.y + dy[i]][cur.x + dx[i]]) {
                board[cur.y + dy[i]][cur.x + dx[i]] = true;
                q.add(new P(cur.x + dx[i], cur.y + dy[i], cur.c + 1));
            }
        }
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
        new C().run();
    }
}
