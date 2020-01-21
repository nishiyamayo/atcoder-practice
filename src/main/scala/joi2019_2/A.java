package joi2019_2;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[][] in = new char[N][N], inr = new char[N][N], inl = new char[N][N], inh = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                in[i][j] = inl[j][N - i - 1] = inr[N - j - 1][i] = inh[N - i - 1][N - j - 1] = s.charAt(j);
            }
        }
        for (char[] a: inh) debug(a);

        char[][] out = new char[N][N];
        int c = 0, cl = 1, cr = 1, ch = 2;
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0;j < N; j++) {
                out[i][j] = s.charAt(j);
                c += out[i][j] != in[i][j] ? 1 : 0;
                cl += out[i][j] != inl[i][j] ? 1 : 0;
                cr += out[i][j] != inr[i][j] ? 1 : 0;
                ch += out[i][j] != inh[i][j] ? 1 : 0;
            }
        }

        System.out.println(Math.min(c, Math.min(cl, Math.min(cr, ch))));
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
