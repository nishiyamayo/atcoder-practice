package abc125;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        long[] gl = new long[n], gr = new long[n];

        gl[0] = a[0]; gr[0] = a[n - 1];
        for (int i = 1; i < n; i++) {
            gl[i] = gcd(gl[i - 1], a[i]);
            gr[i] = gcd(gr[i - 1], a[n - i - 1]);
        }
        debug(gl);
        debug(gr);
        long ans = Math.max(gl[n - 2], gr[n - 2]);
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, gcd(gl[i - 1], gr[n - i - 2]));
        }
        System.out.println(ans);
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
