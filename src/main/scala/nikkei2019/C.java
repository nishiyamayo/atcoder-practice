package nikkei2019;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        P[] p = new P[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            p[i] = new P(a[i], b[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int cnt = 0;
        boolean ok = true;

        for (int i = 0; i < n; i++) {
            ok &= a[i] <= b[i];
        }

        System.out.println(ok ? "Yes" : "No");
    }

    public static int lowerBound(P[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle].a >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    class P implements Comparable<P> {
        int a, b;
        P(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(P o) {
            return b - o.b;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }

}
