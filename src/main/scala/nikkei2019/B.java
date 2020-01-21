package nikkei2019;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    long MOD = 998244353L;
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ds = new int[n];
        int first = sc.nextInt();
        ds[first]++;
        for (int i = 1; i < n; i++) {
            ds[sc.nextInt()]++;
        }

            if (ds[0] != 1 || first != 0) {
            System.out.println(0);
            return;
        }
        long cnt = 1;

        for (int i = 1; i < n; i++) {
            cnt = (cnt * pow(ds[i - 1], ds[i])) % MOD;
            if (cnt < 0) cnt += MOD;
        }
        System.out.println(cnt);
    }

    long pow(long a, long p) {
        long x = 1;
        while (p > 0) {
            if ((p & 1) == 1) x = x * a % MOD;
            a = a * a % MOD;
            if (x < 0) x += MOD;
            if (a < 0) a += MOD;
            p >>= 1;
        }
        return x;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }

}
