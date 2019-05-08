package agc033;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {

    int N;
    E[] g;

    void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        g = new E[N];
        for (int i = 0; i < N; i++) g[i] = new E();
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        last = 0;
        max = 0;
        dfs(0, 0, new boolean[N]);
        max = 0;
        dfs(last, 0, new boolean[N]);

        if (max % 3 == 1) {
            System.out.println("Second");
        } else {
            System.out.println("First");

        }
    }
    int last, max;
    void dfs(int p, int d, boolean[] visited) {
        visited[p] = true;
        if (max < d) {
            last = p;
            max = d;
        }
        for (int next: g[p]) if (!visited[next]) {
            dfs(next, d + 1, visited);
        }
    }

    class E extends ArrayList<Integer> {}

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
