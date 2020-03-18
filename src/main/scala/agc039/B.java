package agc039;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B {

    int n;
    int[][] es;
    int INF = 1 << 28;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        es = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            for (int j = 0; j < n; j++) {
                es[i][j] = s.charAt(j) == '1' ? 1 : INF;
            }
            es[i][i] = 0;
        }

        dist = new int[n];
        if (dfs(0, -1, 0, new HashSet<>())) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    es[j][k] = Math.min(es[j][k], es[j][i] + es[i][k]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, es[i][j]);
            }
        }
        System.out.println(ans + 1);
    }

    int[] dist;
    boolean dfs(int cur, int par, int d, HashSet<Integer> visited) {
        if (visited.contains(cur)) {
//            debug(cur, par, d, visited);
            return Math.abs(dist[cur] - dist[par]) % 2 == 0;
        }
        visited.add(cur);
        dist[cur] = d;
        for (int i = 0; i < n; i++) if (es[cur][i] != 0 && es[cur][i] != INF) {
            if (i == par) continue;
            if (dfs(i, cur, d + 1, visited)) {
                return true;
            }
        }
        return false;

    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
       new B().run();
    }

}
