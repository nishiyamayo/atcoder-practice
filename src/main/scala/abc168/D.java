package abc168;

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
        int m = sc.nextInt();
        g = new Edge[n];

        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        int[] ar = new int[n];
        Arrays.fill(ar, -1);
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        ar[0] = 0;
        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            debug(cur);

            for (int next: g[cur]) {
                if (ar[next] == -1) {
                    ar[next] = cur;
                    q.addLast(next);
                }
            }
        }

        boolean ok = true;
        for (int i = 0; i < n; i++) {
            ok &= ar[i] >= 0;
        }

        if (ok) {
            out.println("Yes");
            for (int i = 1; i < n; i++) {
                out.println(ar[i] + 1);
            }
        } else {
            out.println("No");
        }

        out.flush();
    }

    class Edge extends ArrayList<Integer> {}


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}