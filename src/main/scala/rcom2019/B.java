package rcom2019;

import java.util.Scanner;

public class B {

    int n, m;
    int[][] A;
    int cnt = 0;

    void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n + 2][n + 2];
        for (int y = 1; y <= n; y++) for (int x = 1; x <= n; x++) {
            A[y][x] = sc.nextInt();
        }

        for (int idx = 0; idx < m; idx++) {
            int tx = -1, ty = -1;

            for (int y = 1; y <= n; y++) for (int x = 1; x <= n; x++) if (A[y][x] != 0) {
                if(tx < 0 || A[ty][tx] < A[y][x]) {
                    tx = x;
                    ty = y;
                }
            }

            if (tx < 0) {
                break;
            }

            dfs(tx, ty, A[ty][tx]);

            System.out.println(2 + " " + (tx - 1) + " " + (ty - 1));
        }
    }

    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    void dfs(int x, int y, int v) {
        A[y][x] = 0;
        cnt++;
        for (int i = 0; i < 4; i++) if (A[y + dy[i]][x + dx[i]] == v) {
            dfs(x + dx[i], y + dy[i], v);
        }
    }

    public static void main(String[] args) {
        new B().run();
    }
}
