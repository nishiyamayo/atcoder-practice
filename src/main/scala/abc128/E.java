package abc128;

import java.io.PrintWriter;
import java.util.*;

public class E {
    int n, q;
    int[] s, t, x;
    int[] ds;
    int[] d;
    long INF = 1L << 60;

    // d + xi が [li, ri) に含まれる最初のxi
    // li <= d + xi < ri
    // li - xi <= d < ri - xi

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        s = new int[n];
        t = new int[n];
        x = new int[n];

        PriorityQueue<Event> que = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            t[i] = sc.nextInt();
            x[i] = sc.nextInt();

            que.add(new Event(s[i] - x[i], x[i], 1));
            que.add(new Event(t[i] - x[i], x[i], 0));
        }

        ds = new int[q];
        int c = 0;
        for (int i = 0; i < q; i++) {
            ds[i] = sc.nextInt();
            que.add(new Event(ds[i], i, 2));
        }

        TreeSet<Integer> set = new TreeSet<>();
        int[] ans = new int[q];
        while (!que.isEmpty()) {
            Event e = que.remove();
            switch (e.type) {
                case 0:
                    set.remove(e.idx);
                    break;
                case 1:
                    set.add(e.idx);
                    break;
                case 2:
                    ans[e.idx] = set.isEmpty() ? -1: set.first();
            }
//            debug(e.t, e.type, e.idx, set);
        }
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < q; i++) {
            out.println(ans[i]);
        }
        out.flush();
    }

    class Event implements Comparable<Event> {
        int t;
        int idx;
        // 0: end, 1: start, 2: query
        int type;

        Event(int t, int idx, int type) {
            this.t = t;
            this.idx = idx;
            this.type = type;
        }

        @Override
        public int compareTo(Event o) {
            if (t == o.t) {
                return type - o.type;
            }
            return t - o.t;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
