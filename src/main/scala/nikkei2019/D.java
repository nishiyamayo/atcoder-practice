package nikkei2019;

import java.util.*;

public class D {

    Edge[] g;
    int n;


    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        g = new Edge[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
            if (i != 0) g[i].add(new P(i - 1, 0));
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt() - 1, r = sc.nextInt() - 1, c = sc.nextInt();
            g[l].add(new P(r, c));
        }
        System.out.println(dijkstra());
    }

    long dijkstra() {
        long[] d = new long[n];
        Arrays.fill(d, 1L << 60);
        d[0] = 0;
        PriorityQueue<P> q = new PriorityQueue<>(Comparator.comparingLong(p -> p.c));
        q.add(new P(0, 0));

        while (!q.isEmpty()) {
            P cur = q.remove();
            if (cur.t == n - 1) return cur.c;
            if (cur.c != d[cur.t]) continue;

            for (P next: g[cur.t]) {
                if (d[next.t] > cur.c + next.c) {
                    d[next.t] = cur.c + next.c;
                    q.add(new P(next.t, cur.c + next.c));
                }
            }
        }
        return -1;
    }

    class Edge extends ArrayList<P> {}

    class P {
        int t;
        long c;
        P(int t, long c) {
            this.t = t;
            this.c = c;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
