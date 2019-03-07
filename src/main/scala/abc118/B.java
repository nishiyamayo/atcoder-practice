package abc118;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] likes  = new int[30];

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                likes[sc.nextInt() - 1]++;
            }
        }
        long cnt = Arrays.stream(likes)
                .filter(x -> x == n)
                .count();

        System.out.println(cnt);

    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
