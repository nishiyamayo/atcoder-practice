package abc166;

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
        HashMap<Integer, Integer> m1 = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int cnt = m1.getOrDefault(i - a, 0);
            ans += cnt;
            int c = m1.getOrDefault(a + i, 0);
            m1.put(a + i, c + 1);
        }

        out.println(ans);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}