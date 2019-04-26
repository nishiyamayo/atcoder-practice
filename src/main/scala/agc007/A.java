package agc007;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w = sc.nextInt();
        boolean[][] b = new boolean[h + 2][w + 2];

        for (int y = 1; y <= h; y++) {
            String s = sc.next();
            for (int x = 1; x <= w; x++) {
                b[y][x] = s.charAt(x - 1) == '#';
            }
        }
        int x = 1, y = 1;
        boolean ok = true;
        while (true) {
            if (b[y - 1][x] || b[y][x - 1]) {
                System.out.println("Impossible");
                break;
            }

            if (x == w && y == h) {
                System.out.println("Possible");
                break;
            }

            if (b[y][x + 1] == b[y + 1][x]) {
                System.out.println("Impossible");
                break;
            }
            b[y][x] = false;
            int nx = b[y][x + 1] ? x + 1 : x, ny = b[y + 1][x] ? y + 1 : y;
            x = nx;
            y = ny;
        }
    }
}
