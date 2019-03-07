package abc096;

import java.util.Scanner;

public class CJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt(), w = sc.nextInt();

        boolean[][] b = new boolean[h + 2][w + 2];

        for (int y = 0; y < h; y++) {
            String l = sc.next();
            for (int x = 0; x < w; x++) {
                b[y + 1][x + 1] = l.charAt(x) == '#';
            }
        }

        int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};

        for (int y = 1; y <= h; y ++) for (int x = 1; x <= w; x++) if (b[y][x]) {

            boolean ch = false;
            for (int i = 0; i < 4; i ++) {
                ch |= b[y + dy[i]][x + dx[i]];
            }
            if (!ch) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }
}
