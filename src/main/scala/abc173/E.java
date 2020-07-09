package abc173;

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
        ArrayList<Long> plus = new ArrayList<>();
        ArrayList<Long> minus = new ArrayList<>();
        ArrayList<Long> zero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long v = sc.nextInt();
            if (v > 0) {
                plus.add(v);
            } else if (v < 0) {
                minus.add(v);
            } else {
                zero.add(v);
            }
        }

        int curp = 0, curm = 0;
        int lp = plus.size(), lm = minus.size();

        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        if (zero.size() == 0) {
            if (k == n) {
                long ans = 1;
                for (long a : plus) {
                    ans *= a;
                    ans %= MOD;
                }
                for (long a : minus) {
                    ans *= Math.abs(a);
                    ans %= MOD;
                }
                if (lm % 2 == 1) {
                    ans *= MOD - 1;
                    ans %= MOD;
                }
                out.println(ans);
                out.flush();
                return;
            } else if (lp == 0) {
                long ans = 1;
                if (k % 2 == 1) {
                    ans *= MOD - 1;
                    Collections.sort(minus, Collections.reverseOrder());
                }

                for (int i = 0; i < k; i++) {
                    ans *= Math.abs(minus.get(i));
                    ans %= MOD;
                }

                out.println(ans);
                out.flush();
                return;
            }
        }

        long ans = 1;

        if (k % 2 == 1) {
            if (lp == 0) {
                out.println(0);
                out.flush();
                return;
            }
            ans *= plus.get(curp);
            ans %= MOD;
            curp++;
            k--;
        }

        while (k > 0) {
            if (curp + 1 < lp && curm + 1 < lm && plus.get(curp) * plus.get(curp + 1) > minus.get(curm) * minus.get(curm + 1)) {
                ans *= plus.get(curp) * plus.get(curp + 1) % MOD;
                ans %= MOD;
                curp += 2;
                k -= 2;
            } else if (curp + 1 < lp && curm + 1 < lm && plus.get(curp) * plus.get(curp + 1) <= minus.get(curm) * minus.get(curm + 1)) {
                ans *= minus.get(curm) * minus.get(curm + 1) % MOD;
                ans %= MOD;
                curm += 2;
                k -= 2;
            } else if (curp + 1 < lp) {
                ans *= plus.get(curp) * plus.get(curp + 1) % MOD;
                ans %= MOD;
                curp += 2;
                k -= 2;
            } else if (curm + 1 < lm) {
                ans *= minus.get(curm) * minus.get(curm + 1) % MOD;
                ans %= MOD;
                curm += 2;
                k -= 2;
            } else {
                out.println(0);
                out.flush();
                return;
            }
        }

        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}