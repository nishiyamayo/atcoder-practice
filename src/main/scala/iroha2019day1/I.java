package iroha2019day1;

import java.util.*;

public class I {
    int n, m, k;
    E[] g;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
        g = new E[n];

        for (int i = 0; i < n; i++) g[i] = new E();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt();
            g[a].add(new V(b, c));
            g[b].add(new V(a, c));
        }
        long ans = dijkstra();
        if (ans < 0) {
            System.out.println(-1);
        } else {
            System.out.println((ans + 1) * k);
        }
    }

    long dijkstra() {
        PriorityQueue<V> q = new PriorityQueue<>();
        HashMap<V, Long> visited = new HashMap<>();
        for (V v: g[0]) {
            if (!visited.containsKey(v)) {
                q.add(v);
                visited.put(v, 0L);
            }
        }

        while (!q.isEmpty()) {
            V cur = q.remove();
            debug(cur.to, cur.cost, cur.k);
            if (cur.to == n - 1) return cur.k;
            if (visited.get(cur) != cur.k) continue;

            for (V next: g[cur.to]) {
                if (!visited.containsKey(next) || visited.get(next) > cur.k + (cur.cost == next.cost ? 0 : 1)) {
                    q.add(new V(next.to, next.cost, cur.k + (cur.cost == next.cost ? 0 : 1)));
                    visited.put(next, cur.k + (cur.cost == next.cost ? 0 : 1));
                }
            }
        }
        return -1;
    }

    class E extends ArrayList<V> {}

    class V implements Comparable<V> {
        int to, cost;
        long k;
        V(int to, int cost) {
            this.to = to;
            this.cost = cost;
            k = 0;
        }

        V(int to, int cost, long k) {
            this.to = to;
            this.cost = cost;
            this.k = k;
        }

        @Override
        public int hashCode() {
            return to * 100000 + cost;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof V) {
                V v = (V) obj;
                return v.cost == this.cost && v.to == this.to;
            }
            return false;
        }

        @Override
        public int compareTo(V o) {
            return (k - o.k) > 0 ? 1: -1;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new I().run();
    }
}
