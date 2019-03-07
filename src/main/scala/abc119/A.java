package abc119;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);

        String[] sp = sc.next().split("/");
        long x = Integer.parseInt(sp[0]) * 10000 + Integer.parseInt(sp[1]) * 100 + Integer.parseInt(sp[2]);

        if (x <= 20190430) {
            System.out.println("Heisei");
        } else {

            System.out.println("TBD");
        }

    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
