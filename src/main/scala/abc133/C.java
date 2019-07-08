package abc133;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    long MOD = (long) 2019;

    void run() {
        Scanner sc = new Scanner(System.in);
        long L = sc.nextInt(), R = sc.nextInt();

        long l = L / 2019, r = R / 2019;
        long lr = L % 2019, rr = R % 2019;
        if (l < r) {
            System.out.println(0);
        } else {
            if (lr > rr) {
                long tmp = l;
                lr = rr;
                rr = tmp;
            }
            long min = 2018;
            for (long i = lr; i <= rr; i++) for (long j = i + 1; j <= rr; j++) {
                min = Math.min(min, i * j % 2019);
            }
            System.out.println(min);
        }
    }
    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
