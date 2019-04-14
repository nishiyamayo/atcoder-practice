package abc124;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int len = s.length();

        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != ((i % 2 == 0) ? '0' : '1')) {
                cnt0++;
            } else {
                cnt1++;
            }
        }

        System.out.println(Math.min(cnt0, cnt1));
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
