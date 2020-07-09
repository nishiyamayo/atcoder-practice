package abc172;

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

    Combination comb;
    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int N = sc.nextInt(), M = sc.nextInt();
        comb = new Combination(M + 10, MOD);

        long sob = 0;
        int m = M - N + 1, n = 1;
        for (int i = 0; i <= M; i++) {
            long tmp = comb.nck(m, n) * comb.nck(n, n);
        }

        out.flush();
    }

    long solve(int m, int n, long p) {
        if (n == 0) return p;
        if (m == 1 && n == 1) return 0;
        return 0;
    }

    long f(int m, int n, long sob) {
        if (n == 0) return 1;
        if (m == n && n == 1) return 0;
        return comb.nck(m, n - 1);
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
        new E().run();
    }
}