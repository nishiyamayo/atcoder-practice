package exawizards2019;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class D {

    long MOD = (long)1e9 + 7;
    long[][] npr;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        npr = new long[n + 1][n+1];
        npr[0][0] = 1;
        for (int i = 1; i <= n; i++) npr[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            npr[i][i] = i;
            for (int j = 1; j <= i; j++){
                npr[i][j] = (npr[i][j - 1] * (i - j + 1)) % MOD;
            }
        }
        TreeSet<Integer> remining = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            remining.add(sc.nextInt());
        }

        System.out.println(solve(x, x + 1, remining, 0));
    }

    long solve(long x, long y, TreeSet<Integer> remaining, int size) {
//        debug("start", x, y, remaining, size);
        TreeSet<Integer> next = new TreeSet<>();
        if (remaining.isEmpty()) {
//            debug("end", x, y, remaining, size, ((x % y)) * npr[size][size] % MOD);
            return ((x % y)) % MOD;
        }

        long ans = 0;

        int len = remaining.size() - 1;
        int s = len;
        for (int n: remaining) {
            ans += solve(x % y, n, next, size + s) * npr[len][s];
            ans %= MOD;
            next.add(n);
            s--;
        }
//        debug("end", x, y, remaining, size, ans);
        return ans;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
