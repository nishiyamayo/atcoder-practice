package soundhound;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.Function;

public class DJava {

    long INF = 1L << 50;

    void solve() {

    }

    void run() {
        int n = 0, m = 0, s = 0, t = 0;
        E[] g = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] sp = br.readLine().split(" ");

            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);
            s = Integer.parseInt(sp[2]) - 1;
            t = Integer.parseInt(sp[3]) - 1;

            g = new E[n];

            for (int i = 0; i < n; i++) {
                g[i] = new E();
            }

            for (int i = 0; i < m; i++) {
                sp = br.readLine().split(" ");

                int u = Integer.parseInt(sp[0]) - 1;
                int v = Integer.parseInt(sp[1]) - 1;
                long a = Long.parseLong(sp[2]);
                long b = Long.parseLong(sp[3]);

                g[u].add(new V(v, a, b));
                g[v].add(new V(u, a, b));

            }
        } catch (Exception e) {
        }

        long init = (long) 1e15;

        long[] yen = dijkstra(n, s, g, v -> v.a);
        long[] snk = dijkstra(n, t, g, v -> v.b);
        long[] ans = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], init - yen[i] - snk[i]);
        }

        PrintWriter pw = new PrintWriter(System.out);

        for (int i = 0; i < n; i++) {
            pw.println(ans[i]);
        }
        pw.flush();
    }

    public long[] dijkstra(int n, int s, E[] g, Function<V, Long> f) {
        PriorityQueue<P> pq = new PriorityQueue<>();
        long[] visit = new long[n];
        Arrays.fill(visit, INF);
        visit[s] = 0;
        pq.add(new P(s, 0));

        while (!pq.isEmpty()) {
            P cur = pq.remove();
            if (cur.c != visit[cur.p]) continue;

            for (V next : g[cur.p])
                if (visit[next.to] > cur.c + f.apply(next)) {
                    visit[next.to] = cur.c + f.apply(next);
                    pq.add(new P(next.to, cur.c + f.apply(next)));
                }
        }
        return visit;
    }

    private static class E extends ArrayList<V> {
    }

    private static class V {
        int to;
        long a, b;

        public V(int to, long a, long b) {
            this.to = to;
            this.a = a;
            this.b = b;
        }
    }

    private static class P implements Comparable<P> {
        int p;
        long c;

        public P(int p, long c) {
            this.p = p;
            this.c = c;
        }

        @Override
        public int compareTo(P o) {
            return o.c > c ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        new DJava().run();
    }
}
