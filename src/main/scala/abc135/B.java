package abc135;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            if (i != x) cnt++;
        }
        System.out.println((cnt == 2 || cnt == 0) ? "YES": "NO");
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
