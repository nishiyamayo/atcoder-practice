package exawizards2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (s.charAt(i) == 'R' ? 1 : 0);
        }
        System.out.println(cnt > n - cnt ? "Yes": "No");
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
