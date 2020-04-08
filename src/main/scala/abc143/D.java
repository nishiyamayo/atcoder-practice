package abc143;

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
        int[] ls = new int[n];
        for (int i = 0; i < n; i++) {
            ls[i] = sc.nextInt();
        }

        Arrays.sort(ls);

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = Math.max(j + 1, lowerBound(ls, Math.max(ls[j] - ls[i], ls[i] - ls[j] + 1)));
                int r = lowerBound(ls, ls[i] + ls[j]);
                int dup = 0;
                if (l <= i && i < r) dup++;
                if (l <= j && j < r) dup++;
//                debug(i, j, ls[i], ls[j], l, r, r - l - dup);
                cnt += r - l - dup;
            }
        }

        out.println(cnt);

        out.flush();
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
        new D().run();
    }
}