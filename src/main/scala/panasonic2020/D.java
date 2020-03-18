package panasonic2020;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class D {

    PrintWriter out = new PrintWriter(System.out);
    int N;

    void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        printAns(0, 0, 0, "");
        out.flush();
    }

    void printAns(int d, int curC, int maxC, String s) {
        if (d == 1 && curC == 1) {
            return;
        }
        if (d == N) {
            out.println(s);
            return;
        }

        if (curC == maxC) {
            for (int i = 0; i <= curC + 1; i++) {
                printAns(d + 1, i, Math.max(i, maxC), s + (char) ('a' + i));
            }
        } else {
            for (int i = 0; i <= maxC + 1; i++) {
                printAns(d + 1, i, Math.max(i, maxC), s + (char) ('a' + i));
            }
        }

    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
