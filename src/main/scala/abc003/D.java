package abc003;

import java.math.BigInteger;
import java.util.Scanner;

public class D {

    int R, C;
    int X, Y;
    int D, L;

    long MOD = (long)1e9 + 7;

    void run() {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        D = sc.nextInt();
        L = sc.nextInt();

        long ans = 0;

        if (X * Y == D + L) {
        }

    }

    long ncr(int n, int c) {
        BigInteger bi = BigInteger.ONE;
        for (int i = 0; i < c; i++) {
            bi = bi.multiply(BigInteger.valueOf(n - i));
        }
        for (int i = 1; i <= c; i++) {
            bi = bi.divide(BigInteger.valueOf(i));
        }
        return bi.divideAndRemainder(BigInteger.valueOf(MOD))[1].longValue();
    }

    public static void main(String[] args) {
        new D().run();
    }
}
