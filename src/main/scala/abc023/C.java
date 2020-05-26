package abc023;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class C {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public C() {
        this(System.in, System.out);
    }

    public C(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int R = sc.nextInt(), C = sc.nextInt(), K = sc.nextInt();
        int N = sc.nextInt();
        int[] rs = new int[N], cs = new int[N];
        int[] rc = new int[R + 1], cc = new int[C + 1], ccs = new int[C + 1];
        for (int i = 0; i < N; i++) {
            rs[i] = sc.nextInt();
            cs[i] = sc.nextInt();
            rc[rs[i]]++;
            cc[cs[i]]++;
            ccs[cs[i]]++;
        }

        long ans = 0;
        Arrays.sort(ccs);

        debug(rc);
        debug(cc);

        for (int i = 1; i <= R; i++) {
            if (K < rc[i]) continue;
            int l = lowerBound(ccs, K - rc[i]);
            int r = upperBound(ccs, K - rc[i]);
            ans += (r - l);
        }

        for (int i = 0; i < N; i++) {
            if (rc[rs[i]] + cc[cs[i]] == K) ans--;
            if (rc[rs[i]] + cc[cs[i]] - 1 == K) ans++;
        }

        out.println(ans);

        out.flush();
    }

    public int lowerBound(int[] array, int value) {
        int left = 0;
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

    public int upperBound(int[] array, int value) {
        int left = 0;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] > value) {
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
        new C().run();
    }
}