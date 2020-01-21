package abc152;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E {
    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] as = new long[n];
        for (int i = 0; i < n; i++) as[i] = sc.nextInt();

        long[] facts = new long[1000000 + 1];
        for (int i = 0; i < n; i++) {
            for (long j = 2; j * j <= as[i]; j++) {
                long a = as[i];
                if (a % j != 0) continue;
                long ij = a / j;
                int c1 = 0, c2 = 0;
                while (a % j == 0) {
                    c1++;
                    a /= j;
                }
                while (a % ij == 0) {
                    c2++;
                    a /= ij;
                }
                facts[(int)j] = Math.max(facts[(int)j], c1);
                facts[(int)ij] = Math.max(facts[(int)ij], c2);
            }
        }

        long tar = 1;
        for (int i = 2; i <= 1000000; i++) {

        }

        System.out.println();
    }

    BigInteger lcm(BigInteger a, BigInteger b) {
//        debug(a, b, gcd(a, b));
        return a.divide(gcd(a, b)).multiply(b);
    }

    BigInteger gcd(BigInteger a, BigInteger b) {
        if (BigInteger.ZERO.equals(b)) return a;
        return gcd(b, a.divideAndRemainder(b)[1]);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
