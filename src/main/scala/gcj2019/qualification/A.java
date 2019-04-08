package gcj2019.qualification;

import java.util.Scanner;

public class A {
    Scanner sc = new Scanner(System.in);

    void run() {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i);
        }
    }

    void solve(int T) {
        String N = sc.next();
        int len = N.length();
        int[] a = new int[len];
        int[] b = new int[len];

        for (int i = 0; i < len; i++) {
            a[i] = N.charAt(len - i - 1) - '0';
        }
        b[0] = a[0] == 5 ? 2 : 1;
        int ov = a[0] == 0 ? 1 : 0;
        a[0] = a[0] == 5 ? 3 : (a[0] + 10 - 1) % 10;

        for (int i = 1; i < len; i++) {
            a[i] = (a[i] + 10 - ov) % 10;
            ov = a[i] == 9 && ov == 1 ? 1 : 0;
            b[i] = a[i] == 4 ? 1 : 0;
            a[i] = a[i] == 4 ? 3 : a[i];
        }

        System.out.println(String.format("Case #%d: %s %s", T, ans(a), ans(b)));
    }

    String ans(int[] x) {
        int d = x.length - 1;
        for (;x[d] == 0; d--);
        StringBuffer sb = new StringBuffer();
        for (int i = d; i >= 0; i--) {
            sb.append(x[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new A().run();
    }
}
