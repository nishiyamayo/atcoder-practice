package agc031;

import java.util.*;

public class B {

    int n;
    int[] a;
    long MOD = (long)1e9 + 7;

    ArrayList<Integer>[] ps;
    int[] cnt, p;

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
        ps = new ArrayList[2 * 100000 + 1];
        cnt = new int[2 * 100000 + 1];
        p = new int[2 * 100000 + 1];

        for (int i = 0; i < 2 * 100000 + 1; i++) ps[i] = new ArrayList<>();

        int idx = 0;
        for (int v: as) {
            a[idx++] = v;
        }

        for (int i = 1; i <= n; i++) {
            ps[a[i]].add(i);
            cnt[a[i]]++;
        }

//        debug(a);

        LinkedList<Integer> dum = new LinkedList<>();
        dum.addLast(0);

        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i]) % MOD;
            p[a[i]]++;
            for (int j = p[a[i]]; j < cnt[a[i]]; j++) {
                dp[ps[a[i]].get(j) + 1] = (dp[i] + dp[ps[a[i]].get(j) + 1]) % MOD;
            }

//            debug(dp);
        }
        System.out.println(dp[n]);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
