package abc171;

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

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        int[] cnts = new int[100001];
        long s = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            cnts[a] += 1;
            s += a;
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int b = sc.nextInt(), c = sc.nextInt();
            s += 1L * c * cnts[b] - 1L * b * cnts[b];
            cnts[c] += cnts[b];
            cnts[b] = 0;
            out.println(s);
        }

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}