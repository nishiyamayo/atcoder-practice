package abc162;

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
        int n = sc.nextInt(), k = sc.nextInt();
        long[] cnts = new long[k + 1];
        long ans = 0;

        for (int i = k; i >= 1; i--) {
            int cnt = k / i;
            cnts[i] = modpow(cnt, n);
            for (int j = 2; i * j <= k; j++) {
                cnts[i] = (cnts[i] - cnts[i * j] + MOD) % MOD;
            }
            ans = (ans + i * cnts[i]) % MOD;
        }

        out.println(ans);
        out.flush();
    }

    long modpow(long a, long b) {
        if (b == 0) return 1;
        else if (b == 1) return a;

        long x = modpow(a, b / 2);
        return b % 2 == 0 ? x * x % MOD : x * (x * a % MOD) % MOD;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}