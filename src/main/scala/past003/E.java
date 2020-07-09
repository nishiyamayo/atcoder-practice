package past003;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public E() {
        this(System.in, System.out);
    }

    public E(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();
        Edge[] g = new Edge[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }

        for (int i = 0; i < m; i++) {
            int u =  sc.nextInt() - 1, v = sc.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        int[] cs = new int[n];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.nextInt();
        }

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();

            if (t == 1) {
                int x = sc.nextInt() - 1;
                out.println(cs[x]);
                for (int next: g[x]) cs[next] = cs[x];
            } else {
                int x = sc.nextInt() - 1, y = sc.nextInt();
                out.println(cs[x]);
                cs[x] = y;
            }
        }

        out.flush();
    }

    class Edge extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}