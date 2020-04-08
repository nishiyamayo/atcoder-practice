package abc161;

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
        int n = sc.nextInt(), k = sc.nextInt(), c = sc.nextInt();
        String s = sc.next();

        int[] dpl = new int[n + 2], dpr = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == 'x') {
                dpl[i] = dpl[i - 1];
            } else {
                dpl[i] = dpl[Math.max(0, i - c - 1)] + 1;
            }
        }
        dpr[n + 1] = k + 1;
        for (int i = n; i >= 1; i--) {
            if (s.charAt(i - 1) == 'x') {
                dpr[i] = dpr[i + 1];
            } else {
                dpr[i] = dpr[Math.min(n + 1, i + c + 1)] - 1;
            }
        }

//        debug(dpl);
//        debug(dpr);

        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (dpl[i] == dpr[i]) {
                map.put(dpl[i], map.getOrDefault(dpl[i], 0) + 1);
            }
        }
//        debug(map);

        for (int i = 1; i <= n; i++) {
            if (dpl[i] == dpr[i] && dpl[i] <= k && s.charAt(i - 1) == 'o' && map.getOrDefault(dpl[i], -1) == 1) {
                out.println(i);
            }
        }
        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}