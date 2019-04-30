package iroha2019day1;

import java.util.Arrays;
import java.util.Scanner;

public class H {
    static void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int sum = 0;
        for (int i = n.length() - 1; i >= 0; i--) sum += n.charAt(i) - '0';

        StringBuilder ex = new StringBuilder();
        if (sum % 9 != 0) ex.append(sum % 9);
        for (int i = sum / 9; i > 0; i--) ex.append('9');
        String ans = ex.toString();
        debug(ex);
        if (n.equals(ans)) {
            if (ans.charAt(0) == '9') {
                System.out.println("18" + ans.substring(1));
            } else if (ans.length() <= 1) {
                System.out.println("1" + (ans.charAt(0) - '0' - 1));
            } else {
                System.out.println("" + (ans.charAt(0) - '0' + 1) + (ans.charAt(1) - '0' - 1) + ans.substring(2));
            }
        } else {
            System.out.println(ans);
        }
    }
}
