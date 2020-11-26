package abc184;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        double[][][] dp = new double[101][101][101];
        dp[a][b][c] = 1.0;

        LinkedList<Integer> q = new LinkedList<>();
        HashSet<Integer> used = new HashSet<>();

        double ans = 0;

        for (int A = a; A < 100; A++) {
            for (int B = b; B < 100; B++) {
                for (int C = c; C < 100; C++) {
                    if (A != 0) {
                        dp[A + 1][B][C] += dp[A][B][C] * A / (A + B + C);
                    }
                    if (B != 0) {
                        dp[A][B + 1][C] += dp[A][B][C] * B / (A + B + C);
                    }
                    if (C != 0) {
                        dp[A][B][C + 1] += dp[A][B][C] * C / (A + B + C);
                    }
//                    debug(dp[A][B][C], dp[A + 1][B][C], dp[A][B + 1][C], dp[A][B][C + 1]);
                }
            }
        }

        for (int f = 0; f < 100; f++) {
            for (int s = 0; s < 100; s++) {
                ans += 1.0 * (f + s + 100 - a - b - c) * dp[f][s][100]
                        + 1.0 * (f + s + 100 - a - b - c) * dp[f][100][s]
                        + 1.0 * (f + s + 100 - a - b - c) * dp[100][f][s];
            }
        }

        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
