package abc132;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();
        Combination comb = new Combination(n + 1, MOD);

        for (int i = 1; i <= k; i++) {
            System.out.println(comb.nck(n - k + 1, i) * comb.nck(k - 1, i - 1) % MOD);
        }
    }

    static void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

    static class Combination {
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
            if (n < k) return 0;
            return facts[n] * (inv(facts[n - k]) * inv(facts[k]) % mod) % mod;
        }
    }
}
