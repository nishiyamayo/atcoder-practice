package agc035;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    Edges[] g;
    int[][] ans;
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        g = new Edges[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edges();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        if (m % 2 != 0) {
            System.out.println(-1);
            return;
        } else {

        }
    }

    void solve(int cur, boolean[] visited) {

    }

    class Edges extends ArrayList<Integer> {}

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

}
