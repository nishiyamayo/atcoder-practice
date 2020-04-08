package abc160;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public F() {
        this(System.in, System.out);
    }

    public F(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int n;
    Edge[] es;
    Combination comb;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        es = new Edge[n];
        comb = new Combination(n + 10, MOD);
        for (int i = 0; i < n; i++) {
            es[i] = new Edge();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            es[a].add(b);
            es[b].add(a);
        }

        out.flush();
    }

    Pair dfs(int par, int cur) {

        Pair ret = new Pair(1, 1);
        for (int next : es[cur]) {
            Pair x = dfs(cur, next);
            ret.f = ret.f * x.f % MOD;

        }
        return ret;
    }

    class Pair {
        long f, s;
        Pair(long f, long s) {
            this.f = f;
            this.s = s;
        }
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


    class Edge extends ArrayList<Integer> {};

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}