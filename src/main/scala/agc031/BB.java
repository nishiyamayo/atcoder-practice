package agc031;

import java.util.*;

public class BB {

    int n;
    int[] a;
    long MOD = (long)1e9 + 7;

    Map<Integer, LinkedList<Integer>> i2ps = new HashMap<>();
    Map<Integer, Long> sum = new HashMap<>();

    void run() {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> as = new LinkedList<>();

        n = sc.nextInt();
        as.add(0);
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            if (as.getLast() != x) {
                as.addLast(x);
            }
        }
        n = as.size();
        a = new int[n + 1];
        int idx = 0;
        for (int v: as) {
            a[idx++] = v;
        }

        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> l = i2ps.getOrDefault(a[i], new LinkedList<>());
            l.add(i);
            i2ps.put(a[i], l);
        }

//        debug(a);

        LinkedList<Integer> dum = new LinkedList<>();
        dum.addLast(0);
        i2ps.put(0, new LinkedList<>(dum));

        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i]) % MOD;
            LinkedList<Integer> l = i2ps.get(a[i]);
            l.removeFirst();
            if (!l.isEmpty()) {
                int p = l.getFirst();
                sum.put(a[i], (sum.getOrDefault(a[i], 0L) + dp[i]) % MOD);
                dp[p + 1] = (sum.get(a[i]) + dp[p + 1]) % MOD;

            }
            i2ps.put(a[i], l);
//            debug(dp);
        }
        System.out.println(dp[n]);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new BB().run();
    }
}