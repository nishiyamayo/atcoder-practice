package abc095;

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
        long c = sc.nextInt();
        long[] x = new long[n + 2], v = new long[n + 2];
        x[n + 1] = c;

        for (int i = 1; i <= n; i++) {
            x[i] = sc.nextLong();
            v[i] = sc.nextLong();
        }

        long[] vl = new long[n + 2], vr = new long[n + 2];
        long vlm = 0, vrm = 0;

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            vl[i] = vl[i - 1] + v[i] - Math.abs(x[i] - x[i - 1]);
            vr[n - i + 1] = vr[n - i + 2] + v[n - i + 1]  - Math.abs(x[n - i + 2] - x[n - i + 1]);
            vlm = Math.max(vlm, vl[i]);
            vrm = Math.max(vrm, vr[n - i + 1]);
            ans = Math.max(ans, vl[i]);
            ans = Math.max(ans, vr[n - i + 1]);
        }

        debug(ans, vlm, vrm);
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, vl[i] - x[i] + vrm);
            ans = Math.max(ans, vr[i] - (c - x[i]) + vlm);
        }

        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}