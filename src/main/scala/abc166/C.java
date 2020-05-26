package abc166;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class C {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public C() {
        this(System.in, System.out);
    }

    public C(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int n;
    int[] hs;
    Edge[] g;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt();
        int[] hs = new int[n];
        g = new Edge[n];
        for (int i = 0; i < n; i++) {
            hs[i] = sc.nextInt();
            g[i] = new Edge();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int next: g[i]) {
                if (hs[next] >= hs[i]) {
                    ok = false;
                }
            }
            if (ok) cnt++;
        }
        out.println(cnt);

        out.flush();
    }

    class Edge extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}