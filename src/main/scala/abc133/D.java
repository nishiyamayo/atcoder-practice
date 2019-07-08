package abc133;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] as = new long[n], xs = new long[n];
        as[0] = sc.nextInt();
        long s = as[0];


        for (int i = 1; i < n; i++) {
            as[i] = sc.nextInt();
            s += i % 2 == 1 ? -as[i] : as[i];
        }
        PrintWriter out = new PrintWriter(System.out);
        out.print(s);
        for (int i = 1; i < n; i++) {
            s = 2 * as[i - 1] - s;
            out.print(" " + s);
        }
        out.println();
        out.flush();
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
