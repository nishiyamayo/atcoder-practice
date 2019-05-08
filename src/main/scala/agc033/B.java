package agc033;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        String S = sc.next();
        String T = sc.next();

        int[] dsx = new int[N], dsy = new int[N];
        int[] dtx = new int[N], dty = new int[N];

        for (int i = 0; i < N; i++) {
            dsx[i] = S.charAt(i) == 'U' ? -1 : S.charAt(i) == 'D' ? 1 : 0;
            dsy[i] = S.charAt(i) == 'L' ? -1 : S.charAt(i) == 'R' ? 1 : 0;
            dtx[i] = T.charAt(i) == 'U' ? -1 : T.charAt(i) == 'D' ? 1 : 0;
            dty[i] = T.charAt(i) == 'L' ? -1 : T.charAt(i) == 'R' ? 1 : 0;
        }

        if (ok(H, sx, N, dsx, dtx) || ok(W, sy, N, dsy, dty)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    boolean ok(int L, int S, int N, int[] ds, int[] dt) {
        int s = S;
        for (int i = 0; i < N; i++) {
            if (ds[i] > 0) s++;
            if (s == L + 1) return true;
            if (dt[i] < 0 && s > 1) s--;
        }
        s = S;
        for (int i = 0; i < N; i++) {
            if (ds[i] < 0) s--;
            if (s == 0) return true;
            if (dt[i] > 0 && s < L) s++;
        }
        return false;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
