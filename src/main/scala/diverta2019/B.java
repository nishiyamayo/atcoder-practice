package diverta2019;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt(), G = sc.nextInt(), B = sc.nextInt(), N = sc.nextInt();

        long[] RG = new long[N + 1];
        for (int r = 0; r * R <= N; r++) for (int g = 0; g * G <= N - r * R; g++) {
                RG[r * R + g * G]++;
        }

        long ans = 0;
        for (int rg = 0; rg <= N; rg++) for (int b = 0; b * B <= N - rg; b++) {
            if (N == rg + b * B)
                ans += RG[rg];
        }
//        debug(RG);
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
