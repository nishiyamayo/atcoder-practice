package abc138;

import java.io.PrintWriter;
import java.util.*;

public class D {
    int n;
    Edges[] g;
    long[] counter;

    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int q = sc.nextInt();
        g = new Edges[n];
        counter = new long[n];

        for (int i = 0; i < n; i++) {
            g[i] = new Edges();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        for (int i = 0; i < q; i++) {
            int p = sc.nextInt() - 1, x = sc.nextInt();
            counter[p] += x;
        }

        dfs(0, 0, new boolean[n]);

        PrintWriter out = new PrintWriter(System.out);
        out.print(counter[0]);
        for (int i = 1; i < n; i++) {
            out.print(" " + counter[i]);
        }
        out.println();
        out.flush();


    }

    void dfs(int idx, long cnt, boolean[] visited) {
        counter[idx] += cnt;
        visited[idx] = true;

        for (int next: g[idx]) if (!visited[next]) {
            dfs(next, counter[idx], visited);
        }
    }

    class Edges extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        int x = Arrays.binarySearch(new int[] {1, 2, 5, 7}, 6);
        System.out.println(~x);
        new D().run();
    }

}
