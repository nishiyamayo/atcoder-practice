package abc168;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public E() {
        this(System.in, System.out);
    }

    public E(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        HashMap<Long, HashMap<Long, Integer>> map = new HashMap<>();
        long[] as = new long[n], bs = new long[n];
        long[] pow = new long[n + 1];
        pow[0] = 1;

        for (int i = 0; i < n; i++) {
            pow[i + 1] = pow[i] * 2 % MOD;
        }

        long ans = pow[n] - 1;
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong(), b = sc.nextLong();

        }
        out.println(ans);

        out.flush();
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}