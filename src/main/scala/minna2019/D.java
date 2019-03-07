package minna2019;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    void run() {

        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int[] A = new int[l];
        for (int i = 0; i < l; i++) {
            A[i] = sc.nextInt();
        }

        // 0:<D, 1:D<=S, 2:S<=T, 3:T<=U, 4:U>
        long[][] dp = new long[l][5];
        dp[0][0] = A[0];
        dp[0][1] = add(1, A[0]);
        dp[0][2] = add(2, A[0]);
        dp[0][3] = add(3, A[0]);
        dp[0][4] = add(4, A[0]);
//        debug(dp[0]);

        for (int i = 1; i < l; i++) {
            dp[i][0] = dp[i - 1][0] + add(0, A[i]);
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][1]) + add(1, A[i]);
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + add(2, A[i]);
            dp[i][3] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i - 1][3]) + add(3, A[i]);
            dp[i][4] = min(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2], dp[i - 1][3], dp[i - 1][4]) + add(4, A[i]);
//            debug(dp[i]);
        }
        long ans = 1L << 50;
        for (int i = 0; i < 5; i++) {
            ans = Math.min(dp[l - 1][i], ans);
        }

        System.out.println(ans);
    }

    long min(long... vals) {
        return Arrays.stream(vals)
                .min()
                .getAsLong();
    }

    long add(int mode, int a) {
        switch (mode) {
            case 0:
            case 4:
                return a;
            case 1:
            case 3:
                if (a == 0) {
                    return 2;
                }
                return a % 2 == 0 ? 0 : 1;
            case 2:
                return a % 2 == 1 ? 0 : 1;
        }
        throw new RuntimeException("mode error");
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
