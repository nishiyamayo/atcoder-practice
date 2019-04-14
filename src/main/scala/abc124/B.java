package abc124;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int max = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a >= max) {
                cnt++;
                max = Math.max(a, max);
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        new B().run();
    }
}
