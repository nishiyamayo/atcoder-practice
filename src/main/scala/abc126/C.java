package abc126;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();

        int[] pow = new int[28];
        pow[0] = 1;
        for (int i = 1; i < 28; i++) {
            pow[i] = pow[i - 1] * 2;
        }

        double ans = 0;
        int x = 0;
        for (;k > pow[x]; x++) {}

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (k <= i) {
                ans += 1.0;
            } else {
                int c = (k + i - 1) / i;
                int t = 0;
                for (; c > pow[t]; t++) {}
                ans += (1.0 / pow[t]);
//                debug(1.0 / pow[t]);
            }
        }
        System.out.println(ans / n);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
