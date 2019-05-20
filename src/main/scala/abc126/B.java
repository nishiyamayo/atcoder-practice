package abc126;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    void run() {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        int f = q / 100, b = q % 100;
        if (1 <= f && f <= 12 && (1 > b || 12 < b)) {
            System.out.println("MMYY");
        } else if (1 <= b && b <= 12 && (1 > f || 12 < f)) {
            System.out.println("YYMM");
        } else if (1 <= f && f <= 12 && 1 <= b && b <= 12) {
            System.out.println("AMBIGUOUS");
        } else {
            System.out.println("NA");
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
