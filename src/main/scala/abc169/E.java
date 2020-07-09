package abc169;

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

    int n;
    int[] as, bs;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        as = new int[n];
        bs = new int[n];

        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
            bs[i] = sc.nextInt();
        }
        Arrays.sort(as);
        Arrays.sort(bs);

        int min, max;
        if (n % 2 == 0) {
            min = (as[n / 2 - 1] + as[n / 2]);
            max = (bs[n / 2 - 1] + bs[n / 2]);
        } else {
            min = as[n / 2];
            max = bs[n / 2];
        }

        out.println(max - min + 1);
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}