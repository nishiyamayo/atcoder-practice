package abc182;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int h = sc.nextInt(), w = sc.nextInt(), n = sc.nextInt(), m = sc.nextInt();
        boolean[][] b1 = new boolean[h + 2][w + 2];
        boolean[][] b2 = new boolean[h + 2][w + 2];
        boolean[][] b3 = new boolean[h + 2][w + 2];
        boolean[][] b4 = new boolean[h + 2][w + 2];
        boolean[][] c = new boolean[h + 2][w + 2];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            b1[a][b] = b2[a][b] = b3[a][b] = b4[a][b] = true;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            c[a][b] = true;
        }

        for (int y = 1; y <= h; y++) {
            for (int x = 1; x <= w; x++) {
                if (c[y][x]) continue;
                b1[y][x] |= b1[y - 1][x];
                b2[y][x] |= b2[y][x - 1];
            }
        }
        for (int y = h; y >= 0; y--) {
            for (int x = w; x >= 0; x--) {
                if (c[y][x]) continue;
                b3[y][x] |= b3[y + 1][x];
                b4[y][x] |= b4[y][x + 1];
            }
        }

        int cnt = 0;
        for (int y = 1; y <= h; y++) {
            for (int x = 1; x <= w; x++) {
                if (b1[y][x] | b2[y][x] | b3[y][x] | b4[y][x])
                    cnt++;
            }
        }

        out.println(cnt);
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
