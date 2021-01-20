package abc188;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        long x = sc.nextLong(), y = sc.nextLong();

        out.println(solve(x, y));

        out.flush();
    }

    HashMap<Long, Long> memo = new HashMap<>();
    long solve(long x, long y) {
        if (x == y) return 0;
        if (memo.containsKey(y)) return memo.get(y);
        long ans = 1L << 60;

        if ((y & 1) == 1) {
            if (y > x) {
                ans = Math.min(ans, solve(x, (y - 1) / 2) + 2);
                ans = Math.min(ans, solve(x, (y + 1) / 2) + 2);
            }
            ans = Math.min(ans, Math.abs(y - x));
        } else {
            ans = Math.min(solve(x, y / 2) + 1, Math.abs(y - x));
        }
        debug(x, y, ans);
        memo.put(y, ans);
        return ans;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
