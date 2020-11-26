package abc184;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;
    int INF = 1 << 28;
    int H, W;
    int[][] d1;
    int[] d2;
    String[] b;
    Warp[] ws;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);
        H = sc.nextInt(); W = sc.nextInt();
        d1 = new int[H][W];
        d2 = new int[26];
        ws = new Warp[26];
        for (int i = 0; i < 26; i++) {
            ws[i] = new Warp();
        }

        for (int[] a: d1) Arrays.fill(a, INF);
        Arrays.fill(d2, INF);

        b = new String[H];
        int sx = -1, sy = -1;
        for (int i = 0; i < H; i++) {
            b[i] = sc.next();
            for (int j = 0; j < W; j++) {
                if (b[i].charAt(j) == 'S') {
                    sx = j;
                    sy = i;
                }
                if ('a' <= b[i].charAt(j) && b[i].charAt(j) <= 'z') {
                    ws[b[i].charAt(j) - 'a'].add(new Node(j, i, 0));
                }
            }
        }

        out.println(dijkstra(sx, sy));

        out.flush();
    }

    int dijkstra(int x, int y) {
        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(x, y, 0));
        d1[y][x] = 0;


        while (!q.isEmpty()) {
            Node cur = q.remove();
            if (cur.t == 1) {
//                debug(cur.t, cur.x, cur.y, b[cur.y].charAt(cur.x), cur.cost);
                if (d1[cur.y][cur.x] != cur.cost) continue;
                if (b[cur.y].charAt(cur.x) == 'G') return cur.cost;

                if ('a' <= b[cur.y].charAt(cur.x) && b[cur.y].charAt(cur.x) <= 'z') {
                    if (d2[b[cur.y].charAt(cur.x) - 'a'] > cur.cost) {
                        q.add(new Node(b[cur.y].charAt(cur.x) - 'a', cur.cost));
                        d2[b[cur.y].charAt(cur.x) - 'a'] = cur.cost;
                    }
//                    debug(d2);
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i], ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                    if (b[ny].charAt(nx) == '#') continue;
                    if (d1[ny][nx] > cur.cost + 1) {
                        q.add(new Node(nx, ny, cur.cost + 1));
                        d1[ny][nx] = cur.cost + 1;
                    }
                }
            } else {
//                debug(cur.t, cur.c, cur.cost);
                if (d2[cur.c] != cur.cost) continue;
                for (Node next : ws[cur.c]) {
                    if (d1[next.y][next.x] > cur.cost + 1) {
                        q.add(new Node(next.x, next.y, cur.cost + 1));
                        d1[next.y][next.x] = cur.cost + 1;
                    }
                }
            }
        }
        return -1;
    }

    class Warp extends ArrayList<Node> {}

    class Node implements Comparable<Node>{
        int t, c = -1;
        int x = -1, y = -1;
        int cost;
        Node(int x, int y, int cost) {
            this.t = 1;
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
        Node(int c, int cost) {
            this.t = 2;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
