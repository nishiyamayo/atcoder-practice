package abc185;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;
    int n, m;
    int[] a;
    int[] b;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        n = sc.nextInt(); m = sc.nextInt();
        a = new int[n];
        b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        mem = new int[n][m][3];
        for (int[][] v : mem) for (int[] w : v) Arrays.fill(w, -1);
        out.println(solve(0, 0, 0));

        out.flush();
    }

    int[][][] mem;
    int solve(int i, int j, int t) {
        if (i == n || j == m) {
            if (t != 0) return 1 << 28;
            return n - i + m - j;
        }
        if (mem[i][j][t] >= 0) return mem[i][j][t];

        int ret = 1 << 28;

        if (t == 0) {
            // このiとjは使わない
            ret = Math.min(ret, solve(i + 1, j + 1, 0) + 1);

            // iもjも使う
            ret = Math.min(ret, solve(i + 1, j + 1, 0) + (a[i] == b[j] ? 0 : 1));

            // iを使うがjは将来使う
            ret = Math.min(ret, solve(i, j + 1, 1));

            // jを使うがiは将来使う
            ret = Math.min(ret, solve(i + 1, j, 2));
        } else if (t == 1) {
            // iは決定しているので、このjを使う
            {
                int s = solve(i + 1, j + 1, 0);
                int x = 1;
                int y = a[i] == b[j] ? 0 : 1;
                ret = Math.min(ret, s + x + y);
            }
            // このjを使わず、j+1移行を使う
            {
                int s = solve(i, j + 1, 1);
                int x = 1;
                ret = Math.min(ret, s + x);
            }
        } else {
            // jは決定しているので、このiを使う
            {
                int s = solve(i + 1, j + 1, 0);
                int x = 1;
                int y = a[i] == b[j] ? 0 : 1;
                ret = Math.min(ret, s + x + y);
            }
            // このjを使わず、j+1移行を使う
            {
                int s = solve(i + 1, j, 2);
                int x = 1;
                ret = Math.min(ret, s + x);
            }

        }

        return mem[i][j][t] = ret;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
