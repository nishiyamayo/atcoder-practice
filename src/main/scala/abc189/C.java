package abc189;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class C {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long ans = 0;
        for (int l = 0; l < n; l++) {
            int min = a[l];
            for (int r = l; r < n; r++) {
                min = Math.min(min, a[r]);
                ans = Math.max(ans, (long)(r - l + 1) * min);
            }
        }

        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
