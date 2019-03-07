package abc116;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = sc.nextInt();
        int cnt = 0;
        for (;!end(h); cnt++) {
            int l = 0, r = n;
            for (int j = 0; j < n; j++) if (h[j] > 0) {
                l = j;
                break;
            }
            for (int j = l + 1; j < n; j++) if (h[j] == 0) {
                r = j;
                break;
            }
            for (int j = l; j < r; j++) h[j]--;
//            debug(h);
        }

        System.out.println(cnt);
    }

    boolean end(int[] h) {
        return Arrays.stream(h).sum() == 0;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }


    public static void main(String[] args) {
        new C().run();
    }
}
