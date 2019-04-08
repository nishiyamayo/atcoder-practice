package gcj2019.qualification;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class C {
    Scanner sc = new Scanner(System.in);
    ArrayList<BigInteger> primes;

    void run() {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    void solve(int T) {
        BigInteger N = new BigInteger(sc.next());
        int l = sc.nextInt();

        BigInteger[] cs = new BigInteger[l];
        for (int i = 0; i < l; i++) {
            cs[i] = new BigInteger(sc.next());
        }


        BigInteger st = cs[0];

        BigInteger cur = pollardsRho(st);
        primes.add(cur);

        for (int i = 0; i < l; i++) {
            BigInteger next = cs[i];
        }

        System.out.println(String.format("Case #%d: %s", T, "answer"));
    }

    TreeSet<BigInteger> exec(BigInteger st, BigInteger[] cs) {
        TreeSet<BigInteger> primes = new TreeSet<>();
        primes.add(st);
        BigInteger cur = st;
        for (BigInteger c: cs) {
            cur = c.divide(cur);
            primes.add(cur);
        }
        return primes;
    }

    BigInteger pollardsRho(BigInteger n) {
        byte[] x = new byte[500], y = new byte[500];
        XorShift r = new XorShift();

        while (true) {
            toByte(BigInteger.valueOf(2), x);
            toByte(BigInteger.valueOf(2), y);

            while (true) {
                r.nextBytes(x);
                r.nextBytes(y);
                r.nextBytes(y);
                BigInteger sub = new BigInteger(x).subtract(new BigInteger(y)).abs().divideAndRemainder(n)[1];
                BigInteger d = gcd(n, sub);
                if (d.equals(n)) {
                    break;
                }
                if (!d.equals(BigInteger.ONE)) {
                    return d;
                }
            }
        }

    }

    BigInteger gcd(BigInteger x, BigInteger y) {
        if (y == BigInteger.ZERO) {
            return x;
        }
        return gcd(y, x.divide(y));
    }

    void toByte(BigInteger bi, byte[] x) {
        byte[] tmp = bi.toByteArray();
        Arrays.fill(x, (byte) 0);
        System.arraycopy(tmp, 0, x, 0, tmp.length);
    }

    class XorShift {
        long[] seed;

        public XorShift()
        {
            long l = System.currentTimeMillis();
            seed = new long[]{l, l, l, l};
            for(long i = System.nanoTime() % 1000; i != 0; i--)
            {
                next();
            }
        }

        public long next()
        {
            long t = seed[0] ^ (seed[0] << 11);
            seed[0] = seed[1];
            seed[1] = seed[2];
            seed[2] = seed[3];
            seed[3] = (seed[3] ^ (seed[3] >> 19)) ^ (t ^ (t >> 8));
            return seed[3];
        }

        public long nextLong()
        {
            return this.next();
        }

        public void nextBytes(byte[] b)
        {
            long tmp = nextLong();
            int count = 0;
            for(int i = 0; i < b.length; i++)
            {
                if(count == 8)
                {
                    count = 0;
                    tmp = nextLong();
                }
                b[i] = (byte)(tmp >>> (count << 3));
                count += 1;
            }
        }
    }

    public static void main(String[] args) {
        new A().run();
    }

}
