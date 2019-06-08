package msolutions2019;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D {

    int n;
    E[] g;
    int[] c;
    boolean[] visited;
    int[] ans;

    void run() {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        g = new E[n];
        for (int i = 0; i < n; i++) g[i] = new E();

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }
        c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        Arrays.sort(c);
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += c[i];
        }

        visited = new boolean[n];
        ans = new int[n];
        dfs(0);

        PrintWriter out = new PrintWriter(System.out);
        out.println(sum);
        out.print(ans[0]);
        for (int i = 1; i < n; i++) {
            out.print(" " + ans[i]);
        }
        out.println();
        out.flush();
    }

    int cnt = 0;
    void dfs(int p) {
        visited[p] = true;
        ans[p] = c[n - cnt - 1];
        cnt++;
        for (int next: g[p]) if (!visited[next]) {
            dfs(next);
        }
    }

    class E extends ArrayList<Integer> {
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
