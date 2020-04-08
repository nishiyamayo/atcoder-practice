package abc160;

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
        int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
        
        int[] ds = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.min(j - i, Math.min(Math.abs(j - x) + Math.abs(i - y) + 1, Math.abs(j - y) + Math.abs(i - x) + 1));
                ds[d]++;
            }
        }

        for (int i = 1; i < n; i++) {
            out.println(ds[i]);
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