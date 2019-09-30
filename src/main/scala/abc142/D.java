package abc142;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class D {

    int MAX = 1000000;
    boolean[] primes;

    void run() {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong(), B = sc.nextLong();

        long x = gcd(A, B);

        HashSet<Long> y = new HashSet<>();

        for (long i = 1; i * i <= x; i++) if (x % i == 0){
            y.add(i);
            y.add(x / i);
        }
//        debug(y.size(), y);

        int ans = 0;
        for (long i : y) {
            if (isPrime(i)) ans++;
        }

        System.out.println(ans);
    }

    boolean isPrime(long y) {
        for (long i = 2; i * i <= y; i++) {
            if (y % i == 0) return false;
        }
        return true;
    }

    long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
