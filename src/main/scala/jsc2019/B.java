package jsc2019;

import iroha2019day3.A;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] b = new int[n], c = new int[n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
            if (i < j && a[i] > a[j]) {
                b[j]++;
            }
            if (a[i] > a[j]) {
                c[j]++;
            }
        }


        long MOD = (long)(1e9) + 7;
        long INV2 = (MOD + 1) / 2;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = (cnt + k * b[i]) % MOD;
            long mult = k * c[i] % MOD * (k - 1) % MOD * INV2 % MOD;
            cnt = (cnt + mult) % MOD;
        }
        System.out.println(cnt);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
