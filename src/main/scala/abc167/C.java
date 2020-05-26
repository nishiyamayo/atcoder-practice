package abc167;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class C {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public C() {
        this(System.in, System.out);
    }

    public C(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt(), x = sc.nextInt();
        int[][] as = new int[n][m];
        int[] cs = new int[n];

        for (int i = 0; i < n; i++) {
            cs[i] = sc.nextInt();
            for (int j = 0; j < m; j++) {
                as[i][j] = sc.nextInt();
            }
        }

        int ans = 1 << 28;
        for (int i = 0; i < 1 << n; i++) {
            int[] sums = new int[m];
            int cost = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) continue;
                cost += cs[j];
                for (int k = 0; k < m; k++) {
                    sums[k] += as[j][k];
                }
            }
            boolean ok = true;
            for (int j = 0; j < m; j++) {
                ok &= sums[j] >= x;
            }
            if (ok) ans = Math.min(ans, cost);
        }

        out.println(ans == 1 << 28 ? -1 : ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}