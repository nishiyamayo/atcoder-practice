package abc133;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> sqs = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            sqs.add(i * i);
        }

        int n = sc.nextInt(), d = sc.nextInt();
        int[][] ins = new int[n][d];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < d; j++) {
                ins[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) for (int j = i + 1; j < n; j++) {
            int sum = 0;
            for (int k = 0; k < d; k++) {
                sum += (ins[i][k] - ins[j][k]) * (ins[i][k] - ins[j][k]);
            }
            if (sqs.contains(sum))ans++;
        }
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
