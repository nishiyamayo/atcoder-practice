package iroha2019day2;

import java.util.Arrays;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = " " + sc.next();
        String t = " " + sc.next();
        int ls = s.length(), lt = t.length();
        int[][] dp = new int[ls][lt];

        for (int i = 1; i < ls; i++) for (int j = 1; j < lt; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
            dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 1], dp[i - 1][j]));
        }
        System.out.println(dp[ls - 1][lt - 1] + 1);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
