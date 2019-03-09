package agc003;

import java.util.*;

public class D {

    List<Long> primes = new ArrayList<>();
    int max = (int)1e5;
    boolean[] prime;

    void run() {
        Scanner sc = new Scanner(System.in);

        Map<Long, Integer> norms = new HashMap<>();
        Map<Long, Long> pairs = new HashMap<>();

        prime();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long s = sc.nextLong();
            long norm = norm(s);
            norms.put(norm, norms.getOrDefault(norm, 0) + 1);
            long pair = pair(norm);
            pairs.put(norm, pair);
        }

//        debug(norms);
//        debug(pairs);

        int ans = 0;
        Set<Long> used = new HashSet<>();
        for (Map.Entry<Long, Integer> entry: norms.entrySet()) {
            if (used.contains(entry.getKey())) continue;
            if (entry.getKey() == 1L) {
                ans += 1;
            } else {
                int pc = norms.getOrDefault(pairs.get(entry.getKey()), 0);
                ans += Math.max(pc, entry.getValue());
            }
            used.add(entry.getKey());
            used.add(pairs.get(entry.getKey()));
//            debug(entry, ans);
        }

        System.out.println(ans);
    }

    long norm(long x) {
        for (long p: primes) {
            if (p * p * p > x) {
                break;
            }
            long c = p * p * p;
            while (x % c == 0) x /= c;
        }
        return x;
    }

    long pair(long x) {
        long ret = 1;
        for (long p: primes) {
            if (x % p == 0) {
                ret *= x % (p * p) == 0 ? p : p * p;
            }
        }

        if (ret == 1) {
            ret *= x * x;
        }

        return ret;
    }

    void prime() {
        prime = new boolean[max + 1];

        for (int i = 2; i <= max; i++) if (!prime[i]) {
            for (int j = 2 * i; j <= max; j += i) prime[j] = true;
        }

        for (int i = 2; i<= max; i++) if (!prime[i]) {
            primes.add((long)i);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
