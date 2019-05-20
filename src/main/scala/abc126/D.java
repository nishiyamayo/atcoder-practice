package abc126;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D {

    int n;
    E[] g;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new E[n];
        for (int i = 0; i < n; i++) g[i] = new E();

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1, w = sc.nextInt();
            g[u].add(new P(v, w));
            g[v].add(new P(u, w));
        }

        P st = dfs(0, new boolean[n]);
        P ed = dfs(st.t, new boolean[n]);

        boolean[] ans = new boolean[n];
        draw(ed.t, 0, new boolean[n], ans);

        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            out.println(ans[i] ? 0 : 1);
        }
        out.flush();
    }

    void draw(int p, long c, boolean[] visited, boolean[] color) {
        visited[p] = true;
        color[p] = c % 2 == 0;

        for (P next: g[p]) if (!visited[next.t]) {
            draw(next.t, c + next.w, visited, color);
        }
    }

    P dfs(int p, boolean[] visited) {
        visited[p] = true;

        P c = new P(p, 0);

        for (P next: g[p]) if (!visited[next.t]) {
            P tmp = dfs(next.t, visited);
            tmp.w += next.w;
            if (c.w < tmp.w) {
                c = tmp;
            }
        }

        return c;
    }

    class P implements Comparable<P> {
        int t;
        long w;
        P(int t, long w) {
            this.t = t;
            this.w = w;
        }

        @Override
        public int compareTo(P o) {
            return (w - o.w > 0) ? 1 : -1;
        }
    }

    class E extends ArrayList<P> {}

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
