package past004;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class L {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] hs = new long[n];
        for (int i = 0; i < n; i++) {
            hs[i] = sc.nextInt();
        }

        HashMap<Long, Integer> mapo = new HashMap<>(), mape = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                mapo.put(hs[i + 1] - hs[i], mapo.getOrDefault(hs[i + 1] - hs[i], 0) + 1);
            } else {
                mape.put(hs[i + 1] - hs[i], mape.getOrDefault(hs[i + 1] - hs[i], 0) + 1);
            }
        }

//        debug(mapo, mape);

        long ev = 0, od = 0;
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                od += sc.nextInt();
                int ans = mapo.getOrDefault(od - ev, 0);
                ans += mape.getOrDefault(ev - od, 0);
                out.println(ans);
//                debug(mapo, mape);
            } else if (t == 2) {
                ev += sc.nextInt();
                int ans = mape.getOrDefault(ev - od, 0);
                ans += mapo.getOrDefault(od - ev, 0);
                out.println(ans);
//                debug(mapo, mape);
            } else {
                int u = sc.nextInt() - 1, v = sc.nextInt();
                if (u % 2 == 0) {
                    if (u < n - 1) mapo.put(hs[u + 1] - hs[u], mapo.get(hs[u + 1] - hs[u]) - 1);
                    if (u > 0) mape.put(hs[u] - hs[u - 1], mape.get(hs[u] - hs[u - 1]) - 1);
                    hs[u] += v;
                    if (u < n - 1) mapo.put(hs[u + 1] - hs[u], mapo.getOrDefault(hs[u + 1] - hs[u], 0) + 1);
                    if (u > 0) mape.put(hs[u] - hs[u - 1], mape.getOrDefault(hs[u] - hs[u - 1], 0) + 1);
                } else {
                    if (u < n - 1) mape.put(hs[u + 1] - hs[u], mape.get(hs[u + 1] - hs[u]) - 1);
                    if (u > 0) mapo.put(hs[u] - hs[u - 1], mapo.get(hs[u] - hs[u - 1]) - 1);
                    hs[u] += v;
                    if (u < n - 1) mape.put(hs[u + 1] - hs[u], mape.getOrDefault(hs[u + 1] - hs[u], 0) + 1);
                    if (u > 0) mapo.put(hs[u] - hs[u - 1], mapo.getOrDefault(hs[u] - hs[u - 1], 0) + 1);

                }
                int ans = mape.getOrDefault(ev - od, 0);
                ans += mapo.getOrDefault(od - ev, 0);
                out.println(ans);
//                debug(ev, od, mapo, mape);
            }
        }

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new L().run();
    }
}
