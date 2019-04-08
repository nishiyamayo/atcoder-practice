package abc123;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] io = new long[5];

        int p = -1;
        for (int i = 0; i < 5; i++) {
            io[i] = sc.nextLong();
            if (p < 0 || io[p] > io[i]) {
                p = i;
            }
        }
        long ans = (n + io[p] - 1) / io[p];
        System.out.println(ans + 4);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
