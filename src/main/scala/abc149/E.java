package abc149;

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

    int N;
    long M;
    int[] as;
    long[] ss;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        N = sc.nextInt();
        M = sc.nextLong();
        as = new int[N];
        ss = new long[N + 1];
        for (int i = 0; i < N; i++) {
            as[i] = sc.nextInt();
        }
        Arrays.sort(as);
        for (int i = 0; i < N; i++) {
            ss[i + 1] = ss[i] + as[i];
        }

        out.println(ans());

        out.flush();
    }

    long ans() {
        int l = 0, r = 1000000;

        while (r - l > 1) {
            int X = (r + l) / 2;
            if (ok(X)) {
                l = X;
            } else {
                r = X;
            }
        }

        long sum = 0;
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            int t = l - as[i];
            int x = lowerBound(as, t);
            sum += (long) (N - x) * as[i] + ss[N] - ss[x];
            cnt += N - x;
        }
        return sum - (cnt - M) * l;
    }

    boolean ok(int X) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int t = X - as[i];
            int x = lowerBound(as, t);
            sum += N - x;
        }
        return sum >= M;
    }

    public int lowerBound(int[] array, int value) {
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
        new E().run();
    }
}