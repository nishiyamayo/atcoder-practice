package panasonic2020;

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
        String a = sc.next(), b = sc.next(), c = sc.next();

        int al = a.length(), bl = b.length(), cl = c.length();
        int MAX = 100000;
        boolean[] ab = new boolean[MAX], ac = new boolean[MAX], bc = new boolean[MAX];

        for (int i = 0; i < al; i++) {
            for (int j = 0; j < bl; j++) {
                ab[i - j + MAX / 2] |= !ok(a.charAt(i), b.charAt(j));
            }
        }
        for (int i = 0; i < al; i++) {
            for (int j = 0; j < cl; j++) {
                ac[i - j + MAX / 2] |= !ok(a.charAt(i), c.charAt(j));
            }
        }
        for (int i = 0; i < bl; i++) {
            for (int j = 0; j < cl; j++) {
                bc[i - j + MAX / 2] |= !ok(b.charAt(i), c.charAt(j));
            }
        }

        int ans = al + bl + cl;
        int OFFSET = 4010;
        for (int i = -OFFSET; i <= OFFSET; i++) for (int j = -OFFSET; j <= OFFSET; j++) {
            if (!ab[i + MAX / 2] & !ac[j + MAX / 2] & !bc[j - i + MAX / 2]) {
                int l = Math.min(0, Math.min(i, j));
                int r = Math.max(al, Math.max(bl + i, cl + j));
                ans = Math.min(ans, r - l);
            }
        }

        out.println(ans);
        out.flush();
    }

    boolean ok(char x, char y) {
        return x == '?' || y == '?' || x == y;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}