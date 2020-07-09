package abc037;

import java.io.*;

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

    void run() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(this.in));
        PrintWriter out = new PrintWriter(this.out);

        // write your
        String[] l = br.readLine().split(" ");
        int h = Integer.parseInt(l[0]), w = Integer.parseInt(l[1]);
        int[][] as = new int[h][w];
        P[] ps = new P[h * w];
        for (int i = 0; i < h; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                as[i][j] = Integer.parseInt(l[j]);
                ps[i * w + j] = new P(j, i, as[i][j]);
            }
        }

        Arrays.sort(ps);

        int[][] dp = new int[h][w];

        int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
        long ans = 0;
        for (P cur : ps) {
            ans += dp[cur.y][cur.x];
            if (ans > MOD) ans -= MOD;
            for (int i = 0; i < 4; i++) {
                if (cur.x + dx[i] < 0 || cur.x + dx[i] >= w || cur.y + dy[i] < 0 || cur.y + dy[i] >= h || as[cur.y][cur.x] >= as[cur.y + dy[i]][cur.x + dx[i]])
                    continue;
                dp[cur.y + dy[i]][cur.x + dx[i]] += dp[cur.y][cur.x] + 1;
                if (dp[cur.y + dy[i]][cur.x + dx[i]] > MOD)
                    dp[cur.y + dy[i]][cur.x + dx[i]] -= MOD;
            }
        }

        out.println((ans + w * h) % MOD);


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
        try {
            new D().run();
        } catch (IOException e) {

        }
    }
}