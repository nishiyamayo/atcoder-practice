package abc167;
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

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        String[] kk = new String[n];
        for (int i = 0; i < n; i++) {
            kk[i] = sc.next();
        }

        Pair[] ps = new Pair[n];
        for (int i = 0; i < n; i++) {
            int l = kk[i].length();
            int cl = 0, ml = 0, cr = 0, mr = 0;
            for (int j = 0; j < l; j++) {
                cl += kk[i].charAt(j) == '(' ? 1 : -1;
                ml = Math.min(ml, cl);
                cr += kk[i].charAt(l - j - 1) == ')' ? 1 : -1;
                mr = Math.min(mr, cr);
            }
            ps[i] = new Pair(-mr, -ml, kk[i]);
        }

        Arrays.sort(ps);
        debug(ps);

        int c = 0;
        boolean ok = true;
        for (Pair p : ps) {
            if (c - p.m < 0) {
                ok = false;
                break;
            }
            c -= p.m;
            c += p.p;
        }

        ok &= c == 0;
        out.println(ok ? "Yes" : "No");

        out.flush();
    }

    class Pair implements Comparable<Pair> {
        int p, m;
        String s;
        Pair(int p, int m, String s) {
            this.p = p;
            this.m = m;
            this.s = s;
        }

        @Override
        public int compareTo(Pair o) {
            if (p - m > 0 && o.p - o.m > 0) {
                return m - o.m;
            } else if (p - m > 0) {
                return -1;
            } else if (o.p - o.m > 0) {
                return 1;
            } else {
                return o.p - p;
            }
        }

        @Override
        public String toString() {
            return "(" + p + ", " + m + ")";
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
