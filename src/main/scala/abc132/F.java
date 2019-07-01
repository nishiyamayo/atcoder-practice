package abc132;

import java.util.*;

public class F {

    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        ArrayList<Integer> units = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            units.add(i);
        }

        ArrayList<Integer> unitsRev = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n / i != i) {
                unitsRev.add(n / i);
            }
        }

        Collections.reverse(unitsRev);
        units.addAll(unitsRev);

        int size = units.size();
        count.add(1);
        for (int i = 1; i < size; i++) {
            count.add(units.get(i) - units.get(i - 1));
        }

        long[][] dp = new long[2][size];
        int x = 0;
        dp[0][0] = 1;

//        debug(count);
//        debug(units);
//        debug(dp[x]);

        for (int i = 0; i < k; i++) {
            x = 1 - x;

            dp[x][size - 1] = dp[1 - x][0];
            for (int j = size - 2; j >= 0; j--) {
                dp[x][j] = (dp[x][j + 1] + dp[1 - x][size - j - 1]) % MOD;
            }
            for (int j = 0; j < size; j++) dp[x][j] = (dp[x][j] * count.get(j)) % MOD;
//            debug(dp[x]);
        }
        long ans = 0;
        for (int i = 0; i < size; i++) ans = (ans + dp[x][i]) % MOD;
        System.out.println(ans);
    }

    static void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
