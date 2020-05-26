package agc046;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class B {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public B() {
        this(System.in, System.out);
    }

    public B(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    int n;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        int[] ps = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            ps[i] = sc.nextInt();
        }
        int[][] b = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                b[i][j] = b[j][i] = b[n - i - 1][j] = b[j][n - i - 1] = i + 1;
            }
        }

//        for (int[] a : b) debug(a);

        int[] dx = {-1 ,0, 1, 0}, dy = {0, -1, 0, 1};
        long sum = 0;
        for (int i = 0; i < n * n; i++) {
            P c = from(ps[i]);
            visited[c.y][c.x] = true;
            sum += Math.max(0, --b[c.y][c.x]);
            b[c.y][c.x] = Math.max(0, b[c.y][c.x]);
            LinkedList<P> q = new LinkedList<>();
            q.addLast(c);

            while (!q.isEmpty()) {
                P cur = q.removeFirst();

                for (int j = 0; j < 4; j++) {
                    if (cur.x + dx[j] < 0 || cur.y + dy[j] < 0 || cur.x + dx[j] >= n || cur.y + dy[j] >= n)
                        continue;
                    if (visited[cur.y + dy[j]][cur.x + dx[j]] && b[cur.y + dy[j]][cur.x + dx[j]] > b[cur.y][cur.x]) {
                        q.addLast(new P(cur.x + dx[j], cur.y + dy[j]));
                        b[cur.y + dy[j]][cur.x + dx[j]] = b[cur.y][cur.x];
                    }
                    else if (b[cur.y + dy[j]][cur.x + dx[j]] > b[cur.y][cur.x] + 1) {
                        q.addLast(new P(cur.x + dx[j], cur.y + dy[j]));
                        b[cur.y + dy[j]][cur.x + dx[j]] = b[cur.y][cur.x] + 1;
                    }
                }
            }
//            debug(i, ps[i]);
//            for (int[] a : b) debug(a);

        }

        out.println(sum);

        out.flush();
    }

    P from(int v) {
        int x = (v - 1) / n;
        int y = (v - 1) % n;
        return new P(x, y);
    }

    class P {
        int x, y;
        P(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}