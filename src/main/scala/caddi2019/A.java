package caddi2019;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class A {

    int l, n, m;
    Map<Integer, Integer> spheres = new TreeMap<>();
    Map<Integer, Integer> points = new TreeMap<>();
    Map<Integer, ANS> ans = new TreeMap<>();
    ES[] graph;

    void run() {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ES[n];

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt(), p = sc.nextInt();
            spheres.put(i, r);
            points.put(i, p);
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt(), d = sc.nextInt();
            graph[a].add(new E(b, c, d));
            graph[b].add(new E(a, c, d));
        }
    }

    class ES extends ArrayList<E> {}

    class E {
        int to, dist, cost;
        E(int to, int dist, int cost) {
            this.to = to;
            this.dist = dist;
            this.cost = cost;
        }
    }

    class ANS {
        int x, y, z;
        ANS(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) {
        new A().run();
    }
}
