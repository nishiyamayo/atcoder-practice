package abc145;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int x = sc.nextInt(), y = sc.nextInt();

        if ((x + y) % 3 != 0) {
            out.println(0);
            out.flush();
            return;
        }

        int n = (2 * y - x) / 3;
        int m = (2 * x - y) / 3;
        if (n < 0 || m < 0) {
            out.println(0);
            out.flush();
            return;
        }

        Combination comb = new Combination(n + m + 10, MOD);
        out.println(comb.nck(n + m, m));
        out.flush();
    }

    public class Combination {
        int n;
        long mod;
        long[] facts;

        public Combination(int n, long mod) {
            this.n = n;
            this.mod = mod;
            facts = new long[n];
            facts[0] = 1;
            for (int i = 1; i < n; i++) {
                facts[i] = facts[i - 1] * i % mod;
            }
        }

        long modpow(long a, long b) {
            if (b == 0) return 1;
            else if (b == 1) return a;

            long x = modpow(a, b / 2);
            return b % 2 == 0 ? x * x % mod : x * (x * a % mod) % mod;
        }

        long inv(long n) {
            return modpow(n, mod - 2);
        }

        public long nck(int n, int k) {
            return n < k ? 0 : facts[n] * (inv(facts[n - k]) * inv(facts[k]) % mod) % mod;
        }
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}