package jsc2019;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        long MOD = (long) 1e9 + 7;
        long ans = 1;

        int toMatch = 0;
        for (int i = 0; i < 2 * n; i++) {
//            debug(ans, toMatch, s.charAt(i));
            if (toMatch == 0) {
                if (s.charAt(i) == 'B') {
                    toMatch++;
                } else {
                    System.out.println(0);
                    return;
                }
            } else {
                if (toMatch % 2 == 0) {
                    if (s.charAt(i) == 'B') {
                        toMatch++;
                    } else {
                        ans = ans * toMatch % MOD;
                        toMatch--;
                    }
                } else {
                    if (s.charAt(i) == 'B') {
                        ans = ans * toMatch % MOD;
                        toMatch--;
                    } else {
                        toMatch++;
                    }
                }
            }
        }
        if (toMatch != 0) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) % MOD;
        }
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
