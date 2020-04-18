package abc017;

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

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt();
        long[] ar = new long[m + 2];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int l = sc.nextInt(), r = sc.nextInt(), s = sc.nextInt();
            ar[l] += s;
            ar[r + 1] -= s;
            sum += s;
        }

        long min = 1L << 60;
        for (int i = 1; i <= m; i++) {
            ar[i] += ar[i - 1];
            min = Math.min(min, ar[i]);
        }


        out.println(sum - min);


        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}