package exawizards2019;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class F {

    static void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = " " + sc.next();
        String t = " " + sc.next();
        int lens = s.length(), lent = t.length();
        int[][] dp = new int[lens][lent];
        int[][] path = new int[lens][lent];

        dp[0][0] = 0;

        int[] dx = {1, 0, 1}, dy = {0, 1, 1};
        for (int i = 1; i < lens; i++) {
            for (int j = 1; j < lent; j++) {
                if (s.charAt(i) == t.charAt(j) && dp[i - 1][j - 1] + 1 > dp[i][j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    path[i][j] = 2;
                }
                if (dp[i][j] < dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                    path[i][j] = 0;
                }
                if (dp[i][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                    path[i][j] = 1;
                }
            }
        }

        int ps = lens - 1, pt = lent - 1;
        LinkedList<Character> sb = new LinkedList<>();

        while (ps != 0 && pt != 0) {
            if (path[ps][pt] == 2) {
                sb.addFirst(s.charAt(ps));
            }
            int ns = ps - dx[path[ps][pt]];
            int nt = pt - dy[path[ps][pt]];
            ps = ns; pt = nt;
        }
        String ans = sb.stream().map(c -> "" + c).collect(Collectors.joining("", "", ""));
        System.out.println(ans);
    }
}
