package abc190;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);
        long N = sc.nextLong();
        ArrayList<Long> divs = new ArrayList<>();

        for (long i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                divs.add(i);
                if (N / i != i) divs.add(N / i);
            }
        }

        int cnt = 0;
        for (long div : divs) {
            long tar = 2 * N / div;
            if ((tar & 1) != (div & 1)) cnt++;
        }

        out.println(cnt * 2);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
