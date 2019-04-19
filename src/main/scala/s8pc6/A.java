package s8pc6;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), t = sc.nextInt();

        int c = 0, cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            c += a;
            if (c > 0) {
                cnt += (c + t - 1) / t;
                c -= ((c + t - 1) / t) * t;
            }
        }
        System.out.println(cnt);
    }
}
