package iroha2019day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class K {

    long MOD = (long)1e9 + 7;

    void run() {

        long[] pow = new long[15];
        pow[0] = 1;
        for (int i = 1; i < 15; i++) pow[i] = pow[i - 1] * 10;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m = new int[n];
        long[][] es = new long[n][];
        long[] pows = new long[n];
        pows[0] = 1;
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextInt();
            es[i] = new long[m[i]];
            for (int j = 0; j < m[i]; j++) {
                es[i][j] = sc.nextInt();
            }
            if (i != 0) {
                pows[i] = (pows[i - 1] * m[i - 1]) % MOD;
            }
        }

        long ans = 0;
        long p = 1;

//        debug(pow, pows);

        for (n--; n >= 0; n--) {
            long sum = 0;
            long pp = 0;
            for (int i = 0; i < m[n]; i++) {
                sum = (sum + es[n][i]) % MOD;
                pp = (pp + pow[("" + es[n][i]).length()]) % MOD;
            }
            long ei = ((sum * p) % MOD) * pows[n] % MOD;
            ans = (ans + ei) % MOD;
//            debug(es[n], ans, p);
            p = (p * pp) % MOD;
        }

        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new K().run();
    }
}
