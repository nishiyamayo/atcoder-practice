package arc031;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    int H = 10, W = 10;
    boolean[][] b = new boolean[12][12];

    void run() {
        Scanner sc = new Scanner(System.in);
        for (int y = 1; y <= H; y++) {
            String s = sc.next();
            for (int x = 1; x <= W; x++) b[y][x] = s.charAt(x - 1) == 'o';
        }

        System.out.println(solve() ? "YES" : "NO");
    }

    boolean solve() {
        for (int y = 1; y <= H; y++) for (int x = 1; x <= W; x++) {
            if (ok(x, y)) return true;
        }
        return false;
    }

    boolean ok(int sx, int sy) {
        boolean[][] bb = new boolean[12][12];
        for (int y = 0; y < 12; y++) for (int x = 0; x < 12; x++) bb[y][x] = b[y][x];
        bb[sy][sx] = true;

        int cnt = 0;
        for (int y = 1; y <= H; y++) for (int x = 1; x <= W; x++) {
            if (bb[y][x]) {
                dfs(x, y, bb);
                cnt++;
            }
        }

        return cnt <= 1;
    }

    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    void dfs(int x, int y, boolean[][] b) {
        b[y][x] = false;
        for (int i = 0; i < 4; i++) if (b[y + dy[i]][x + dx[i]]) {
            dfs(x + dx[i], y + dy[i], b);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}
