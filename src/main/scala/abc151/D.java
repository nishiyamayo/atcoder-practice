package abc151;

import abc149.F;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class D {
    int H, W;
    boolean[][] map;
    void run() {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        map = new boolean[H + 2][W + 2];
        for (int h = 1; h <= H; h++) {
            String l = sc.next();
            for (int w = 1; w <= W; w++) {
                map[h][w] = l.charAt(w - 1) == '.';
            }
        }

        int ans = 0;
        for (int h = 1; h <= H; h++) for (int w = 1; w <= W; w++) {
            if (!map[h][w]) continue;
            ans = Math.max(ans, dijkstra(w, h));
        }
        System.out.println(ans);
    }
    int[] dx = {-1,0,1,0}, dy = {0, -1, 0, 1};
    int dijkstra(int sx, int sy) {
        boolean[][] visited = new boolean[H + 2][W + 2];
        LinkedList<Node> q = new LinkedList<>();
        visited[sy][sx] = true;
        q.addLast(new Node(sx, sy, 0));

        int ret = 0;
        while (!q.isEmpty()) {
            Node cur = q.removeFirst();
            ret = Math.max(ret, cur.c);

            for (int i = 0; i < 4; i++) {
                if (!map[cur.y + dy[i]][cur.x + dx[i]] || visited[cur.y + dy[i]][cur.x + dx[i]]) {
                    continue;
                }
                visited[cur.y + dy[i]][cur.x + dx[i]] = true;
                q.addLast(new Node(cur.x + dx[i], cur.y + dy[i], cur.c + 1));
            }
        }
        return ret;
    }

    class Node {
        int x, y, c;
        Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
