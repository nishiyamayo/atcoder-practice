package abc159;

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
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
            int v = map.getOrDefault(as[i], 0);
            map.put(as[i], v + 1);
        }

        long ans = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            ans += (long) entry.getValue() * (entry.getValue() - 1) / 2;
        }

        for (int i = 0; i < n; i++) {
            long v = map.get(as[i]);
            out.println(ans - v * (v - 1) / 2 + (v - 1) * (v - 2) / 2);
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