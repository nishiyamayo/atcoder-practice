package abc123;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);

        int[] ar = new int[5];
        for (int i = 0; i < 5; i++) {
            ar[i] = sc.nextInt();
        }

        Arrays.sort(ar);

        System.out.println(solve(0, 0, ar));
    }

    int solve(int cnt, int S, int[] ar) {
        int ret = 1 << 20;
        for (int i = 0; i < 5; i++) if (((S >> i) & 1) == 0) {
            int tmp = cnt;
            if (tmp % 10 != 0) {
                tmp += 10 - tmp % 10;
            }
            ret = Math.min(ret, solve(tmp + ar[i], S | (1 << i), ar));
        }
        if (ret == (1 << 20)) {
            return cnt;
        } else {
            return ret;
        }
    }

    public static void main(String[] args) {
        new B().run();
    }
}
