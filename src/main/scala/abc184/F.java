package abc184;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);
        int n = sc.nextInt(), T = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        if (n == 1) {
            if (a[0] > T) {
                out.println(0);
            } else {
                out.println(a[0]);
            }
        } else {
            HashSet<Long> s1 = new HashSet<>(), s2 = new HashSet<>();
            int l = n / 2, r = (n + 1) / 2;

            for (int i = 0; i < (1 << l); i++) {
                long s = 0;
                for (int j = 0; j < l; j++) {
                    if (((i >> j) & 1) == 1) s += a[j];
                }
                s1.add(s);
            }
            for (int i = 0; i < (1 << r); i++) {
                long s = 0;
                for (int j = 0; j < r; j++) {
                    if (((i >> j) & 1) == 1) s += a[l + j];
                }
                s2.add(s);
            }

            long[] left = new long[s1.size()], right = new long[s2.size()];

            int idx = 0;
            for (long v : s1) {
                left[idx++] = v;
            }

            idx = 0;
            for (long v : s2) {
                right[idx++] = v;
            }
            Arrays.sort(left);
            Arrays.sort(right);

//            debug(left);
//            debug(right);

            int cur = right.length - 1;
            long ans = 0;
            for (long v : left) {
                while (cur > 0 && right[cur] + v > T) cur--;
                if (v + right[cur] <= T) ans = Math.max(ans, v + right[cur]);
            }

            out.println(ans);
        }

        out.flush();
    }

    static int lowerBound(long[] array, long value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
