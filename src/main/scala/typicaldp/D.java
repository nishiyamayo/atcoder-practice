package typicaldp;

import java.util.*;


public class D {

    double EPS = 1e-12;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long d = sc.nextLong();
        int cnt2 = 0, cnt3 = 0, cnt5 = 0;

        while (d > 1 && d % 2 == 0) {
            d /= 2;
            cnt2++;
        }

        while (d > 1 && d % 3 == 0) {
            d /= 3;
            cnt3++;
        }

        while (d > 1 && d % 5 == 0) {
            d /= 5;
            cnt5++;
        }

        if (d != 1) {
            System.out.println(0.0);
            return;
        }

        double dp[][][][] = new double[2][cnt2 + 1][cnt3 + 1][cnt5 + 1];
        int idx = 0;

        dp[0][0][0][0] = 1.0;
        for (int i = 1; i <= n; i++) {
            idx = 1 - idx;
            for (double[][] a: dp[idx]) for (double[] b: a) Arrays.fill(b, 0);

            for (int x = 0; x <= cnt2; x++) {
                for (int y = 0; y <= cnt3; y++) {
                    for (int z = 0; z <= cnt5; z++) {
                        dp[idx][x][y][z] += dp[1 - idx][x][y][z] / 6;           // 1が出た場合
                        dp[idx][Math.min(x + 1, cnt2)][y][z] += dp[1 - idx][x][y][z] / 6;       // 2が出た場合
                        dp[idx][x][Math.min(y + 1, cnt3)][z] += dp[1 - idx][x][y][z] / 6;       // 3
                        dp[idx][Math.min(x + 2, cnt2)][y][z] += dp[1 - idx][x][y][z] / 6;       // 4
                        dp[idx][x][y][Math.min(z + 1, cnt5)] += dp[1 - idx][x][y][z] / 6;       // 5
                        dp[idx][Math.min(x + 1, cnt2)][Math.min(y + 1, cnt3)][z] += dp[1 - idx][x][y][z] / 6;   // 6
                    }
                }
            }
        }
        double ans = dp[idx][cnt2][cnt3][cnt5];
        System.out.printf("%.10f", ans);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
