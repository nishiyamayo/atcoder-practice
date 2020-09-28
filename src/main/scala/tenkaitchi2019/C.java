package tenkaitchi2019;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int[] sum1 = new int[n + 1], sum2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum1[i] = sum1[i - 1] + (s.charAt(n - i) == '#' ? 0 : 1);
            sum2[i] = sum2[i - 1] + (s.charAt(i - 1) == '.' ? 0 : 1);
        }

        int ans = 2 * n;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, sum1[i] + sum2[n - i]);
        }
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
