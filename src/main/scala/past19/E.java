package past19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        boolean[][] fls = new boolean[n][n];
        boolean[] tmp = new boolean[n];
        int a, b;
        for (int i = 0; i < q; i++) {
            switch (sc.nextInt()) {
                case 1:
                    a = sc.nextInt() - 1;
                    b = sc.nextInt() - 1;
                    fls[a][b] = true;
                    break;
                case 2:
                    a = sc.nextInt() - 1;
                    for (b = 0; b < n; b++) if (fls[b][a]) {
                        fls[a][b] = true;
                    }
                    break;
                case 3:
                    a = sc.nextInt() - 1;
                    Arrays.fill(tmp, false);
                    for (int x = 0; x < n; x++) if (fls[a][x]) {
                        for (b = 0; b < n; b++) if (fls[x][b]) {
                            if (a == b) continue;
                            tmp[b] = true;
                        }
                    }
                    for (b = 0; b < n; b++) {
                        fls[a][b] |= tmp[b];
                    }
                    break;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(fls[i][j] ? 'Y' : 'N');
            System.out.println();
        }

    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
