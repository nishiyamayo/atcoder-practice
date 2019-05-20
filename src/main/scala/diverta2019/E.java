package diverta2019;

import java.util.Arrays;
import java.util.Scanner;

public class E {

    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            b[i] ^= b[i - 1] ^ a[i];
        }

        debug(a);
        debug(b);

        if (b[n] == 0) {
            long[] x = new long[2];

            int f = 0;
            x[0] = 1;

            for (int i = 1; i <= n; i++) {
                f = 1 - f;
                x[f] = (x[1 - f] + (b[f] == 0 ?  2 * x[1 - f] : 0)) % MOD;
                debug(x[f]);
            }
            System.out.println(x[f]);
        } else {
            long[] z = new long[2];
            long[] x = new long[2];

            int f = 0;
            z[0] = 1;

            for (int i = 1; i <= n; i++) {
                f = 1 - f;
                z[f] = (z[1 - f] + (b[f] == b[n] ? x[1 - f] : 0)) % MOD;
                x[f] = (x[1 - f] + (b[f] == 0 ? z[1 - f] : 0)) % MOD;
                debug(x[f], z[f]);
            }

            System.out.println(x[f]);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
