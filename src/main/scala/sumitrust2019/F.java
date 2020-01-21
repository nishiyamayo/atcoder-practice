package sumitrust2019;

import java.util.Arrays;
import java.util.Scanner;

public class F {
    long t1, t2, a1, a2, b1, b2;
    void run() {
        Scanner sc = new Scanner(System.in);

        t1 = sc.nextLong();
        t2 = sc.nextLong();
        a1 = sc.nextLong();
        a2 = sc.nextLong();
        b1 = sc.nextLong();
        b2 = sc.nextLong();

        if (t1 * a1 + t2 * a2 == t1 * b1 + t2 * b2) {
            System.out.println("infinity");
            return;
        }

        if (t1 * a1 < t1 * b1 && t1 * a1 + t2 * a2 < t1 * b1 + t2 * b2) {
            System.out.println(0);
            return;
        }

        if (t1 * b1 < t1 * a1 && t1 * b1 + t2 * b2 < t1 * a1 + t2 * a2) {
            System.out.println(0);
            return;
        }

        long d = Math.abs(t1 * a1 + t2 * a2 - t1 * b1 - t2 * b2);
        debug(d, t1 * a1, t1 * b1, t1 * a1 + t2 * a2, t1 * b1 + t2 * b2);
        long d2 = Math.abs(t2 * a2 - t2 * b2);
        long d1 = Math.abs(t1 * a1 - t1 * b1);
        debug(d, d1, d2, t1 * a1, t1 * b1, t1 * a1 + t2 * a2, t1 * b1 + t2 * b2);


        long cnt = 2 * (d1 / d) + 1;

        if (d1 % d == 0) cnt--;

        System.out.println(cnt);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }

}
