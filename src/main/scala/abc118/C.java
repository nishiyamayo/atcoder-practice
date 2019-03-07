package abc118;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int ans = Arrays.stream(A)
                .reduce(this::gcd)
                .getAsInt();
        System.out.println(ans);
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
