package abc118;

import java.util.*;
import java.util.stream.Collectors;

public class D {

    int[] needs = {0, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    Set<String> nums = new HashSet<>();
    int n, m, t, min;
    Set<Integer> use = new HashSet<>();

    void run() {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            use.add(sc.nextInt());
        }

        String[] dp = new String[n + 1];


        dp[0] = "";
        for (int i = 0; i <= n; i++) {
            if (dp[i] == null) {
                continue;
            }
            for (int u: use) if (i + needs[u] <= n) {
                String next = next(dp[i], u);
                if (dp[i + needs[u]] == null || isLarge(next, dp[i + needs[u]])) {
                    dp[i + needs[u]] = next;
                }
            }
        }

        System.out.println(dp[n]);

    }

    boolean isLarge(String a, String t) {
        if (a.length() > t.length()) {
            return true;
        }
        return a.compareTo(t) > 0;
    }

    String next(String cur, int d) {
        for (int i = 0; i < cur.length(); i++) if(d > cur.charAt(i) - '0') {
            return cur.substring(0, i) + d  + cur.substring(i);
        }
        return cur + d;
    }
    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
