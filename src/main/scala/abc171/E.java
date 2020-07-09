package abc171;

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
        int n = sc.nextInt();
        int[] a = new int[n];
        int all = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            all ^= a[i];
        }
        out.print(a[0] ^ all);
        for (int i = 1; i < n; i++) {
            out.print(" " + (a[i] ^ all));
        }
        out.println();

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}