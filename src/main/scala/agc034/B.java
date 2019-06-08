package agc034;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int len = s.length();

        long ans = 0;
        int a = 0;
        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    a++;
                    break;
                case 'B':
                    if (i + 1 < len && s.charAt(i + 1) == 'C') {
                        ans += a;
                        i++;
                    } else {
                        a = 0;
                    }
                    break;
                case 'C':
                    a = 0;
            }
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
