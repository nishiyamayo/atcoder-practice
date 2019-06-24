package abc131;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), l = sc.nextInt();

        int[] ar = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            ar[i] = i + l;
            sum += ar[i];
        }
        int d = 100 * 100 * 100, ans = -1;
        for (int i = 0; i < n; i++) if (d > Math.abs(sum - (sum - ar[i]))) {
            d = Math.abs(sum - (sum - ar[i]));
            ans = sum - ar[i];
        }
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
