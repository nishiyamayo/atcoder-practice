package abc130;

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
        long k = sc.nextLong();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int l = 0, r = 0;
        long cnt = 0;
        long ans = 0;
        while (r < n) {
            for (;r < n && cnt < k; r++) {
                cnt += a[r];
            }

            for (;l < n && cnt >= k; l++) {
                ans += n - r + 1;
                cnt -= a[l];
            }
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