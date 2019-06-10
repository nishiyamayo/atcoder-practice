package abc129;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + sc.nextInt();
        }
        int min = sum[n];
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, Math.abs(sum[n] - 2 * sum[i]));
        }
        System.out.println(min);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
