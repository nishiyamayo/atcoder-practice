package past19;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class H {
    long INF = 1L << 60;
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        int[] d = new int[n];
        for (int i = 0; i < n / 2; i++) {
            d[n / 2 + i] = c[2 * i + 1];
            d[i] = c[2 * i];
        }
    }

    class SegmentTree2D {
        int n;
        long[] data, datb;
        SegmentTree2D() {

        }

        void update(int a, int b, int x, int k, int l, int r) {
            if (a <= l && r <= b) {
                data[k] = x;
            } else if (l < b && a < r) {
                datb[k] = (Math.min(b, r) - Math.max(a, l)) * x;
                update(a, b, x, k * 2 + 1, l, (l + r) / 2);
                update(a, b, x, k * 2 + 2, (l + r) / 2, r);
            }
        }

        long min(int a, int b, int k, int l, int r) {
            if (b <= l || r <= a) {
                return INF;
            } else if (a <= l && r <= b) {
                return INF;
            }
            return INF;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new H().run();
    }

}
