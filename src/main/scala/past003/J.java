package past003;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class J {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public J() {
        this(System.in, System.out);
    }

    public J(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt();
        int[] eats = new int[n];
        for (int i = 0; i < m; i++) {
            int a = -sc.nextInt();
            int idx = upperBound(eats, a);
            if (idx < n) {
                out.println(idx + 1);
                eats[idx] = a;
            } else {
                out.println(-1);
            }
        }

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

    public int upperBound(int[] array, int value) {
        int left = -1;
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
        new J().run();
    }
}