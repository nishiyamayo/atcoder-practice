package abc147;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] as = new long[n];
        int[] bc = new int[60];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextLong();
            for (int j = 0; j < 60; j++) {
                if (((as[i] >> j) & 1) == 1) {
                    bc[j]++;
                }
            }
        }

        long MOD = (long)1e9 + 7;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 60; j++) {
                if (((as[i] >> j) & 1) == 0) {
                    ans = (ans + (1L << j) % MOD * (bc[j])) % MOD;
                } else {
                    ans = (ans + (1L << j) % MOD * (n - bc[j])) % MOD;
                }
            }
        }
        long div = MOD / 2 + 1;
        System.out.println(ans * div % MOD);

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
