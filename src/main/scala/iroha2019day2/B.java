package iroha2019day2;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong(), y = sc.nextLong();
        long a = sc.nextLong(), b = sc.nextLong();
        long sx = sc.nextLong(), sy = sc.nextLong();
        long tx = sc.nextLong(), ty = sc.nextLong();

        // (0, a), (x, b), (sx, sy), (tx, ty)
        long e = (sx - tx) * (a - sy) + (sy - ty) * (sx - 0);
        long f = (sx - tx) * (b - sy) + (sy - ty) * (sx - x);
        long g = (0 - x) * (sy - a) + (a - b) * (0 - sx);
        long h = (0 - x) * (ty - a) + (a - b) * (0 - tx);

        boolean ok = g * h < 0 && e * f < 0;
        System.out.println(ok ? "Yes" : "No");
    }
}
