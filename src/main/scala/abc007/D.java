package abc007;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        String a = String.format("%020d", sc.nextLong() - 1), b = String.format("%020d", sc.nextLong());

        System.out.println(count(b) - count(a));
    }

    int[] dx = {0, 1, 2, 3, 4, 4, 5, 6, 7, 8};
    long count(String X) {

        long[] dp1 = new long[20], dp2 = new long[20], dp3 = new long[20], dp4 = new long[20];

        // max ng
        dp1[0] = 0;
        // max ok
        dp2[0] = 1;
        // not max ng
        dp3[0] = 0;
        // not max ok;
        dp4[0] = 0;

        for (int i = 1; i <= 19; i++) {
            int x = X.charAt(i) - '0';
            dp1[i] = dp1[i - 1] == 1 || x == 4 || x == 9 ? 1 : 0;
            dp2[i] = dp2[i - 1] == 0 || x == 4 || x == 9 ? 0 : 1;
            dp3[i] = dp1[i - 1] * x + dp2[i - 1] * (x >= 5 ? 1 : 0) + dp3[i - 1] * 10 + dp4[i - 1] * 2;
            dp4[i] = dp2[i - 1] * dx[x] + dp4[i - 1] * 8;
            debug(dp1[i], dp2[i], dp3[i], dp4[i]);
        }
        debug(X, dp1, dp2);
        return dp1[19] + dp3[19];
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
