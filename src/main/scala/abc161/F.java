package abc161;

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
        long n = sc.nextLong();

        long cnt = factors(n - 1).size() - 1;
//        debug(factors(n - 1), cnt);

        HashSet<Long> facts = factors(n);

        for (long i : facts) {
            if (i == 1) continue;
            long t = n;
            while (t % i == 0) t /= i;
//            debug(i, t, t % i);
            if (t % i == 1) cnt++;
        }

        out.println(cnt);

        out.flush();
    }

    HashSet<Long> factors(long n) {
        HashSet<Long> facts = new HashSet<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                facts.add(i);
                facts.add(n / i);
            }
        }
        return facts;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}