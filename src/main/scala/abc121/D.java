package abc121;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong();
        int len = 50;

        long ans = 0;
        for (int i = 0; i < len; i++) {
            long ab = f(a - 1, i);
            long bb = f(b, i);
            ans |= ((bb - ab) % 2) << i;
            debug(ab, bb);
        }
        debug(Integer.toBinaryString(435));
        System.out.println(ans);
    }

    // 0101...
    // 00110011...
    // 00001111...
    long f(long n, int b) {
        if (n < (1L << b)) return 0;
        long cnt = (n / (1L<<(b + 1))) << b;
        long r = n / (1L<<(b + 1));
        long tmp = n - r * (1L<<(b + 1));

        long add = tmp >= (1L<<b) ? tmp - (1L<<b) + 1 : 0;

        debug(n, tmp, b, cnt, r, add);
        return (cnt + add);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
