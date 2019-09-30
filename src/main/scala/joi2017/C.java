package joi2017;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt(), W = sc.nextInt();
        int[][] A = new int[H][W];
        for (int i = 0; i < H; i++) for (int j = 0; j < W; j++) {
            A[i][j] = sc.nextInt();
        }

        int ans = 1 << 29;
        for (int h = 0; h < H; h++) for (int w = 0; w < W; w++) {
            int sum = 0;
            for (int hh = 0; hh < H; hh++) for (int ww = 0; ww < W; ww++) {
                sum += A[hh][ww] * Math.min(Math.abs(hh - h), Math.abs(ww - w));
            }
            ans = Math.min(ans, sum);
        }
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
