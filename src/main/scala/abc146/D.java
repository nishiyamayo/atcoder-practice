package abc146;

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
    Edges[] es;


    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        es = new Edges[n];

        for (int i = 0; i < n; i++) {
            es[i] = new Edges();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            es[a].add(new P(b, i));
            es[b].add(new P(a, i));
        }

        int[] cs = new int[n - 1];

        LinkedList<P> q = new LinkedList<>();
        q.add(new P(0, -1));

        boolean[] visited = new boolean[n];
        int max = 0;
        while (!q.isEmpty()) {
            P cur = q.removeLast();
            visited[cur.a] = true;

            int c = 0;
            for (P next : es[cur.a]) {
                if (visited[next.a]) continue;
                if (c == cur.b) c++;
                cs[next.b] = c;
                max = Math.max(cs[next.b], max);
                q.addFirst(new P(next.a, c++));
            }
        }
        out.println(max + 1);

        for (int i = 0; i < n - 1; i++) {
            out.println(cs[i] + 1);
        }

        out.flush();
    }

    class P implements Comparable<P> {
        int a, b;
        P(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(P o) {
            return o.b - b;
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }
    }

    class Edges extends ArrayList<P> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}