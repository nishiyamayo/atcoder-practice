package iroha2019day3;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    void run() {

        L X = new L(1), Y = new L(1);
        debug(extGCD(61, -59, X, Y), X.l, Y.l);

        Scanner sc = new Scanner(System.in);
        int[] in = new int[26];
        for (int i = 0; i < 26; i++) {
            in[i] = sc.nextInt();
        }

        System.out.println(in[0] - in[1]);
        System.out.println(in[2] + in[3]);
        System.out.println(in[5] - in[4] > 0 ? in[5] - in[4] + 1 : 0);
        System.out.println((in[6] + in[7] + in[8]) / 3 + 1);

        String[] mins = {"", "a", "aa", "aaa", "aaai", "aaaji", "aabaji", "agabaji", "dagabji"};
        System.out.println(mins[in[9]]);

        // 61 * r1 - 59 * r2 = -1 を満たすr1,r2
        extGCD(61, 59, X, Y);
        long val1 = 61 * X.l + in[10];
        long val2 = 59 * Y.l + in[11];
        debug(val1, val2);
        for (int i = 1; i < in[12]; i++ ) {
            val1 *= in[10] - in[11];
        }

        long fab1 = val1;

        long fab2 = -1;
        int[] comps = {6, 28, 496, 8128, 33550336};
        for (int c: comps) if (Math.abs(fab1 - c) > in[13]) {
            fab2 = c;
            break;
        }

        System.out.println(Math.min(fab1, fab2));
        System.out.println(Math.max(fab1, fab2));

        long last = 1;
        for (int i = 5; i <= 8; i++)
            last = last * (in[i * 3 - 1] + in[i * 3] + in[i * 3 + 1]) % 9973;
        System.out.println(last);
    }

    long extGCD(long a, long b, L X, L Y) {
        if (b == 0) {
            X.l = 1L;
            Y.l = 0L;
            return a;
        }
        long d = extGCD(b, a % b, Y, X);
        Y.l -= a / b * X.l;
        return d;
    }

    class L {
        long l;
        L(long l) {
            this.l = l;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
