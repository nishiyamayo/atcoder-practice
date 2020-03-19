package abc151;

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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        long ans = 0;
        Combination comb = new Combination(n, MOD);

        for (int i = 0; i < n; i++) {
            ans = (ans + 1L * (MOD + a[n - i - 1]) % MOD * comb.nck(n - i - 1, k - 1) % MOD) % MOD;
            ans = (ans - 1L * (MOD + a[i]) % MOD * comb.nck(n - i - 1, k - 1) % MOD + MOD) % MOD;
        }

        out.println(ans);

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
        new E().run();
    }
}