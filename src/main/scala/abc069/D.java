package abc069;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

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

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int H = sc.nextInt(), W = sc.nextInt();
        int n = sc.nextInt();
        int[] cs = new int[n];
        int[][] map = new int[H][W];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.nextInt();
        }

        int cur = 0;
        for (int h = 0; h < H; h++) {
            if (h % 2 == 0) {
                for (int w = 0; w < W; w++) {
                    map[h][w] = cur + 1;
                    cs[cur]--;
                    if (cs[cur] == 0) cur++;
                }
            } else {
                for (int w = W - 1; w >= 0; w--) {
                    map[h][w] = cur + 1;
                    cs[cur]--;
                    if (cs[cur] == 0) cur++;
                }
            }
        }

        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                out.print((w == 0 ? "" : " ") + map[h][w]);
            }
            out.println();
        }

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}