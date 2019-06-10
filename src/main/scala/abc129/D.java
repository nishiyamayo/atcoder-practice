package abc129;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    int H, W;

    void run() {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        int[][] var = new int[H + 1][W + 1];
        int[][] hol = new int[W + 1][H + 1];
        boolean[][] ng = new boolean[H + 1][W + 1];
        for (int i = 1; i <= H; i++) {
            String s = sc.next();
            for (int j = 1; j <= W; j++) {
                var[i][j] = s.charAt(j - 1) == '#' ? 1 : 0;
                hol[j][i] = s.charAt(j - 1) == '#' ? 1 : 0;
                ng[i][j] = s.charAt(j - 1) == '#';
            }
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <=W; j++) var[i][j] += var[i][j - 1];
        }
        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <=H; j++) hol[i][j] += hol[i][j - 1];
        }

        int ans = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) if (!ng[i][j]){
                int lv = lowerBound(var[i], var[i][j]);
                int uv = upperBound(var[i], var[i][j]);
                int lh = lowerBound(hol[j], hol[j][i]);
                int uh = upperBound(hol[j], hol[j][i]);
                ans = Math.max(ans, uv - lv + 1 + uh - lh - 4);
//                debug(i, j, uv - lv + 1, uh - lh + 1);
            }
        }

//        debug(var);
//        debug(hol);
        System.out.println(ans);
    }

    public static int lowerBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    public static int upperBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] > value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
