package diverta2019;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = 0;
        if (n == 1) {
            System.out.println(0);
            return;
        }
        for (long i = 1; i * i <= n; i++) {
            if ((n - i) % i == 0) {
                long x = ((n - i) / i);
                if (n / x == n % x) ans += x;
            }
        }

        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
