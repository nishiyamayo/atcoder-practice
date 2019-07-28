package agc036;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    long W = (long)1e9;

    void run() {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();

    }

    long x, y, z;
    void solve() {

    }

    boolean ok(long tar) {
        long ret = 0;
        long xy = Math.abs(x - y);
        ret -= W * xy;
        ret += W * W - xy * z;
        return ret >= tar;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

}
