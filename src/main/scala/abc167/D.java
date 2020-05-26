package abc167;

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
        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt() - 1;
        }

        int[] ds = new int[n];
        Arrays.fill(ds, -1);
        int cur = 0;
        int d = 0;
        while (ds[cur] < 0) {
            ds[cur] = d;
            cur = as[cur];
            d++;
        }

        if (k <= ds[cur]) {
            for (int i = 0; i < n; i++) {
                if (1L * ds[i] == k) {
                    out.println(i + 1);
                    break;
                }
            }
        } else {
            debug(k);
            k -= ds[cur];
            k %= d - ds[cur];
            while (k > 0) {
                cur = as[cur];
                k--;
            }
            out.println(cur + 1);
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