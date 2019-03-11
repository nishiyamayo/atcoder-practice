package wupc2019;

import java.util.ArrayList;
import java.util.Scanner;

public class C {

    int n, m;
    E[] g;
    boolean[] visited;
    ArrayList<Integer> ans;
    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        g = new E[n];
        for (int i = 0; i < n; i++) {
            g[i] = new E();
        }

        visited = new boolean[n];
        ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        solve(0);
        System.out.print(ans.get(0));
        for (int i = 1; i < n; i++) {
            System.out.print(" " + ans.get(i));
        }
        System.out.println();
    }

    void solve(int p) {
        visited[p] = true;
        for (int next: g[p]) if (!visited[next]) {
            solve(next);
        }
        ans.add(p + 1);
    }

    class E extends ArrayList<Integer> {}

    public static void main(String[] args) {
        new C().run();
    }
}
