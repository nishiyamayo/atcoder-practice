package abc133;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class F {

    int n, q;

    Edges[] g;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        g = new Edges[n];
        for (int i = 0; i < n; i++) g[i] = new Edges();
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt(), d = sc.nextInt();
            g[a].add(new Edge(b, c, d));
            g[b].add(new Edge(a, c, d));
        }
    }

    class Edges extends ArrayList<Edge> {}

    class Edge {
        int to, cost, color;
        Edge(int to, int cost, int color) {
            this.to = to;
            this.cost = cost;
            this.color = color;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
