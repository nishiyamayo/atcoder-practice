package aising2019;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    int H, W;
    int[][] B;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int BLACK = 0, WHITE = 1, VISITED = 2;

    void run() {
        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        W = sc.nextInt();
        B = new int[H + 2][W + 2];

        Arrays.fill(B[0], VISITED);
        Arrays.fill(B[H + 1], VISITED);

        for (int i = 1; i <=H; i++) {
            Arrays.fill(B[i], VISITED);
            String l = sc.next();
            for (int j = 0; j < W; j++) {
                B[i][j + 1] = l.charAt(j) == '#' ? BLACK : WHITE;
            }
        }

        long ans = 0;
        for (int y = 1; y <= H; y++) for (int x = 1; x <= W; x++) {
            P c = solve(x, y);
            ans += 1L * c.bl * c.wh;
        }

        System.out.println(ans);
    }

    P solve(int x, int y) {
        int cell = B[y][x];
        B[y][x] = VISITED;

        P p = new P(0, 0);
        if (cell == BLACK) {
            p.bl += 1;
        } else if (cell == WHITE) {
            p.wh += 1;
        }

        for (int i = 0; i < 4; i++) if (B[y + dy[i]][x + dx[i]] == 1 - cell) {
            P next = solve(x + dx[i], y + dy[i]);
            p.bl += next.bl;
            p.wh += next.wh;
        }

        return p;
    }

    class P {
        int bl, wh;
        P(int bl, int wh) {
            this.bl = bl;
            this.wh = wh;
        }
    }

    public static void main(String[] args) {
        new C().run();
    }
}
