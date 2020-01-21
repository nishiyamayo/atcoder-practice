package abc146;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong(), B = sc.nextLong(), X = sc.nextLong();

        long l = 0, r = 1000000001L;

        while (l + 1 < r) {
            long c = (l + r) / 2;
            if (value(A, B, c) <= X) {
                l = c;
            } else {
                r = c;
            }
        }
        System.out.println(l);
    }

    long value(long A, long B, long n) {
        int l = ("" + n).length();
        return A * n + B * l;
    }

    public static void main(String[] args) {
        new C().run();
    }

}
