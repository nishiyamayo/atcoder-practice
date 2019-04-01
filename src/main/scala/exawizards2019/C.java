package exawizards2019;

import java.util.*;

public class C {

    int n, q;
    String s;
    char[] ts, ds;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); q = sc.nextInt();
        s = " " + sc.next();
        ts = new char[q];
        ds = new char[q];

        for (int i = 0; i < q; i++) {
            ts[i] = sc.next().charAt(0);
            ds[i] = sc.next().charAt(0);
        }

        int l = 0, r = n + 1;
        for (;l + 1 < r;) {
            int mid = (l + r) / 2;
            if (ok(mid, true)) {
                l = mid;
            } else {
                r = mid;
            }
//            debug(mid, ok(mid, false));
        }
//        debug(l);
        int cnt = l;
        l = 0; r = n + 1;
        for (;l + 1 < r;) {
            int mid = (l + r) / 2;
            if (ok(mid, false)) {
                r = mid;
            } else {
                l = mid;
            }
//            debug(mid, ok(mid, false));
        }
//        debug(r);
        cnt += n - r + 1;
        System.out.println(n - cnt);
    }

    boolean ok(int pos, boolean isLeft) {
        for (int i = 0; i < q; i++) {
            if (ts[i] == s.charAt(pos)) {
                if (ds[i] == 'L') {
                    pos--;
                } else {
                    pos++;
                }
            }
            if (pos <= 0 || pos > n) {
                return isLeft ^ pos >= n;
            }
        }
        return false;
    }


    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
