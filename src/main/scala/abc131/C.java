package abc131;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    long MOD = (long)1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong();
        long c = sc.nextInt(), d = sc.nextInt();
        long m = lcm(c, d);
        long cntc = b / c - (a - 1) / c;
        long cntd = b / d - (a - 1) / d;
        long cntcd = b / m - (a - 1) / m;
        debug(cntc, cntd, cntcd);
        System.out.println(b - a + 1 - (cntc + cntd - cntcd));
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
