package abc169;

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
        long n = sc.nextLong();

        PriorityQueue<P> q = new PriorityQueue<>();
        ArrayList<Integer> primes = primes();
        for (int p : primes) {
            q.add(new P(p, p));
        }

        if (isPrime(n)) {
            out.println(1);
        } else {
            int cnt = 0;
            while (!q.isEmpty()) {
                P c = q.remove();
                if (n % c.c == 0) {
                    n /= c.c;
                    q.add(new P(c.p, c.c * c.p));
                    cnt++;
                }
            }
            for (int p : primes) {
                while (n % p == 0) n /= p;
            }
            if (isPrime(n)) cnt++;
            out.println(cnt);
        }

        out.flush();
    }

    boolean isPrime(long x) {
        if (x == 1) return false;
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    int max = 3000000;
    ArrayList<Integer> primes() {
        boolean[] ps = new boolean[max + 1];
        ps[0] = ps[1] = true;

        for (int i = 2; i <= max; i++) {
            if (!ps[i]) {
                for (int j = 2 * i; j <= max; j += i) {
                    ps[j] = true;
                }
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            if (!ps[i]) {
                ret.add(i);
            }
        }
        return ret;
    }

    class P implements Comparable<P> {
        long p, c;
        P(long p, long c) {
            this.p = p;
            this.c = c;
        }

        @Override
        public int compareTo(P o) {
            return Long.compare(c, o.c);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}