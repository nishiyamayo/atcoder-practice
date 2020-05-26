package abc062;

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
        long[] a = new long[3 * n];
        for (int i = 0; i < 3 * n; i++) {
            a[i] = sc.nextInt();
        }

        long[] left = new long[n + 1];
        long[] right = new long[n + 1];

        PriorityQueue<Long> lq = new PriorityQueue<>();
        PriorityQueue<Long> rq = new PriorityQueue<>(Comparator.reverseOrder());

        long suml = 0, sumr = 0;
        for (int i = 0; i < n; i++) {
            suml += a[i];
            lq.add(a[i]);
            sumr += a[3 * n - i - 1];
            rq.add(a[3 * n - i - 1]);
        }

        left[0] = suml;
        right[n] = sumr;

        for (int i = 0; i < n; i++) {
            lq.add(a[n + i]);
            left[i + 1] = left[i] + a[n + i] - lq.remove();

            rq.add(a[2 * n - i - 1]);
            right[n - i - 1] = right[n - i] + a[2 * n - i - 1] - rq.remove();
        }

//        debug(left);
//        debug(right);

        long ans = - (1L << 60);
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, left[i] - right[i]);
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