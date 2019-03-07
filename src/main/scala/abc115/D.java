package abc115;

import java.util.Scanner;

public class D {
    // p_sum: 1, 3,  7, 15, ...
    // b_sum: 1, 5, 13, 29, ...
    // 1: BPPPB
    // 2: BBPPPBPBPPPBB
    // 3: BBBPPPBPBPPPBBPBBPPPBPBPPPBBB

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();

        long p = 1;
        long b = 1;
        for (int i = 1; i <= n; i++) {
            p = p * 2 + 1;
            b = b * 2 + 3;
        }

        System.out.println(solve(n, b, p, x));
    }

    long solve(int n, long b, long p, long x) {
//        System.err.println(n + " " + b + " " + p + " " + x);
        if (x <= 0) return 0;
        if (n == 0) return 1;
        if ((b + 1) / 2 > x) {
            return solve(n - 1, (b + 1) / 2 - 2, (p + 1) / 2 - 1, x - 1);
        } else if ((b + 1) / 2 == x) {
            return solve(n - 1, (b + 1) / 2 - 2, (p + 1) / 2 - 1, x - 1) + 1;
        } else {
            return solve(n - 1, (b + 1) / 2 - 2, (p + 1) / 2 - 1, x - (b + 1) / 2) + (p + 1) / 2;
        }
    }

    public static void main(String[] args) {
        new D().run();
    }

}
