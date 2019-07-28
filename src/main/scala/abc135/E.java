package abc135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int x = sc.nextInt(), y = sc.nextInt();
        int length = Math.abs(x) + Math.abs(y);

    }

    class P {
        int x, y;

        P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int dist(P p) {
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }

        P mult(P dir) {
            return new P(dir.x * x, dir.y * y);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
