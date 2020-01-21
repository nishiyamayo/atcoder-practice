package abc149;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class F {

    Edge[] G;
    int[] len;
    int N, M;
    int[] as;

    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        as = new int[N];
        for (int i = 0; i < N; i++) {
            as[i] = sc.nextInt();
        }

        G = new Edge[N];
        for (int i = 0; i < N; i++) G[i] = new Edge();

        for (int i = 1; i < N; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            G[a].add(b);
            G[b].add(a);
        }
    }

    // white
    long[] solve(int cur, int past) {
        long ex = 0, cnt = 0;

        for (int next : G[cur]) {
            if (next == past) continue;
            long[] ret = solve(next, cur);
            ex += ret[0];
            cnt += ret[1];
        }

        return new long[]{ex, cnt + 1};
    }

    class Edge extends ArrayList<Integer> {
    }

    class Combination {
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
        new F().run();
    }
}