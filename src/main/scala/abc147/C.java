package abc147;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    int n;
    int[][] as;
    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        as = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            as[i][1] |= 1 << i;
            for (int j = 0; j < a; j++) {
                int x = sc.nextInt() - 1, y = sc.nextInt();
                as[i][y] |= 1 << x;
            }
        }
        debug(as);

        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (ok(i)) ans = Math.max(ans, Integer.bitCount(i));
        }

        System.out.println(ans);
    }

    boolean ok(int x) {
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (((x >> i) & 1) == 1) {
                a |= as[i][1];
                b |= as[i][0];
            }
        }
        debug(Integer.toBinaryString(x), Integer.toBinaryString(a), Integer.toBinaryString(b));
        debug(a ^ x, b & x);
        if ((a ^ x) > 0) return false;
        if ((b & x) > 0) return false;
        return true;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }

}
