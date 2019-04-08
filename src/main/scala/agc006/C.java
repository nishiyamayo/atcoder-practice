package agc006;

import java.util.Scanner;

public class C {

    int n;
    double[] x;
    int m;
    long k;
    int[] a;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        m = sc.nextInt();
        k = sc.nextLong();
        a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt() - 1;
        }

        for (int i = 0; i < m; i++) {

        }
    }

    public static void main(String[] args) {
        new C().run();
    }
}
