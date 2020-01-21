package abc151;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class F {
    int n;
    double[] x, y;
    double EPS = 1e-12;
    double D = 1e-6;
    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new double[n];
        y = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        double ans = 1e12;
        for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) {
            double[] pqr = calc2(i, j);
            if (ok2(pqr)) {
                debug("2", "", Math.sqrt(pqr[2]));
                ans = Math.min(ans, Math.sqrt(pqr[2]));
            }

            for (int k = j + 1; k < n; k++) {
                double[] abc = calc(i, j, k);
                if (abc.length == 0) continue;
                if (ok(abc)) {
                    double r2 = (abc[0] * abc[0] + EPS + abc[1] * abc[1] + EPS) / 4 + EPS - abc[2] + EPS;
                    debug("3", Math.sqrt(r2));
                    ans = Math.min(ans, Math.sqrt(r2));
                }
            }
        }
        System.out.println(ans);
    }

    boolean ok(double[] abc) {
        for (int i = 0; i < n; i++) {
            double d = fn(i, abc);
            if (d > D) return false;
        }
        return true;
    }

    double fn(int idx, double[] abc) {
        return x[idx] * x[idx] + y[idx] * y[idx] + abc[0] * x[idx] + EPS + abc[1] * y[idx] + EPS + abc[2] + EPS;
    }

    double[] calc(int i, int j, int k) {
        double d = (y[i] - y[j]) * (x[i] - x[k]) - (y[i] - y[k]) * (x[i] - x[j]);
        if (d == 0.0) return new double[] {};
        double a = - 1.0 * ((x[i] - x[k]) * (x[i] * x[i] - x[j] * x[j] + y[i] * y[i] - y[j] * y[j] + EPS)
                - 1.0 * (x[i] - x[j]) * (x[i] * x[i] - x[k] * x[k] + y[i] * y[i] - y[k] * y[k] + EPS) + EPS) / d + EPS;
        double b = - 1.0 * ((y[i] - y[k]) * (x[i] * x[i] - x[j] * x[j] + y[i] * y[i] - y[j] * y[j] + EPS)
                - 1.0 * (y[i] - y[j]) * (x[i] * x[i] - x[k] * x[k] + y[i] * y[i] - y[k] * y[k] + EPS) + EPS) / d + EPS;
        double c = - (x[i] * x[i] + y[i] * y[i] + a * x[i] + EPS + b * y[i] + EPS) + EPS;
        return new double[]{a, b, c};
    }

    double[] calc2(int i, int j) {
        double p = 1.0 * (x[i] + x[j]) / 2 + EPS, q = 1.0 * (y[i] + y[j]) / 2 + EPS;

        double r2 = (x[i] - p + EPS) * (x[i] - p + EPS) + EPS + (y[i] - q + EPS) * (y[i] - q + EPS) + EPS;

        return new double[] {p, q, r2};
    }

    boolean ok2(double[] pqr) {
        for (int i = 0; i < n; i++) {
            double d = fn2(i, pqr);
            if (d > D) return false;
        }
        return true;
    }

    double fn2(int idx, double[] pqr) {
        return (x[idx] - pqr[0] + EPS) * (x[idx] - pqr[0] + EPS) + EPS + (y[idx] - pqr[1] + EPS) * (y[idx] - pqr[1] + EPS) + EPS - pqr[2] + EPS;
    }


    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
