package msolutions2019;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        long[] as = new long[n + 1];
        long[] bs = new long[n + 1];
        for (int i = 0; i < n; i++) {

        }
    }

    long modinv(long x) {
        long m = MOD - 2;
        long ret = x;
        while (m != 0) {
            if (m % 2 == 1) {
                ret = ret * x % MOD;
            }
            ret = ret * ret % MOD;
            m >>= 1;
        }
        return ret;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
