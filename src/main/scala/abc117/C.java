package abc117;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[] X = new int[m];
        for (int i = 0; i < m; i++) {
            X[i] = sc.nextInt();
        }
        int[] dX = new int[m - 1];
        Arrays.sort(X);
        for (int i = 0; i < m - 1; i++) {
            dX[i] = X[i + 1] - X[i];
        }

        Arrays.sort(dX);
        long sub = 0;
        for (int i = 0; i < Math.min(n - 1, m - 1); i++) {
            sub += dX[m - 2 - i];
        }
        long sum = 0;
        for (int i = 0; i < m - 1; i++) {
            sum += dX[i];
        }

        System.out.println(sum - sub);
    }

    public static void main(String[] args) {
        new C().run();
    }
}
