package abc067;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int n;
    Edge[] g;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        g = new Edge[n];

        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        LinkedList<P> q = new LinkedList<>();
        int b = 0, w = 0;
        q.addLast(new P(0, 0));
        q.addLast(new P(n - 1, 1));
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            P cur = q.removeFirst();
            if (visited[cur.p]) continue;
            if (cur.c == 0) {
                b++;
            } else {
                w++;
            }
            visited[cur.p] = true;

            for (int next : g[cur.p]) {
                q.addLast(new P(next, cur.c));
            }
        }

        debug(b, w);

        out.println(w < b ? "Fennec" : "Snuke");

        out.flush();
    }

    class P {
        int c, p;
        P(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    class Edge extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}