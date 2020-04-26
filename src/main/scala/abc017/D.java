package abc017;

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
        TreeSet<Integer> s = new TreeSet<>();
        int n = sc.nextInt(), m = sc.nextInt();
        int[] f = new int[n];
        long[] pow = new long[n + 1];
        pow[0] = 1;
        for (int i = 0; i < n; i++) {
            f[i] = sc.nextInt();
            pow[i + 1] = pow[i] * 2 % MOD;
        }

        long[] dp = new long[n + 1];
        long sum = 0;
        dp[0] = 1;
        s.add(-1);
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.contains(f[i])) {
                while (f[cur] != f[i]) {
                    sum = (sum - dp[cur] + MOD) % MOD;
                    s.remove(f[cur++]);
                }
                sum = (sum - dp[cur++] + MOD) % MOD;
                sum = (sum + dp[i]) % MOD;
                dp[i + 1] = sum;
            } else {
                s.add(f[i]);
                sum = (sum + dp[i]) % MOD;
                dp[i + 1] = sum;
            }
//            debug(i, cur, dp[i + 1]);
        }

        out.println(dp[n]);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}