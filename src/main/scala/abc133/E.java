package abc133;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {

    int n, k;
    Edges[] g;

    long MOD = (long) 1e9 + 7;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        g = new Edges[n];

        for (int i = 0; i < n; i++) g[i] = new Edges();

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }

        System.out.println(k * solve(0, new boolean[n]) % MOD);
    }

    long solve(int idx, boolean[] visited) {
        visited[idx] = true;
        long ret = 1;

        long useCnt = idx == 0 ? k - 1 : k - 2;

        for (int next: g[idx]) if (!visited[next]) {
            ret = ret * useCnt % MOD;
            useCnt--;
        }
        for (int next: g[idx]) if (!visited[next]) {
            ret = ret * solve(next, visited) % MOD;
        }
        return ret;
    }

    class Edges extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
